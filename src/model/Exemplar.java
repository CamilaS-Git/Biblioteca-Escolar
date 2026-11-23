package Model;

import model.Livro;
import model.StatusExemplar;

public class Exemplar {
    private int id;
    private Livro livro;
    private StatusExemplar status = StatusExemplar.DISPONIVEL;

    public Exemplar(int id, Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("O exemplar precisa de um livro.");
        }
        this.id = id;
        this.livro = livro;
    }

    public int getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public StatusExemplar getStatus() {
        return status;
    }

    public void emprestar() {
        if (status != StatusExemplar.DISPONIVEL) {
            throw new IllegalArgumentException("Exemplar indisponível para empréstimo.");
        }
        status = StatusExemplar.EMPRESTADO;
    }

    public void devolver() {
        if (status != StatusExemplar.EMPRESTADO) {
            throw new IllegalArgumentException("Este exemplar não está emprestado.");
        }
        status = StatusExemplar.DISPONIVEL;
    }
}