package util.validators;

public class HeightValidator {

    private static final String ERROR_VALUE = "[ERROR] 높이는 1 이상이어야 합니다.";
    private static final String ERROR_TYPE = "[ERROR] 높이는 숫자만 입력해야 합니다.";
    String height;

    public HeightValidator(String height) {
        this.height = height;
        validate();
    }

    private void validate() {
        validateType();
        validateValue();
    }

    private void validateValue() {
        if(Integer.parseInt(height)<1){
            throw new IllegalArgumentException(ERROR_VALUE);
        }
    }

    private void validateType() {
        try{
            Integer.parseInt(height);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR_TYPE);
        }
    }
}
