package com.questcnc.controller;

import com.questcnc.dto.Response.QuestaoResponseDTO;
import com.questcnc.dto.Response.RespostaResponseDTO;
import com.questcnc.dto.request.RespostaRequestDTO;
import com.questcnc.service.QuestaoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // 3️⃣ POST SIMPLES PARA TESTE
    @PostMapping("/teste")
    public ResponseEntity<String> testePost() {
        return ResponseEntity.ok("POST funcionando corretamente!");
    }
}
