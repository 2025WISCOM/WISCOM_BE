package wiscom.backend.converter;

import wiscom.backend.domain.Guestbook;
import wiscom.backend.web.dto.GuestbookRequestDTO;
import wiscom.backend.web.dto.GuestbookResponseDTO;

public class GuestbookConverter {

    public static Guestbook toGuestbook(GuestbookRequestDTO.GuestbookDTO request) {

        return Guestbook.builder()
                .author(request.getAuthor())
                .recipient(request.getRecipient())
                .content(request.getContent())
                .build();
    }


}
