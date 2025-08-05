package wiscom.backend.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class GuestbookResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getGuestbookDTO {
        private Long id;
        private String author;
        private String recipient;
        private String content;
        private LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getGuestbookListDTO {
        List<getGuestbookDTO> guestbooks;
        Integer listSize;       // 반환된 데이터 개수
        Integer totalPage;      // 생성된 페이지 총 개수
        Long totalElements;     // 전체 데이터 총 개수
        Boolean isFirst;        // 현재 첫페이지가 맞는지
        Boolean isLast;         // 현재 마지막 페이지가 맞는지
    }

}
