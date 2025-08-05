package wiscom.backend.web.dto;

import lombok.Getter;
import wiscom.backend.domain.Developer;
import wiscom.backend.domain.Image;
import wiscom.backend.domain.Work;

import java.util.List;

@Getter
public class WorkDetailResponseDTO {
    private final Long id;
    private final String projectName;
    private final String teamName;
    private final String shortDescription;
    private final List<Image> imageUrls;
    private final List<Developer> developers;
    private final String githubUrl;
    private final String instagramUrl;
    private final String description;
    private final Long prev;
    private final Long next;

    public WorkDetailResponseDTO(Work work, Long prev, Long next) {
        this.id = work.getId();
        this.projectName = work.getProjectName();
        this.teamName = work.getTeamName();
        this.shortDescription = work.getShortDescription();
        this.imageUrls = work.getImageUrls();
        this.developers = work.getDevelopers();
        this.description = work.getDescription();
        this.githubUrl = work.getGithubUrl();
        this.instagramUrl = work.getInstagramUrl();
        this.prev = prev;
        this.next = next;
    }


}
