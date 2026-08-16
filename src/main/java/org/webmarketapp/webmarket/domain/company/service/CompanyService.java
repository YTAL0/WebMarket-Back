package org.webmarketapp.webmarket.domain.company.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webmarketapp.webmarket.core.exception.ResourceNotFoundException;
import org.webmarketapp.webmarket.domain.company.dto.CompanyRequestDTO;
import org.webmarketapp.webmarket.domain.company.dto.CompanyResponseDTO;
import org.webmarketapp.webmarket.domain.company.model.Company;
import org.webmarketapp.webmarket.domain.company.repository.CompanyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyResponseDTO createCompany(CompanyRequestDTO dto) {
        Company company = new Company();
        company.setName(dto.getName());
        company.setInitialBalance(dto.getInitialBalance());

        Company savedCompany = companyRepository.save(company);
        return convertToResponseDTO(savedCompany);
    }

    public List<CompanyResponseDTO> getAllCompanies() {
        return companyRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public CompanyResponseDTO getCompanyById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company with ID " + id + " not found."));
        return convertToResponseDTO(company);
    }

    public CompanyResponseDTO updateCompany(Long id, CompanyRequestDTO dto) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company with ID " + id + " not found."));

        company.setName(dto.getName());
        company.setInitialBalance(dto.getInitialBalance());

        Company updatedCompany = companyRepository.save(company);
        return convertToResponseDTO(updatedCompany);
    }

    private CompanyResponseDTO convertToResponseDTO(Company company) {
        CompanyResponseDTO dto = new CompanyResponseDTO();
        dto.setId(company.getId());
        dto.setName(company.getName());
        dto.setInitialBalance(company.getInitialBalance());
        return dto;
    }
}