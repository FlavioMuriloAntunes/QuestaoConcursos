package service;

import dto.Response.QuestaoResponseDTO;
import dto.Response.RespostaResponseDTO;
import dto.request.RespostaRequestDTO;
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
