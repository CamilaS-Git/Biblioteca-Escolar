package view;

import model.enums.*;
import model.Usuario;
import service.AuthService;
import java.util.Scanner;

public class LoginView {
    private AuthService authService;

    public LoginView(AuthService authService) {
        this.authService = authService;
    }

    public void exibirLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== BIBLIOTECA ESCOLAR ===");
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Usuario usuario = authService.login(matricula, senha);

        if (usuario == null) {
            System.out.println("Matrícula ou senha inválida.");
        } else if (usuario.getPerfil() == Perfil.ALUNO) {
            System.out.println("Bem-vindo, " + usuario.getNome() + " (aluno)");
        } else {
            System.out.println("Bem-vindo, " + usuario.getNome() + " (bibliotecário)");
        }
    }
}
