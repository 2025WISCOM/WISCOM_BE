package wiscom.backend.apiPayload.exception.handler;

import wiscom.backend.apiPayload.code.BaseErrorCode;
import wiscom.backend.apiPayload.exception.GeneralException;

public class WorkHandler extends GeneralException {
    public WorkHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
