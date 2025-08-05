package wiscom.backend.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import wiscom.backend.apiPayload.ApiResponse;
import wiscom.backend.converter.GuestbookConverter;
import wiscom.backend.domain.Guestbook;
import wiscom.backend.service.Guestbook.GuestbookQueryService;
import wiscom.backend.service.Guestbook.GuestbookCommandService;
import wiscom.backend.validation.annotation.PageCheck;
import wiscom.backend.web.dto.GuestbookRequestDTO;
import wiscom.backend.web.dto.GuestbookResponseDTO;

@RestController
@RequiredArgsConstructor
@Tag(name = "방명록 API", description = "방명록 관련 API 입니다.")
public class GuestbookController {

    private final GuestbookCommandService guestbookCommandService;
    private final GuestbookQueryService guestbookQueryService;

    // 방명록 작성
    @PostMapping("/api/guestbook/create")
    @Operation(summary = "방명록 작성 API", description = "방명록 작성 기능입니다.")
    public ApiResponse<Guestbook> createGuestBook (
            @RequestBody GuestbookRequestDTO.GuestbookDTO request
    ) {

        return ApiResponse.onSuccess(guestbookCommandService.createGuestbook(request));
    }

    // 방명록 조회
    @GetMapping("/api/guestbook")
    @Operation(summary = "방명록 조회 API", description = "방명록 조회 기능입니다.")
    public ApiResponse<GuestbookResponseDTO.getGuestbookListDTO> getGuestbookList (
            @PageCheck @RequestParam(name = "page") Integer page
    ) {

        return ApiResponse.onSuccess(GuestbookConverter.getGuestbookListDTO(guestbookQueryService.getGuestbooks(page)));
    }

    // 방명록 검색
    @GetMapping("/api/guestbook/search")
    @Operation(summary = "방명록 검색 API", description = "방명록 검색 기능입니다.")
    public ApiResponse<GuestbookResponseDTO.getGuestbookListDTO> getSearchGuestbookList (
            @RequestParam("keyword") String keyword,
            @PageCheck @RequestParam(name = "page") Integer page
    ) {

        return ApiResponse.onSuccess(GuestbookConverter.getGuestbookListDTO(guestbookQueryService.getSearchGuestbooks(keyword, page)));
    }
}
