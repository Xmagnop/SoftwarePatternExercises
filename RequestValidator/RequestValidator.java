public interface RequestValidator {
    void setNextValidator(RequestValidator next);
    void validate(UserRequest request);
}
