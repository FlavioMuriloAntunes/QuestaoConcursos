package com.questcnc.dto.request;

// Se estiver usando Spring Boot 3, use jakarta.validation
// Se for antigo, use javax.validation
import jakarta.validation.constraints.NotBlank;
import lombok.Data; // Se usar Lombok (ou crie Getters e Setters manualmente)

@Data
public class QuestaoRequestDTO {

    @NotBlank(message = "O enunciado é obrigatório")
    private String enunciado;

    // Aqui estou assumindo que você salva as alternativas como campos separados.
    // Se você usa uma lista List<Alternativa>, me avise que ajustamos!
    @NotBlank(message = "Alternativa A é obrigatória")
    private String alternativaA;

    @NotBlank(message = "Alternativa B é obrigatória")
    private String alternativaB;

    @NotBlank(message = "Alternativa C é obrigatória")
    private String alternativaC;

    @NotBlank(message = "Alternativa D é obrigatória")
    private String alternativaD;

    private String alternativaE; // Opcional

    @NotBlank(message = "Indique qual a alternativa correta (ex: 'A')")
    private String correta; 
}