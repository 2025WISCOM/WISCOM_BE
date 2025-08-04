package wiscom.backend.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class GuestbookRequestDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GuestbookDTO {
        @NotNull(message = "작성자 이름 작성은 필수입니다.")
        private String author;

        @NotNull(message = "수신자 이름 작성은 필수입니다.")
        private String recipient;

        private String content;
    }
}
