package wiscom.backend.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wiscom.backend.apiPayload.ApiResponse;
import wiscom.backend.domain.Temp;
import wiscom.backend.service.TempService;
import wiscom.backend.web.dto.TempDTO;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "TEMP API", description = "임시 API, 추후 삭제 예정.")
public class TempController {

    private final TempService tempService;

    // temp 생성
    @PostMapping("/api/temp")
    @Operation(summary = "기본 회원가입 API", description = "아이디/비밀번호를 기준으로 유저를 생성합니다.")
    public ApiResponse<TempDTO.Res> createTemp (
            @RequestBody @Valid TempDTO.Req request
    ){
        return ApiResponse.onSuccess(tempService.createTemp(request));
    }
}
