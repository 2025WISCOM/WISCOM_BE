package wiscom.backend.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wiscom.backend.apiPayload.code.status.ErrorStatus;
import wiscom.backend.apiPayload.exception.handler.TempHandler;
import wiscom.backend.converter.TempConverter;
import wiscom.backend.domain.Temp;
import wiscom.backend.repository.TempRepository;
import wiscom.backend.web.dto.TempDTO;

@Service
@RequiredArgsConstructor
public class TempServiceImpl implements TempService{
    private final TempRepository tempRepository;

    @Override
    @Transactional
    public TempDTO.Res createTemp(TempDTO.Req request) {

        // 테스트용
        if (request.getContent().equals("error")) {
            throw new TempHandler(ErrorStatus.TEMP_ERROR);
        }

        Temp temp = TempConverter.toTemp(request);
        Temp newTemp = tempRepository.save(temp);

        return TempConverter.toTempDTO(newTemp);
    }
}
