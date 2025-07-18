package wiscom.backend.apiPayload.exception.handler;


import wiscom.backend.apiPayload.code.BaseErrorCode;
import wiscom.backend.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
