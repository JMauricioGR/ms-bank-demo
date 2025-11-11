package mappers;

import domain.Account;
import dtos.request.AccountRequestDto;
import dtos.response.AccountResponseDto;

public class AccountsMapper {

    public Account requestDtoToAccount(AccountRequestDto requestDto){

        Account accountEntity = new Account();

        accountEntity.setAccountNumber(requestDto.getAccountNumber());
        accountEntity.setClient(requestDto.getClient());

        return accountEntity;
    }

    public AccountResponseDto accountEntityToDto(Account accountEntity){

        AccountResponseDto responseDto = new AccountResponseDto();

        responseDto.setAccountNumber(accountEntity.getAccountNumber());
        responseDto.setAccountType(accountEntity.getAccountType().toString());
        responseDto.setBalance(accountEntity.getBalance());
        responseDto.setStatus(accountEntity.getStatus());
        responseDto.setClient(accountEntity.getClient());

        return responseDto;
    }
}
