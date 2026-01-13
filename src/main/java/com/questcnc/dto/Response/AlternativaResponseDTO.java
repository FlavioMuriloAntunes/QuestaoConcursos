package com.questcnc.dto.Response;

public class AlternativaResponseDTO {

    private Long id;
    private String texto;

    // =========================
    // Construtores
    // =========================

    public AlternativaResponseDTO() {
    }

    public AlternativaResponseDTO(Long id, String texto) {
        this.id = id;
        this.texto = texto;
    }

    // =========================
    // Getters e Setters
    // =========================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
