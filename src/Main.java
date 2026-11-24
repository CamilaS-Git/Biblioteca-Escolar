import model.enums.*;
import model.Usuario;
import service.AuthService;
import view.LoginView;

public class Main {
    public static void main(String[] args) {
        AuthService authService = new AuthService();

        authService.cadastrarUsuario(new Usuario(1, "Maria", "2024001", "1234", Perfil.ALUNO));
        authService.cadastrarUsuario(new Usuario(2, "Ana", "BIB001", "admin", Perfil.BIBLIOTECARIO));

        new LoginView(authService).exibirLogin();
    }
}