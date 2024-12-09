package net.javaguides.banking.service;

import net.javaguides.banking.dto.AccountDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
    AccountDto deposite(Long id,double amount);
    AccountDto withdraw(Long id,double amount);
    List<AccountDto> getAllAccount();
    void deleteAccountId(Long id);
}
