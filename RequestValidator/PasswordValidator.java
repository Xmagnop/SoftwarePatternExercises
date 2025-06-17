public class PasswordValidator extends BaseRequestValidator {
    @Override
    public void validate(UserRequest request) {
        System.out.println("[PasswordValidator] Validando senha...");
        if (request.getPassword() == null || request.getPassword().length() < 8) {
            System.out.println("Senha inválida. Cadastro rejeitado.");
            return;
        }
        super.validate(request);
    }
}
