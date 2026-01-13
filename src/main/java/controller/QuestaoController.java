package controller;

import dto.Response.QuestaoResponseDTO;
import dto.Response.RespostaResponseDTO;
import dto.request.RespostaRequestDTO;
import service.QuestaoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questoes")
public class QuestaoController {

    private final QuestaoService service;

    public QuestaoController(QuestaoService service) {
        this.service = service;
    }

    // 1️⃣ Listar todas as questões
    @GetMapping
    public ResponseEntity<List<QuestaoResponseDTO>> listarQuestoes() {
        List<QuestaoResponseDTO> questoes = service.listarQuestoes();
        return ResponseEntity.ok(questoes);
    }

    // 2️⃣ Receber a resposta do usuário
    @PostMapping("/responder")
    public ResponseEntity<RespostaResponseDTO> responder(
            @RequestBody RespostaRequestDTO dto) {

        RespostaResponseDTO resposta = service.responder(dto);
        return ResponseEntity.ok(resposta);
    }
}
