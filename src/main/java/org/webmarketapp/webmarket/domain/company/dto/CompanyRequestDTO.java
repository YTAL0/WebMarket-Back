package org.webmarketapp.webmarket.domain.company.dto;

import lombok.Data;

@Data
public class CompanyRequestDTO {
    private String name;
    private Double initialBalance;
}