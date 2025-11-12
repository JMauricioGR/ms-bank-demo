package com.core.controller;

import com.core.dtos.request.AccountRequestDto;
import com.core.dtos.response.AccountResponseDto;
import org.springframework.web.bind.annotation.*;
import com.core.service.AccountsService;

import java.util.List;

@RestController
@RequestMapping("api/v1/cuentas/")
public class AccountController {

    private final AccountsService accountsService;

    public AccountController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @PostMapping("create")
    public AccountResponseDto createAccount(@RequestBody AccountRequestDto requestDto){
        return accountsService.createAccount(requestDto);
    }

    @DeleteMapping("delete/{id}")
    public String deleteAccount(@PathVariable Long id){
        return accountsService.deleteAccount(id);
    }

    @PutMapping("update")
    public AccountResponseDto updateAccount(@RequestBody AccountRequestDto requestDto){
        return accountsService.updateAccountStatus(requestDto.getAccountId(), requestDto.getStatus());
    }

    @GetMapping("get/{id}")
    public AccountResponseDto getAccount(@PathVariable Long id){
        return accountsService.getAccountById(id);
    }

    @GetMapping("get/all")
    public List<AccountResponseDto> getAccountList(){
        return accountsService.getAllAccounts();
    }
}
