package wiscom.backend.converter;

import wiscom.backend.domain.Work;
import wiscom.backend.web.dto.WorkDetailResponseDTO;
import wiscom.backend.web.dto.WorkResponseDTO;

public class WorkConverter {

    public static WorkResponseDTO toWorkResponseDTO(Work work) {
        return WorkResponseDTO.builder()
                .id(work.getId())
                .projectName(work.getProjectName())
                .teamName(work.getTeamName())
                .shortDescription(work.getShortDescription())
                .imageUrl(work.getImageUrls().get(0).getUrl())
                .midDescription(work.getMidDescription())
                .build();
    }

    public static WorkDetailResponseDTO toWorkDetailResponseDTO(Work work, Long prev, Long next) {
        return WorkDetailResponseDTO.builder()
                .id(work.getId())
                .projectName(work.getProjectName())
                .teamName(work.getTeamName())
                .shortDescription(work.getShortDescription())
                .midDescription(work.getMidDescription())
                .imageUrls(work.getImageUrls())
                .developers(work.getDevelopers())
                .description(work.getDescription())
                .githubUrl(work.getGithubUrl())
                .instagramUrl(work.getInstagramUrl())
                .prev(prev)
                .next(next)
                .build();
    }
}
