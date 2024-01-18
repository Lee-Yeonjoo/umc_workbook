package dev.umc.spring.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class ApiResponse<T> {

    @JsonProperty("isSuccess")
    private Boolean isSuccess;
    private String code;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    public static <T> ApiResponse<T> onSuccess(T data, Code code) {
        return new ApiResponse<>(true, code.getCode(), code.getMessage(), data);
    }

    public static <T> ApiResponse<T> onFailure(T data, Code code) {
        return new ApiResponse<>(false, code.getCode(), code.getMessage(), data);
    }
}
