package service;

import model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class AuthService {
    private List<Usuario> usuarios = new ArrayList<>();

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario login(String matricula, String senha) {
        for (Usuario user : usuarios) {
            if (user.getMatricula().equals(matricula) && user.getSenha().equals(senha)) {
                return user;
            }
        }
        return null;
    }
}