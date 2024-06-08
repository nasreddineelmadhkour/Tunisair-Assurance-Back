package org.example.tunisair.Services;

import org.example.tunisair.Dto.AccountLoginDto;
import org.example.tunisair.Entities.Account;

import java.util.List;

public interface IServiceAccount {
    public List<AccountLoginDto> getAllUser();
    public Account signup(Account account);
    public Account addEmploye(Account account);


    void deleteEmploye(Long idAccount);
}
