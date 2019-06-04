package Exception;

public enum ResponseCode {
    NOT_FOUND(404),
    OBGECT_EXIST (302);


    private int code;

    ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}