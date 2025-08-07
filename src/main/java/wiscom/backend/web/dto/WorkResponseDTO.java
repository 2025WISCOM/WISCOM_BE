package wiscom.backend.web.dto;

import lombok.Builder;
import lombok.Getter;
import wiscom.backend.domain.Work;

@Builder
@Getter
public class WorkResponseDTO {
    private final Long id;
    private final String projectName;
    private final String imageUrl;
    private final String teamName;
    private final String shortDescription;
    private final String midDescription;


}
