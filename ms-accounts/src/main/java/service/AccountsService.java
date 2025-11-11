package service;

import domain.Account;
import dtos.request.AccountRequestDto;
import dtos.response.AccountResponseDto;
import mappers.AccountsMapper;
import org.springframework.stereotype.Service;
import repository.AccountsRepository;

@Service
public class AccountsService {

    private final AccountsRepository repository;
    private final AccountsMapper mapper;

    public AccountsService(AccountsRepository repository, AccountsMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public AccountResponseDto createAccount(AccountRequestDto requestDto) {
        return mapper.accountEntityToDto(
                repository.save(mapper.requestDtoToAccount(requestDto))
        );
    }

    public String deleteAccount (Long accountId){
        try{
            repository.deleteById(accountId);
            return "La cuenta número: " + accountId + " ha sido borrada exitsamente.";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public AccountResponseDto updateAccountStatus(Long accountId, Boolean status){
        Account accountToUpdate = repository.findById(accountId).get();
        accountToUpdate.setStatus(status);

        return mapper.accountEntityToDto(repository.save(accountToUpdate));
    }
}
