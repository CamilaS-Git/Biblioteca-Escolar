package service;

import model.*;
import model.enums.Perfil;
import model.enums.StatusExemplar;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class EmprestimoService {
    private static final int PRAZO_DIAS = 7;
    private static final double MULTA_POR_DIA_ATRASO = 2.0;

    private Map<Integer, Exemplar> exemplares = new HashMap<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void cadastrarExemplar(Exemplar exemplar) {
        exemplares.put(exemplar.getId(), exemplar);
    }

    public Emprestimo emprestarExemplar(int exemplarId, Usuario aluno, Usuario bibliotecario) {
        if (bibliotecario.getPerfil() != Perfil.BIBLIOTECARIO) {
            throw new RuntimeException("Apenas o bibliotecário pode registrar empréstimos.");
        }
        Exemplar exemplar = exemplares.get(exemplarId);

        if (exemplar == null) {
            throw new RuntimeException("Exemplar não encontrado.");
        }
        if (exemplar.getStatus() != StatusExemplar.DISPONIVEL) {
            throw new RuntimeException("Exemplar indisponível para empréstimo.");
        }

        exemplar.setStatus(StatusExemplar.EMPRESTADO);
        Emprestimo emprestimo = new Emprestimo(exemplar, aluno, LocalDate.now().plusDays(PRAZO_DIAS));
        emprestimos.add(emprestimo);
        return emprestimo;
    }

    public Emprestimo devolverExemplar(int IdExemplar) {
        Emprestimo emprestimo = buscarEmprestimoAberto(IdExemplar);
        LocalDate hoje = LocalDate.now();

        long diasAtraso = ChronoUnit.DAYS.between(emprestimo.getDataLimiteDevolver(), hoje);
        if (diasAtraso > 0) {
            emprestimo.setMulta(diasAtraso * MULTA_POR_DIA_ATRASO);
        }

        emprestimo.setDataDevolucao(hoje);
        emprestimo.getExemplar().setStatus(StatusExemplar.DISPONIVEL);
        return emprestimo;
    }

    private Emprestimo buscarEmprestimoAberto(int IdExemplar) {
        for (Emprestimo e : emprestimos) {
            if (e.getExemplar().getId() == IdExemplar && e.getDataDevolucao() == null) {
                return e;
            }
        }
        throw new RuntimeException("Não há empréstimo aberto para este exemplar.");
    }
}