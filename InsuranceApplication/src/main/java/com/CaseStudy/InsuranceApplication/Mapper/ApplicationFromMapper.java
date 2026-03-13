package com.CaseStudy.InsuranceApplication.Mapper;

import com.CaseStudy.InsuranceApplication.Dto.ApplicationFormDto;
import com.CaseStudy.InsuranceApplication.Dto.UserDto;
import com.CaseStudy.InsuranceApplication.Entity.ApplicationForm;
import com.CaseStudy.InsuranceApplication.Entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApplicationFromMapper {
    ApplicationFromMapper INSTANCE = Mappers.getMapper(ApplicationFromMapper.class);

    // Entity → DTO
    ApplicationFormDto toDto(ApplicationForm applicationForm);

    // DTO → Entity
    ApplicationForm toEntity(ApplicationFormDto applicationFormDto);
}
