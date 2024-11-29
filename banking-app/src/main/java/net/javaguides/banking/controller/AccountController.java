package net.javaguides.banking.controller;

import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //Get Account Rest Api
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto=accountService.getAccountById(id);
        return  ResponseEntity.ok(accountDto);
    }
    //Deposite Rest Api
    @PutMapping("/{id}/deposite")
    public ResponseEntity<AccountDto>deposite(@PathVariable long id,
                                              @RequestBody Map<String,Double>request){
        Double amount=request.get("amount");
      AccountDto accountDto=accountService.deposite(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    //Withdraw Rest Api
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable long id,
                                              @RequestBody Map<String,Double>request){
        Double amount =request.get("amount");
        AccountDto accountDto=accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }
    //Get the AllAccounts Rest Api
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
       List<AccountDto> accounts= accountService.getAllAccount();
       return ResponseEntity.ok(accounts);
    }

    //Delete the Account Using Rest Api

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccountId(@PathVariable Long id){
        accountService.deleteAccountId(id);
        return ResponseEntity.ok("Account is deleted succesfully");
    }

}
