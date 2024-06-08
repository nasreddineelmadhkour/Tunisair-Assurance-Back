package org.example.tunisair.Services;


import org.example.tunisair.Dto.AccountLoginDto;
import org.example.tunisair.Entities.Account;
import org.example.tunisair.Entities.Role;
import org.example.tunisair.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ServiceAccount implements IServiceAccount{

    @Autowired
    AccountRepository accountRepository ;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<AccountLoginDto> getAllUser(){

        List<AccountLoginDto> accounts = new ArrayList<>();
        for (Account account:accountRepository.findAll()){

            AccountLoginDto accountdto = new AccountLoginDto();
            accountdto.setPrenom(account.getPrenom());
            accountdto.setNom(account.getNom());
            accountdto.setIdAccount(account.getIdAccount());
            accountdto.setRole(account.getRole());
            accountdto.setDatecreation(account.getDatecreation());
            accountdto.setEmail(account.getEmail());
            accountdto.setPassword(account.getPassword());
            accounts.add(accountdto);
        }
        return accounts;
    }

    @Override
    public Account signup(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setRole(Role.ADMIN);
        account.setDatecreation(new Date());
        return accountRepository.save(account);
    }

    @Override
    public Account addEmploye(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setRole(Role.EMPLOYE);
        account.setDatecreation(new Date());
        return accountRepository.save(account);
    }

    @Override
    public void deleteEmploye(Long idAccount) {
        accountRepository.deleteById(idAccount);
    }


}
