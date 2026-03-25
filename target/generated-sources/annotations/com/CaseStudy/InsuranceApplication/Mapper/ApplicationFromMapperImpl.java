package com.CaseStudy.InsuranceApplication.Mapper;

import com.CaseStudy.InsuranceApplication.Dto.ApplicationFormDto;
import com.CaseStudy.InsuranceApplication.Entity.ApplicationForm;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-25T20:56:20+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
public class ApplicationFromMapperImpl implements ApplicationFromMapper {

    @Override
    public ApplicationFormDto toDto(ApplicationForm applicationForm) {
        if ( applicationForm == null ) {
            return null;
        }

        ApplicationFormDto applicationFormDto = new ApplicationFormDto();

        applicationFormDto.setName( applicationForm.getName() );
        applicationFormDto.setAge( applicationForm.getAge() );
        applicationFormDto.setCoverageAmount( applicationForm.getCoverageAmount() );
        applicationFormDto.setGender( applicationForm.getGender() );
        applicationFormDto.setNoOfDependents( applicationForm.getNoOfDependents() );

        return applicationFormDto;
    }

    @Override
    public ApplicationForm toEntity(ApplicationFormDto applicationFormDto) {
        if ( applicationFormDto == null ) {
            return null;
        }

        ApplicationForm applicationForm = new ApplicationForm();

        applicationForm.setName( applicationFormDto.getName() );
        applicationForm.setAge( applicationFormDto.getAge() );
        applicationForm.setCoverageAmount( applicationFormDto.getCoverageAmount() );
        applicationForm.setGender( applicationFormDto.getGender() );
        applicationForm.setNoOfDependents( applicationFormDto.getNoOfDependents() );

        return applicationForm;
    }
}
