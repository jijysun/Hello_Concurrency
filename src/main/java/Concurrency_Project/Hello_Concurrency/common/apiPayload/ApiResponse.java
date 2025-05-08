package Concurrency_Project.Hello_Concurrency.common.apiPayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder
public class ApiResponse<T> {


    @JsonProperty
    private boolean success;

    private String code;

    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;


    public static <T> ApiResponse<T> onFailure (String code, String message, T data){
        return new ApiResponse<>(false, code,message, data);
    }
}
