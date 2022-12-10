package util;

public class NameValidator {

    private static final String ERROR_ALL = "[ERROR] 이름에는 'all' 을 사용할 수 없습니다.";
    private static final String ALL = "all";
    private static final String DIVIDE = ",";
    private static final String ERROR_LENGTH = "[ERROR] 이름은 5글자 이하여야 합니다.";
    private static final int LIMIT_LENGTH = 5;

    String names;

    public NameValidator(String names) {
        this.names = names;
        validate();
    }

    private void validate() {
        String [] namesArray = names.split(DIVIDE);
        for(int i=0;i< namesArray.length;i++){
            namesArray[i]=namesArray[i].replace(" ","");
            validateEachNameLength(namesArray[i]);
            validateNameNotAll(namesArray[i]);
        }
    }

    private void validateNameNotAll(String name) {
        if(name.equals(ALL)){
            throw new IllegalArgumentException(ERROR_ALL);
        }
    }

    private void validateEachNameLength(String name) {
        if(name.length()> LIMIT_LENGTH){
            throw new IllegalArgumentException(ERROR_LENGTH);
        }
    }
}
