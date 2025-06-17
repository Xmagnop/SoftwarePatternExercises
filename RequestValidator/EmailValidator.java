public class EmailValidator extends BaseRequestValidator {
    @Override
    public void validate(UserRequest request) {
        System.out.println("[EmailValidator] Validando e-mail...");
        if (request.getEmail() == null || !request.getEmail().contains("@")) {
            System.out.println("E-mail inválido. Cadastro rejeitado.");
            return;
        }
        super.validate(request);
    }
}
