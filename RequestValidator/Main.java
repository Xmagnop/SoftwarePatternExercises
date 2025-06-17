public class Main {
    public static void main(String[] args) {
        // Montar cadeia de validadores
        RequestValidator emailValidator = new EmailValidator();
        RequestValidator passwordValidator = new PasswordValidator();
        RequestValidator usernameValidator = new UsernameValidator();

        emailValidator.setNextValidator(passwordValidator);
        passwordValidator.setNextValidator(usernameValidator);

        // Cenário 1: E-mail inválido
        System.out.println("\n--- Cenário 1: E-mail inválido ---");
        UserRequest request1 = new UserRequest("usuario.com", "senhaSegura123", "usuario1");
        emailValidator.validate(request1);

        // Cenário 2: Senha inválida
        System.out.println("\n--- Cenário 2: Senha inválida ---");
        UserRequest request2 = new UserRequest("usuario@exemplo.com", "123", "usuario2");
        emailValidator.validate(request2);

        // Cenário 3: Username inválido
        System.out.println("\n--- Cenário 3: Username inválido ---");
        UserRequest request3 = new UserRequest("usuario@exemplo.com", "senhaSegura123", "");
        emailValidator.validate(request3);

        // Cenário 4: Todos válidos (sucesso)
        System.out.println("\n--- Cenário 4: Cadastro válido ---");
        UserRequest request4 = new UserRequest("usuario@exemplo.com", "senhaSegura123", "usuario4");
        emailValidator.validate(request4);
    }
}
