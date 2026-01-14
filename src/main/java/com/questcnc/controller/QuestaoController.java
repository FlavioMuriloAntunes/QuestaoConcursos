package com.questcnc.controller;

import com.questcnc.dto.Response.QuestaoResponseDTO;
import com.questcnc.dto.Response.RespostaResponseDTO;
import com.questcnc.dto.request.QuestaoRequestDTO;
import com.questcnc.dto.request.RespostaRequestDTO;
import com.questcnc.service.QuestaoService;
import jakarta.validation.Valid; // Se der erro, use javax.validation.Valid
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questoes") // 👈 Define a URL base
public class QuestaoController {

    private final QuestaoService service;

    public QuestaoController(QuestaoService service) {
        this.service = service;
    }

    // 1. LISTAR (GET) -> http://localhost:8080/questoes
    @GetMapping
    public ResponseEntity<List<QuestaoResponseDTO>> listar() {
        return ResponseEntity.ok(service.listarQuestoes());
    }

    // 2. CRIAR (POST) -> http://localhost:8080/questoes
    @PostMapping
    public ResponseEntity<QuestaoResponseDTO> criar(@RequestBody @Valid QuestaoRequestDTO dto) {
        QuestaoResponseDTO novaQuestao = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaQuestao);
    }

    // 3. RESPONDER (POST) -> http://localhost:8080/questoes/responder
    
    @PostMapping("/responder")
    public ResponseEntity<RespostaResponseDTO> responder(@RequestBody @Valid RespostaRequestDTO dto) {
        return ResponseEntity.ok(service.responder(dto));
    }
}