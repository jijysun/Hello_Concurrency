package Concurrency_Project.Hello_Concurrency.common.entity;

import Concurrency_Project.Hello_Concurrency.common.entity.error.ErrorReasonDto;

public interface BaseErrorCode {

    ErrorReasonDto getReason();

    ErrorReasonDto getReasonHttpStatus();
}
