package dto.Response;

public class RespostaResponseDTO {

    private boolean correta;
    private String mensagem;

    // =========================
    // Construtores
    // =========================

    public RespostaResponseDTO() {
    }

    public RespostaResponseDTO(boolean correta, String mensagem) {
        this.correta = correta;
        this.mensagem = mensagem;
    }

    // =========================
    // Getters e Setters
    // =========================

    public boolean isCorreta() {
        return correta;
    }

    public void setCorreta(boolean correta) {
        this.correta = correta;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
