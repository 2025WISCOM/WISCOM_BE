package wiscom.backend.service.Guestbook;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wiscom.backend.apiPayload.code.status.ErrorStatus;
import wiscom.backend.apiPayload.exception.handler.GuestbookHandler;
import wiscom.backend.converter.GuestbookConverter;
import wiscom.backend.domain.Guestbook;
import wiscom.backend.repository.GuestbookRepository;
import wiscom.backend.web.dto.GuestbookRequestDTO;

@Service
@RequiredArgsConstructor
public class GuestbookServiceImpl implements GuestbookService {

    private final GuestbookRepository guestbookRepository;

    @Override
    public Guestbook createGuestbook(GuestbookRequestDTO.GuestbookDTO request) {

        // 작성자를 작성하지 않았을 경우 예외 처리
        if (request.getAuthor() == null || request.getAuthor().trim().isEmpty()) {
            throw new GuestbookHandler(ErrorStatus.AUTHOR_REQUIRED);
        }

        // 받는자를 작성하지 않았을 경우 예외 처리
        if (request.getRecipient() == null || request.getRecipient().trim().isEmpty()) {
            throw new GuestbookHandler(ErrorStatus.RECIPIENT_REQUIRED);
        }

        return guestbookRepository.save(GuestbookConverter.toGuestbook(request));
    }
}