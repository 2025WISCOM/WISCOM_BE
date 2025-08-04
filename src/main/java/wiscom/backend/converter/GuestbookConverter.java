package wiscom.backend.converter;

import org.springframework.data.domain.Page;
import wiscom.backend.domain.Guestbook;
import wiscom.backend.web.dto.GuestbookRequestDTO;
import wiscom.backend.web.dto.GuestbookResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class GuestbookConverter {

    public static Guestbook toGuestbook(GuestbookRequestDTO.GuestbookDTO request) {

        return Guestbook.builder()
                .author(request.getAuthor())
                .recipient(request.getRecipient())
                .content(request.getContent())
                .build();
    }

    public static GuestbookResponseDTO.getGuestbookDTO getGuestbookDTO(Guestbook guestbook) {
        return GuestbookResponseDTO.getGuestbookDTO.builder()
                .id(guestbook.getId())
                .author(guestbook.getAuthor())
                .recipient(guestbook.getRecipient())
                .content(guestbook.getContent())
                .createdAt(guestbook.getCreatedAt())
                .build();
    }

    public static GuestbookResponseDTO.getGuestbookListDTO getGuestbookListDTO(Page<Guestbook> guestbooks) {
        List<GuestbookResponseDTO.getGuestbookDTO> getGuestbookDTOList = guestbooks.stream()
                .map(GuestbookConverter::getGuestbookDTO)
                .collect(Collectors.toList());

        return GuestbookResponseDTO.getGuestbookListDTO.builder()
                .guestbooks(getGuestbookDTOList)
                .listSize(getGuestbookDTOList.size())
                .totalPage(guestbooks.getTotalPages())
                .totalElements(guestbooks.getTotalElements())
                .isFirst(guestbooks.isFirst())
                .isLast(guestbooks.isLast())
                .build();
    }
}
