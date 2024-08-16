package com._coder.bourse.service;

import com._coder.bourse.dto.CouncilDto;
import com._coder.bourse.model.Council;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CouncilService extends AbstractService<CouncilDto> {
    Page<Council> searchCouncilsByProduct(String productName, Pageable pageable);
}
