package wiscom.backend.web.dto;

import lombok.Builder;
import lombok.Getter;
import wiscom.backend.domain.Developer;
import java.util.List;

@Builder
@Getter
public class WorkResponseDTO {
    private final Long id;
    private final String projectName;
    private final String imageUrl;
    private final String teamName;
    private final List<Developer> developers;
    private final String shortDescription;
    private final String midDescription;


}
