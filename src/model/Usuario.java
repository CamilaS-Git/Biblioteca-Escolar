package model;

import model.enums.Perfil;

public class Usuario {
    private int id;
    private String nome;
    private String matricula;
    private String senha;
    private Perfil perfil;

    public Usuario(int id, String nome, String matricula, String senha, Perfil perfil) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.senha = senha;
        this.perfil = perfil;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }
    public String getSenha() { return senha; }
    public Perfil getPerfil() { return perfil; }
}