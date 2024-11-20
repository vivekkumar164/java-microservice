package com.organizationService.service.impl;

import com.organizationService.dto.OrganizationDto;
import com.organizationService.entity.Organization;
import com.organizationService.mapper.OrganizationMapper;
import com.organizationService.repository.OrganizationRepository;
import com.organizationService.service.OrganizationService;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        // convert OrganizationDto into Organization jpa entity
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

        Organization savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
