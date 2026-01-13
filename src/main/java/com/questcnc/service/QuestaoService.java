package com.questcnc.service;

import com.questcnc.dto.Response.QuestaoResponseDTO;
import com.questcnc.dto.Response.RespostaResponseDTO;
import com.questcnc.dto.request.RespostaRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestaoService {

    public List<QuestaoResponseDTO> listarQuestoes() {
        return List.of(); // depois ligamos no repository
    }

    public RespostaResponseDTO responder(RespostaRequestDTO dto) {
        return new RespostaResponseDTO(
                true,
                "Resposta correta!"
        );
    }
}
