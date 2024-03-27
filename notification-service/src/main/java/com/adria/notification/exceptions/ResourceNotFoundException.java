package com.adria.notification.exceptions;

import com.adria.notification.models.enums.error.ErrorCode;
import lombok.Getter;

/**
 * <p>Exception handling errors triggered during a <i>DAO</i> get process and the object is not found.</p>
 */
@Getter
public class ResourceNotFoundException extends GenericException {

    public ResourceNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

    public ResourceNotFoundException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }


}
