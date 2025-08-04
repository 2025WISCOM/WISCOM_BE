package wiscom.backend.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wiscom.backend.apiPayload.ApiResponse;
import wiscom.backend.domain.Guestbook;
import wiscom.backend.service.GuestbookService;
import wiscom.backend.web.dto.GuestbookRequestDTO;

@RestController
@RequiredArgsConstructor
@Tag(name = "방명록 API", description = "방명록 관련 API 입니다.")
public class GuestbookController {

    private final GuestbookService guestbookService;

    // 방명록 작성
    @PostMapping("/api/guestbook/create")
    @Operation(summary = "방명록 작성 API", description = "방명록 작성 기능입니다.")
    public ApiResponse<Guestbook> createGuestBook (
            @RequestBody GuestbookRequestDTO.GuestbookDTO request
    ) {

        return ApiResponse.onSuccess(guestbookService.createGuestbook(request));
    }
}
