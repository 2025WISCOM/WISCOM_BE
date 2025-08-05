package wiscom.backend.service.Guestbook;

import org.springframework.data.domain.Page;
import wiscom.backend.domain.Guestbook;

public interface GuestbookQueryService {

    Page<Guestbook> getGuestbooks(Integer page);

    Page<Guestbook> getSearchGuestbooks(String keyword, Integer page);
}
