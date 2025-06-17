public class UsernameValidator extends BaseRequestValidator {
    @Override
    public void validate(UserRequest request) {
        System.out.println("[UsernameValidator] Validando username...");
        if (request.getUsername() == null || request.getUsername().trim().isEmpty()) {
            System.out.println("Username inválido. Cadastro rejeitado.");
            return;
        }
        super.validate(request);
    }
}
