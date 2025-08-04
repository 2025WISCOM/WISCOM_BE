package wiscom.backend.service.Guestbook;

import wiscom.backend.domain.Guestbook;
import wiscom.backend.web.dto.GuestbookRequestDTO;

public interface GuestbookService {

    Guestbook createGuestbook(GuestbookRequestDTO.GuestbookDTO request);

}