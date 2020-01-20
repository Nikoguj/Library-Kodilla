package com.crud.library.mapper;

import com.crud.library.domain.Hire;
import com.crud.library.dto.HireDto;
import org.springframework.stereotype.Component;

@Component
public class HireMapper {

    public HireDto mapToHireDto(final Hire hire) {
        return new HireDto(hire.getHireDate(), hire.getHireReturn());
    }
}