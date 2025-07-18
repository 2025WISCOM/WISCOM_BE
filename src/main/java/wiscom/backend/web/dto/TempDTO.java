package wiscom.backend.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class TempDTO {

    @Getter
    public static class Req {
        @NotBlank
        private String content;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Res {
        private Long id;
        private String content;
    }
}
