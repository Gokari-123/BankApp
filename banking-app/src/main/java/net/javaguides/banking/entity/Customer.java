package net.javaguides.banking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="customer")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="account_holder-name")
    private String accountHolderName;

    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;
}
