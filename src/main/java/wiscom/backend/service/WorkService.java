package wiscom.backend.service;

import wiscom.backend.domain.CategoryEnum;
import wiscom.backend.web.dto.WorkDetailResponseDTO;
import wiscom.backend.web.dto.WorkResponseDTO;

import java.util.List;

public interface WorkService {

    public List<WorkResponseDTO> getWorksByOptionalCategory(String categoryString);

    public WorkDetailResponseDTO getWorkDetail(String categoryString, Long id);
}
