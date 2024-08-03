package net.javaguides.banking.dto;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@AllArgsConstructor
public class AccountDto {
    private long id;
    private String accountHolderName;
    private double balance;
}