package dto.request;

public class RespostaRequestDTO {

    private Long questaoId;
    private Long alternativaId;

    // =========================
    // Construtor
    // =========================

    public RespostaRequestDTO() {
    }

    // =========================
    // Getters e Setters
    // =========================

    public Long getQuestaoId() {
        return questaoId;
    }

    public void setQuestaoId(Long questaoId) {
        this.questaoId = questaoId;
    }

    public Long getAlternativaId() {
        return alternativaId;
    }

    public void setAlternativaId(Long alternativaId) {
        this.alternativaId = alternativaId;
    }
}
