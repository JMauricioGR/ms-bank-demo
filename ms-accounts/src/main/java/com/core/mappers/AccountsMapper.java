package com.core.mappers;

import com.core.domain.Account;
import com.core.dtos.request.AccountRequestDto;
import com.core.dtos.response.AccountResponseDto;
import org.springframework.stereotype.Component;

@Component
public class AccountsMapper {

    public Account requestDtoToAccount(AccountRequestDto requestDto){

        Account accountEntity = new Account();

        accountEntity.setId(requestDto.getAccountId());
        accountEntity.setAccountNumber(requestDto.getAccountNumber());
        accountEntity.setClient(requestDto.getClient());
        accountEntity.setStatus(requestDto.getStatus());

        return accountEntity;
    }

    public AccountResponseDto accountEntityToDto(Account accountEntity){

        AccountResponseDto responseDto = new AccountResponseDto();

        responseDto.setAccountId(accountEntity.getId());
        responseDto.setAccountNumber(accountEntity.getAccountNumber());
        responseDto.setAccountType(accountEntity.getAccountType().toString());
        responseDto.setBalance(accountEntity.getBalance());
        responseDto.setStatus(accountEntity.getStatus());
        responseDto.setClient(accountEntity.getClient());

        return responseDto;
    }
}
