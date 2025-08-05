package wiscom.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wiscom.backend.domain.Guestbook;

public interface GuestbookRepository extends JpaRepository<Guestbook, Long> {

    @Query("SELECT g FROM Guestbook g WHERE " +
            "g.author LIKE %:keyword% OR " +
            "g.recipient LIKE %:keyword% OR " +
            "g.content LIKE %:keyword%")
    Page<Guestbook> searchGuestbookByKeyword(String keyword, Pageable pageable);
}
