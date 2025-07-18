package wiscom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wiscom.backend.domain.Temp;

public interface TempRepository  extends JpaRepository<Temp, Long> {
}
