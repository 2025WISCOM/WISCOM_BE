package wiscom.backend.service;

import jakarta.validation.Valid;
import wiscom.backend.domain.Temp;
import wiscom.backend.web.dto.TempDTO;

public interface TempService {
    TempDTO.Res createTemp(TempDTO.Req request);
}
