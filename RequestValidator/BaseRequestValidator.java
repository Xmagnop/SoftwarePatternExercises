public abstract class BaseRequestValidator implements RequestValidator {
    private RequestValidator next;

    @Override
    public void setNextValidator(RequestValidator next) {
        this.next = next;
    }

    @Override
    public void validate(UserRequest request) {
        if (next != null) {
            next.validate(request);
        } else {
            System.out.println("Cadastro aprovado!");
        }
    }
}
