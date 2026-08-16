package org.webmarketapp.webmarket.domain.company.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.webmarketapp.webmarket.domain.company.dto.CompanyRequestDTO;
import org.webmarketapp.webmarket.domain.company.dto.CompanyResponseDTO;
import org.webmarketapp.webmarket.domain.company.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CompanyResponseDTO> createCompany(@RequestBody CompanyRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.createCompany(dto));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<CompanyResponseDTO>> getAllCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CompanyResponseDTO> getCompanyById(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.getCompanyById(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CompanyResponseDTO> updateCompany(@PathVariable Long id, @RequestBody CompanyRequestDTO dto) {
        return ResponseEntity.ok(companyService.updateCompany(id, dto));
    }
}