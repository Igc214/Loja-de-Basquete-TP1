package igor.projeto.tp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import java.util.List;
import java.util.ArrayList;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class TenisPerformance extends DefaultEntity {

    private String nome;
    private int numeroDoPe;
    private String cor;
    private String descricao;
    private int edicaoLimitada;
    private boolean autografado;

    @Column(name = "codigo_posicao")
    private Posicao posicao;

    @Column(name = "codigo_TipoSolado")
    private TipoSolado tipoSolado;

    @ManyToOne
    private Fabricante fabricante;

    @OneToMany(mappedBy = "tenisPerformance", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public int getNumeroDoPe() {
        return numeroDoPe;
    }

    public void setNumeroDoPe(int numeroDoPe) {
        this.numeroDoPe = numeroDoPe;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao( Posicao posicao) {
        this.posicao = posicao;
    }

    public TipoSolado getTipoSolado() {
        return tipoSolado;
    }

    public void setTipoSolado(TipoSolado tipoSolado) {
        this.tipoSolado = tipoSolado;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEdicaoLimitada() {
        return edicaoLimitada;
    }

    public void setEdicaoLimitada(int edicaoLimitada) {
        this.edicaoLimitada = edicaoLimitada;
    }

    public boolean isAutografado() {
        return autografado;
    }

    public void setAutografado(boolean autografado) {
        this.autografado = autografado;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    

}