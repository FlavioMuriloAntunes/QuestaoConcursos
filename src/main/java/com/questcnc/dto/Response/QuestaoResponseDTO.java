package com.questcnc.dto.Response;

import java.util.List;

public class QuestaoResponseDTO {

    private Long id;
    private String enunciado;
    private List<AlternativaResponseDTO> alternativas;

    public QuestaoResponseDTO() {
    }

    public QuestaoResponseDTO(Long id,
                              String enunciado,
                              List<AlternativaResponseDTO> alternativas) {
        this.id = id;
        this.enunciado = enunciado;
        this.alternativas = alternativas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public List<AlternativaResponseDTO> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<AlternativaResponseDTO> alternativas) {
        this.alternativas = alternativas;
    }
}
