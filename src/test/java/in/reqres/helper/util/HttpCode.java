package in.reqres.helper.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static java.lang.String.format;

@AllArgsConstructor
@Getter
public enum HttpCode {

    OK(
            "OK",
            200
    ),
    CREATED(
            "Created",
            201
    ),
    DELETED(
            "Deleted",
            204
    ),
    BAD_REQUEST(
            "Bad Request",
            400
    ),
    UNAUTHORIZED(
            "Unauthorized",
            401
    );


    private final String description;
    private final int value;
}
