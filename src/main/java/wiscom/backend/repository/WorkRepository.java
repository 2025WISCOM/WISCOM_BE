package wiscom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wiscom.backend.domain.CategoryEnum;
import wiscom.backend.domain.Work;

import java.util.List;
import java.util.Optional;

public interface WorkRepository extends JpaRepository<Work, Long> {

    // 가장 가까운 이전 작품 ID (작은 ID 중 가장 큰 값)
    Optional<Work> findTopByIdLessThanOrderByIdDesc(Long id);

    // 가장 가까운 다음 작품 ID (큰 ID 중 가장 작은 값)
    Optional<Work> findTopByIdGreaterThanOrderByIdAsc(Long id);

    //카테고리별 조회
    List<Work> findByCategoriesContaining(@Param("category") CategoryEnum category);

    //상세페이지
    Optional<Work> findByIdAndCategoriesContaining(@Param("id") Long id, @Param("category") CategoryEnum category);

    // 전체목록 중 첫 번째 작품
    Optional<Work> findTopByOrderByIdAsc();

    // 전체목록 중 마지막 작품
    Optional<Work> findTopByOrderByIdDesc();

    //카테고리별 이전 작품
    Optional<Work> findFirstByCategoriesContainingAndIdLessThanOrderByIdDesc(@Param("category") CategoryEnum category, @Param("id") Long id);

    //카테고리별 다음 작품
    Optional<Work> findFirstByCategoriesContainingAndIdGreaterThanOrderByIdAsc(@Param("category") CategoryEnum category, @Param("id") Long id);

    // 카테고리별 가장 첫 번째
    Optional<Work> findTopByCategoriesContainingOrderByIdAsc(CategoryEnum category);

    // 카테고리별 가장 마지막
    Optional<Work> findTopByCategoriesContainingOrderByIdDesc(CategoryEnum category);

    // 팀 목록
    @Query("select distinct w from Work w left join fetch w.developers d")
    List<Work> findAllWithDevelopers();
}
