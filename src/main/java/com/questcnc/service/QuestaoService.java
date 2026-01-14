package com.questcnc.service;

import com.questcnc.dto.Response.AlternativaResponseDTO;
import com.questcnc.dto.Response.QuestaoResponseDTO;
import com.questcnc.dto.Response.RespostaResponseDTO;
import com.questcnc.dto.request.QuestaoRequestDTO;
import com.questcnc.dto.request.RespostaRequestDTO;
import com.questcnc.model.Alternativa;
import com.questcnc.model.Questao;
import com.questcnc.repository.QuestaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestaoService {

    private final QuestaoRepository repository;

    public QuestaoService(QuestaoRepository repository) {
        this.repository = repository;
    }

    // 1️⃣ LISTAR
    @Transactional(readOnly = true)
    public List<QuestaoResponseDTO> listarQuestoes() {
        return repository.findAll().stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    // 2️⃣ CRIAR
    @Transactional
    public QuestaoResponseDTO criar(QuestaoRequestDTO dto) {
        Questao questao = new Questao();
        questao.setEnunciado(dto.getEnunciado());
        
        // Lembrete: Se der erro de SQL, verifique se a Categoria no Model está como nullable=true

        List<Alternativa> listaAlternativas = new ArrayList<>();
        listaAlternativas.add(criarAlternativa(dto.getAlternativaA(), "A", dto.getCorreta(), questao));
        listaAlternativas.add(criarAlternativa(dto.getAlternativaB(), "B", dto.getCorreta(), questao));
        listaAlternativas.add(criarAlternativa(dto.getAlternativaC(), "C", dto.getCorreta(), questao));
        listaAlternativas.add(criarAlternativa(dto.getAlternativaD(), "D", dto.getCorreta(), questao));

        if (dto.getAlternativaE() != null && !dto.getAlternativaE().isBlank()) {
            listaAlternativas.add(criarAlternativa(dto.getAlternativaE(), "E", dto.getCorreta(), questao));
        }

        questao.setAlternativas(listaAlternativas);
        
        Questao questaoSalva = repository.save(questao);

        return converterParaDTO(questaoSalva);
    }

    // 3️⃣ RESPONDER (COM A CORREÇÃO DO NULL SAFETY)
    public RespostaResponseDTO responder(RespostaRequestDTO dto) {
        
        // 👇 Verificação manual para remover o aviso amarelo do Java
        Long idQuestao = dto.getQuestaoId();
        if (idQuestao == null) {
            throw new IllegalArgumentException("O ID da questão é obrigatório!");
        }

        Questao questao = repository.findById(idQuestao)
                .orElseThrow(() -> new RuntimeException("Questão não encontrada"));

        int indice = converterLetraParaIndice(dto.getAlternativaEscolhida());
        boolean acertou = false;
        
        if (indice >= 0 && indice < questao.getAlternativas().size()) {
            acertou = questao.getAlternativas().get(indice).isCorreta();
        }

        return new RespostaResponseDTO(acertou, acertou ? "Parabéns, você acertou!" : "Que pena, você errou.");
    }

    // ==========================================
    // MÉTODOS AUXILIARES
    // ==========================================

    private Alternativa criarAlternativa(String texto, String letraAtual, String letraCorreta, Questao q) {
        boolean ehCorreta = letraAtual.equalsIgnoreCase(letraCorreta);
        return new Alternativa(texto, ehCorreta, q);
    }

    private QuestaoResponseDTO converterParaDTO(Questao q) {
        QuestaoResponseDTO dto = new QuestaoResponseDTO();
        dto.setId(q.getId());
        dto.setEnunciado(q.getEnunciado());

        List<AlternativaResponseDTO> listaDTO = q.getAlternativas().stream()
                .map(alt -> new AlternativaResponseDTO(alt.getId(), alt.getTexto()))
                .collect(Collectors.toList());

        dto.setAlternativas(listaDTO);
        
        return dto;
    }

    private int converterLetraParaIndice(String letra) {
        if (letra == null) return -1;
        switch (letra.toUpperCase()) {
            case "A": return 0;
            case "B": return 1;
            case "C": return 2;
            case "D": return 3;
            case "E": return 4;
            default: return -1;
        }
    }
}