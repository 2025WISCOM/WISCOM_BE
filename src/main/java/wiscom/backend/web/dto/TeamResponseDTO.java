package wiscom.backend.web.dto;

import lombok.Builder;
import lombok.Getter;
import wiscom.backend.domain.Developer;

import java.util.List;

@Builder
@Getter
public class TeamResponseDTO {
    private final String teamName;
    private final List<DeveloperResponseDTO> developers;
}
