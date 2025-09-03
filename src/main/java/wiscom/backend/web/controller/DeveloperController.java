package wiscom.backend.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wiscom.backend.apiPayload.ApiResponse;
import wiscom.backend.service.WorkService;
import wiscom.backend.web.dto.TeamResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "개발자 조회 API", description = "개발자 조회 API 입니다.")
public class DeveloperController {
    private final WorkService workService;

    @GetMapping("/api/teamList")
    public ApiResponse<List<TeamResponseDTO>> getAllTeams(){
        return ApiResponse.onSuccess(workService.getDevelopers());
    }
}
