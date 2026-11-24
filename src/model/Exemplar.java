package model;

import model.enums.StatusExemplar;

public class Exemplar {
    private int id;
    private Livro livro;
    private String codigo;
    private StatusExemplar status = StatusExemplar.DISPONIVEL;

    public Exemplar(int id, String codigo, Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("O exemplar precisa de um livro.");
        }
        this.codigo = codigo;
        this.id = id;
        this.livro = livro;
    }

    public int getId() {
        return id;
    }

    public String getCodigo() {return codigo;}

    public Livro getLivro() {
        return livro;
    }

    public StatusExemplar getStatus() {
        return status;
    }

    public void setStatus(StatusExemplar status) {
        this.status = status;
    }
}