package kz.storelink.recommendation.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class RecommendationException extends RuntimeException {

    private final String message;
    private int errorCode;
    private final int status;

    public RecommendationException(String message, int errorCode) {
        super(message);
        this.message = message;
        this.status = HttpStatus.BAD_REQUEST.value();
        this.errorCode = errorCode;
    }
}
