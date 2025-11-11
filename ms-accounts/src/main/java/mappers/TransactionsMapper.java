package mappers;

import domain.Transactions;
import dtos.request.TransactionRequestDto;
import dtos.response.TransactionResponseDto;
import repository.AccountsRepository;

public class TransactionsMapper {

    private AccountsRepository accountsRepository;

    private TransactionsMapper(AccountsRepository accountsRepository){
        this.accountsRepository = accountsRepository;
    }

    public Transactions requestDtoToTransaction(TransactionRequestDto requestDto){
        Transactions entity = new Transactions();

        entity.setAccount(accountsRepository.findByAccountNumber(requestDto.getAccountNumber()));
        entity.setDate(requestDto.getDateFrom());
        return entity;
    }

    public static TransactionResponseDto responseTransactionsToDto(Transactions responseEntity){
        TransactionResponseDto responseDto = new TransactionResponseDto();

        responseDto.setDate(responseEntity.getDate());
        responseDto.setClient(responseEntity.getAccount().getClient());
        responseDto.setAccountNumber(responseEntity.getAccount().getAccountNumber());
        responseDto.setAccountType(responseEntity.getAccount().getAccountType().toString());
        responseDto.setAmount(responseEntity.getAmount());
        responseDto.setStatus(responseEntity.getAccount().getStatus());

        return responseDto;

    }
}
