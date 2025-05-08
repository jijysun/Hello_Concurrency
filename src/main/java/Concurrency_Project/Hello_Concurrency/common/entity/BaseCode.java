package Concurrency_Project.Hello_Concurrency.common.entity;

import Concurrency_Project.Hello_Concurrency.common.entity.error.ReasonDto;

public interface BaseCode {

    ReasonDto getReason();

    ReasonDto getReasonHttpStatus();
}