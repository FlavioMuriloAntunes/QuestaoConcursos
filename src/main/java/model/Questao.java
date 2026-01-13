package model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "questoes")
public class Questao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String enunciado;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @OneToMany(
        mappedBy = "questao",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Alternativa> alternativas;

    @Column(nullable = false)
    private boolean ativa = true;

    @Column(nullable = false)
    private LocalDateTime criadaEm;

    // =========================
    // Construtores
    // =========================

    public Questao() {
        this.criadaEm = LocalDateTime.now();
    }

    public Questao(String enunciado, Categoria categoria, List<Alternativa> alternativas) {
        this.enunciado = enunciado;
        this.categoria = categoria;
        this.alternativas = alternativas;
        this.ativa = true;
        this.criadaEm = LocalDateTime.now();
    }

    // =========================
    // Getters e Setters
    // =========================

    public Long getId() {
        return id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public LocalDateTime getCriadaEm() {
        return criadaEm;
    }
}
