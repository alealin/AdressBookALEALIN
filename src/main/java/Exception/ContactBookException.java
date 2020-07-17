package Exception;

import Constants.ConstantsMessages;
import Constants.ResponseCode;

public class ContactBookException extends Exception {

    private ResponseCode code;
    private String message;

    public ContactBookException(ResponseCode code, String message) {
        this.code = code;
        this.message = message;
    }

    public ContactBookException() {
        this.code = ResponseCode.UNKNOWN_PROBLEM;
        this.message = ConstantsMessages.UNKNOWN_PROBLEM;
    }

    public void Message() {
        System.out.println(message + " " + code.getCode()); ;
    }
}