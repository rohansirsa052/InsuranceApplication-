package com.CaseStudy.InsuranceApplication.Mapper;

import com.CaseStudy.InsuranceApplication.Dto.AdminRulesDto;
import com.CaseStudy.InsuranceApplication.Entity.AdminRules;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-26T00:40:58+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class AdminRulesMapperImpl implements AdminRulesMapper {

    @Override
    public AdminRulesDto toDto(AdminRules adminRules) {
        if ( adminRules == null ) {
            return null;
        }

        AdminRulesDto adminRulesDto = new AdminRulesDto();

        adminRulesDto.setId( adminRules.getId() );
        adminRulesDto.setMaxAge( adminRules.getMaxAge() );
        adminRulesDto.setMaxDependent( adminRules.getMaxDependent() );

        return adminRulesDto;
    }

    @Override
    public AdminRules toEntity(AdminRulesDto adminRulesDto) {
        if ( adminRulesDto == null ) {
            return null;
        }

        AdminRules adminRules = new AdminRules();

        adminRules.setId( adminRulesDto.getId() );
        adminRules.setMaxAge( adminRulesDto.getMaxAge() );
        adminRules.setMaxDependent( adminRulesDto.getMaxDependent() );

        return adminRules;
    }
}
