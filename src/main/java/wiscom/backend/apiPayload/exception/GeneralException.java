package wiscom.backend.apiPayload.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import wiscom.backend.apiPayload.code.BaseErrorCode;
import wiscom.backend.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}