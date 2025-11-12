package com.core.service;

import com.core.configuration.Publisher;
import com.core.domain.Account;
import com.core.dtos.request.AccountRequestDto;
import com.core.dtos.response.AccountResponseDto;
import com.core.mappers.AccountsMapper;
import org.springframework.stereotype.Service;
import com.core.repository.AccountsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountsService {

    private final AccountsRepository repository;
    private final AccountsMapper mapper;
    private final Publisher publisher;

    public AccountsService(AccountsRepository repository, AccountsMapper mapper, Publisher publisher) {
        this.repository = repository;
        this.mapper = mapper;
        this.publisher = publisher;
    }

    public AccountResponseDto createAccount(AccountRequestDto requestDto) {
        publisher.send(requestDto);
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

    public AccountResponseDto getAccountById(Long id){
        return mapper.accountEntityToDto(repository.findById(id).get());
    }

    public List<AccountResponseDto> getAllAccounts(){
        return repository.findAll()
                .stream()
                .map(item-> mapper.accountEntityToDto(item))
                .collect(Collectors.toList());
    }
}
