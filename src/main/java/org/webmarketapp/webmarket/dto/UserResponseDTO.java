package org.webmarketapp.webmarket.dto;
import lombok.Data;
import java.time.LocalDate;

@Data
public class UserResponseDTO {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String position;
    private Double salary;
    private String role;
}