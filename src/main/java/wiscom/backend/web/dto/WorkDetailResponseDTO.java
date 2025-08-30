package wiscom.backend.web.dto;

import lombok.Builder;
import lombok.Getter;
import wiscom.backend.domain.Developer;
import wiscom.backend.domain.Image;
import java.util.List;

@Builder
@Getter
public class WorkDetailResponseDTO {
    private final Long id;
    private final String projectName;
    private final String teamName;
    private final String shortDescription;
    private final String midDescription;
    private final List<Image> imageUrls;
    private final List<Developer> developers;
    private final String githubUrl;
    private final String instagramUrl;
    private final String description;
    private final Long prev;
    private final Long next;


}
