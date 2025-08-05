package wiscom.backend.web.dto;

import lombok.Getter;
import wiscom.backend.domain.Work;

@Getter
public class WorkResponseDTO {
    private final Long id;
    private final String projectName;
    private final String imageUrl;
    private final String teamName;
    private final String shortDescription;

    public WorkResponseDTO(Work work) {
        this.id = work.getId();
        this.projectName = work.getProjectName();
        this.teamName = work.getTeamName();
        this.shortDescription = work.getShortDescription();
        this.imageUrl = work.getImageUrls().get(0).getUrl();
    }

}
