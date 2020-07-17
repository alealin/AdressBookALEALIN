package Constants;

public enum ResponseCode {
    UNKNOWN_PROBLEM(000),
    CONTACT_NOT_FOUND(404),
    CONTACT_EXIST (303),
    WRONG_DATA_INPUT(505),
    SERVER_ERROR(500);

    private int code;

    ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}


