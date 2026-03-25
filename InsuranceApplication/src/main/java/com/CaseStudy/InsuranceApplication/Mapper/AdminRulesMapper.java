package com.CaseStudy.InsuranceApplication.Mapper;

import com.CaseStudy.InsuranceApplication.Dto.AdminRulesDto;
import com.CaseStudy.InsuranceApplication.Entity.AdminRules;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AdminRulesMapper {

    AdminRulesMapper INSTANCE = Mappers.getMapper(AdminRulesMapper.class);

    AdminRulesDto toDto(AdminRules adminRules);

    AdminRules toEntity(AdminRulesDto adminRulesDto);
}