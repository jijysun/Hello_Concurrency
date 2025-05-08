package Concurrency_Project.Hello_Concurrency.common.apiPayload.code.status;

import Concurrency_Project.Hello_Concurrency.common.apiPayload.code.BaseCode;
import Concurrency_Project.Hello_Concurrency.common.apiPayload.code.ReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {
    _OK (HttpStatus.OK, "COMMON200", "성공입니다"),
    _LOGIN_SUCCESS(HttpStatus.OK, "COMMON201", "로그인에 성공했습니다."),
    _LOGOUT_SUCCESS(HttpStatus.OK, "COMMON202", "로그아웃에 성공했습니다."),
    _SIGN_IN_SUCCESS(HttpStatus.CREATED, "COMMON203", "회원가입에 성공했습니다."),
    _IN_PROCESSING(HttpStatus.ACCEPTED, "COMMON204", "이미 정상정으로 받은 요청입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;


    @Override
    public ReasonDto getReason() {
        return ReasonDto.builder()
                .isSuccess(true)
                .code(code)
                .message(message)
                .build();
    }

    @Override
    public ReasonDto getReasonHttpStatus() {
        return ReasonDto.builder()
                .httpStatus(status)
                .isSuccess(true)
                .code(code)
                .message(message)
                .build();
    }
}
