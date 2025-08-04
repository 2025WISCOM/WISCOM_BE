package wiscom.backend.service.Guestbook;

import wiscom.backend.domain.Guestbook;
import wiscom.backend.web.dto.GuestbookRequestDTO;

public interface GuestbookCommandService {

    Guestbook createGuestbook(GuestbookRequestDTO.GuestbookDTO request);

}