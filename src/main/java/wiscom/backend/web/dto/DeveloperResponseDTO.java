package wiscom.backend.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DeveloperResponseDTO {
    private final Long id;
    private final String name;
    private final String role;
}
