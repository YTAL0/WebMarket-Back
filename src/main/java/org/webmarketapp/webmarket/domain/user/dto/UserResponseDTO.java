package org.webmarketapp.webmarket.domain.user.dto;
import lombok.Data;
import org.webmarketapp.webmarket.domain.company.dto.CompanySummaryDTO;

import java.time.LocalDate;
import java.util.Set;

@Data
public class UserResponseDTO {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String position;
    private Double salary;
    private String role;
    private Set<CompanySummaryDTO> companies;
}