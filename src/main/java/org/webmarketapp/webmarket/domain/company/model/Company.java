package org.webmarketapp.webmarket.domain.company.model;

import jakarta.persistence.*;
import lombok.*;
import org.webmarketapp.webmarket.domain.user.model.User;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "companies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @ManyToMany(mappedBy = "companies")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<User> users = new HashSet<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "initial_balance", nullable = false)
    private Double initialBalance;
}