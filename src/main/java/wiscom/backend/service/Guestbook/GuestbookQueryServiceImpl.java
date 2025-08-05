package wiscom.backend.service.Guestbook;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import wiscom.backend.apiPayload.code.status.ErrorStatus;
import wiscom.backend.apiPayload.exception.handler.GuestbookHandler;
import wiscom.backend.domain.Guestbook;
import wiscom.backend.repository.GuestbookRepository;

@Service
@RequiredArgsConstructor
public class GuestbookQueryServiceImpl implements GuestbookQueryService {


    private final GuestbookRepository guestbookRepository;

    @Override
    public Page<Guestbook> getGuestbooks(Integer page) {

        return guestbookRepository.findAll(PageRequest.of(page, 6));
    }

    @Override
    public Page<Guestbook> getSearchGuestbooks(String keyword, Integer page) {

        // 키워드를 작성하지 않았을 경우, 예외 처리
        if (keyword == null || keyword.trim().isEmpty()) {
            throw new GuestbookHandler(ErrorStatus.KEYWORD_REQUIRED);
        }

        return guestbookRepository.searchGuestbookByKeyword(keyword, PageRequest.of(page, 6));
    }
}
