package wiscom.backend.service.Guestbook;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import wiscom.backend.domain.Guestbook;
import wiscom.backend.repository.GuestbookRepository;

@Service
@RequiredArgsConstructor
public class GuestbookQueryServiceImpl implements GuestbookQueryService {


    private final GuestbookRepository guestbookRepository;

    @Override
    public Page<Guestbook> getGuestbooks(Integer page) {

        return guestbookRepository.findAll(PageRequest.of(page, 6));
    }
}
