package wiscom.backend.domain;

import wiscom.backend.apiPayload.code.status.ErrorStatus;
import wiscom.backend.apiPayload.exception.handler.WorkHandler;

public enum CategoryEnum {
    WEB_APP,
    GAME,
    AI,
    IOT;

    public static CategoryEnum from(String input) {
        try{
            return CategoryEnum.valueOf(input.toUpperCase());
        }catch(IllegalArgumentException e){
            throw new WorkHandler(ErrorStatus.INVALID_CATEGORY);
        }
    }

}
