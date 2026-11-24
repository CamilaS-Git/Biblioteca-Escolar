package model;

import java.time.LocalDate;

public class Emprestimo {
    private Exemplar exemplar;
    private Usuario usuario;
    private LocalDate dataLimiteDevolver;
    private LocalDate dataDevolucao;
    private double multa;

    public Emprestimo(Exemplar exemplar, Usuario usuario, LocalDate dataLimiteDevolver) {
        this.exemplar = exemplar;
        this.usuario = usuario;
        this.dataLimiteDevolver = dataLimiteDevolver;
    }

    public Exemplar getExemplar() { return exemplar; }
    public Usuario getUsuario() { return usuario; }
    public LocalDate getDataLimiteDevolver() { return dataLimiteDevolver; }
    public LocalDate getDataDevolucao() { return dataDevolucao; }
    public void setDataDevolucao(LocalDate dataDevolucao) { this.dataDevolucao = dataDevolucao; }
    public double getMulta() { return multa; }
    public void setMulta(double multa) { this.multa = multa; }
}
