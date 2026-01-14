package com.questcnc.dto.request;

import jakarta.validation.constraints.NotBlank; // Import para validar String
import jakarta.validation.constraints.NotNull;  // Import para validar Long/Objeto
import lombok.Data;

@Data
public class RespostaRequestDTO {
    
    // @NotNull garante que o ID nunca seja nulo
    @NotNull(message = "O ID da questão é obrigatório")
    private Long questaoId;
    
    // @NotBlank garante que não venha nulo e nem vazio ""
    @NotBlank(message = "A alternativa escolhida é obrigatória")
    private String alternativaEscolhida; 
}