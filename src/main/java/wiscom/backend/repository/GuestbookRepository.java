package wiscom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wiscom.backend.domain.Guestbook;

public interface GuestbookRepository extends JpaRepository<Guestbook, Long> {
}
