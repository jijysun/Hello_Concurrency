package Concurrency_Project.Hello_Concurrency.user.exception;

import Concurrency_Project.Hello_Concurrency.common.apiPayload.code.BaseErrorCode;
import Concurrency_Project.Hello_Concurrency.common.apiPayload.exception.GeneralException;

public class UserException extends GeneralException {
    public UserException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
