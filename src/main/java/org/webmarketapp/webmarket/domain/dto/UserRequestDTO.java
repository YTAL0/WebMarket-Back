package org.webmarketapp.webmarket.domain.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UserRequestDTO {
    private String name;
    private LocalDate birthDate;
    private String position;
    private Double salary;
    private String role;
    private String email;
    private String password;
}
