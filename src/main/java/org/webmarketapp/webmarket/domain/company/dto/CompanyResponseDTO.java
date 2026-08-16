package org.webmarketapp.webmarket.domain.company.dto;

import lombok.Data;

@Data
public class CompanyResponseDTO {
    private Long id;
    private String name;
    private Double initialBalance;
}