package wiscom.backend.converter;

import wiscom.backend.domain.Temp;
import wiscom.backend.web.dto.TempDTO;

public class TempConverter {
    public static Temp toTemp(TempDTO.Req req) {
        return Temp.builder()
                .content(req.getContent())
                .build();
    }

    public static TempDTO.Res toTempDTO(Temp temp) {
        return TempDTO.Res.builder()
                .content(temp.getContent())
                .id(temp.getId())
                .build();
    }
}
