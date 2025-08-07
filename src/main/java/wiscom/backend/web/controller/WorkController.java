package wiscom.backend.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import wiscom.backend.apiPayload.ApiResponse;
import wiscom.backend.domain.CategoryEnum;
import wiscom.backend.service.WorkService;
import wiscom.backend.service.WorkServiceImpl;
import wiscom.backend.web.dto.WorkResponseDTO;
import wiscom.backend.web.dto.WorkDetailResponseDTO;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@Tag(name="작품 조회 API", description = "작품 조회 관련 API입니다.")
public class WorkController {

    private final WorkService workService;

    @GetMapping("/api/workList")
    public ApiResponse<List<WorkResponseDTO>>  getWorksListByCategory(@RequestParam("category") String category){
        List<WorkResponseDTO> works = workService.getWorksByOptionalCategory(category);
        return ApiResponse.onSuccess(works);
    }

    @GetMapping("/api/workDetail")
    public ApiResponse<WorkDetailResponseDTO> getWorkDetail(@RequestParam("category") String category, @RequestParam("id") Long id){
        WorkDetailResponseDTO work = workService.getWorkDetail(category, id);
        return ApiResponse.onSuccess(work);
    }
}
