package wiscom.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wiscom.backend.apiPayload.code.status.ErrorStatus;
import wiscom.backend.apiPayload.exception.handler.WorkHandler;
import wiscom.backend.converter.WorkConverter;
import wiscom.backend.domain.CategoryEnum;
import wiscom.backend.domain.Work;
import wiscom.backend.repository.WorkRepository;
import wiscom.backend.web.dto.WorkResponseDTO;
import wiscom.backend.web.dto.WorkDetailResponseDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkServiceImpl implements WorkService {
    private final WorkRepository workRepository;


    @Override
    public List<WorkResponseDTO> getWorksByOptionalCategory(String categoryString) {
        Optional<CategoryEnum> categoryOpt = parseCategory(categoryString);

        List<Work> works = categoryOpt
                .map(workRepository::findByCategoriesContaining)
                .orElseGet(workRepository::findAll);

        return works.stream()
                .map(WorkConverter::toWorkResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public WorkDetailResponseDTO getWorkDetail(String categoryString, Long id){
        Optional<CategoryEnum> categoryOpt = parseCategory(categoryString);

        if (categoryOpt.isEmpty()) {
            // ALL일 경우
            Work work = workRepository.findById(id)
                    .orElseThrow(() -> new WorkHandler(ErrorStatus.WORK_NOT_FOUND));

            Long prev = workRepository.findTopByIdLessThanOrderByIdDesc(id)
                    .map(Work::getId)
                    .orElseGet(() -> workRepository.findTopByOrderByIdDesc().get().getId());;

            Long next = workRepository.findTopByIdGreaterThanOrderByIdAsc(id)
                    .map(Work::getId)
                    .orElseGet(() -> workRepository.findTopByOrderByIdAsc().get().getId());

            return WorkConverter.toWorkDetailResponseDTO(work, prev, next);
        }

        // 특정 카테고리일 경우
        CategoryEnum category = categoryOpt.get();

        Work work = workRepository.findByIdAndCategoriesContaining(id, category)
                .orElseThrow(() -> new WorkHandler(ErrorStatus.WORK_NOT_FOUND));

        Long prev = workRepository.findFirstByCategoriesContainingAndIdLessThanOrderByIdDesc(category, id)
                .map(Work::getId)
                .orElseGet(() -> workRepository.findTopByCategoriesContainingOrderByIdDesc(category).get().getId());;

        Long next = workRepository.findFirstByCategoriesContainingAndIdGreaterThanOrderByIdAsc(category, id)
                .map(Work::getId)
                .orElseGet(() -> workRepository.findTopByCategoriesContainingOrderByIdAsc(category).get().getId());

        return WorkConverter.toWorkDetailResponseDTO(work, prev, next);

    }

    private Optional<CategoryEnum> parseCategory(String categoryString) {
        if (categoryString == null || categoryString.equalsIgnoreCase("ALL")) {
            return Optional.empty();
        }

        try {
            return Optional.of(CategoryEnum.from(categoryString));
        } catch (IllegalArgumentException e) {
            throw new WorkHandler(ErrorStatus.INVALID_CATEGORY);
        }
    }
}
