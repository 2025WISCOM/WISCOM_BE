package wiscom.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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

        return guestbookRepository.save(GuestbookConverter.toGuestbook(request));
    }
}