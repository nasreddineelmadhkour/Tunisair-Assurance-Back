package org.example.tunisair.Services;


import org.example.tunisair.Dto.AccountDetails;
import org.example.tunisair.Dto.AccountLoginDto;
import org.example.tunisair.Entities.Account;
import org.example.tunisair.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AccountSecurityService implements UserDetailsService {
    @Autowired
    private AccountRepository userInfoRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Override
    public AccountDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> userInfoEmail = userInfoRepository.findByEmail(username);

        return userInfoEmail.map(AccountDetails::new).orElseThrow(()-> new UsernameNotFoundException("User not found"+username));

    }

    public AccountLoginDto loginSucces(String username){
        AccountLoginDto accountLoginDto = new AccountLoginDto();

        Account AccountEmail= userInfoRepository.findByEmail(username).orElse(null);
        if(AccountEmail!= null){
            accountLoginDto.setIdAccount(AccountEmail.getIdAccount());
            accountLoginDto.setEmail(AccountEmail.getEmail());
            accountLoginDto.setRole(AccountEmail.getRole());
            accountLoginDto.setPrenom(AccountEmail.getPrenom());
            accountLoginDto.setNom(AccountEmail.getNom());
            accountLoginDto.setDatecreation(AccountEmail.getDatecreation());

            accountLoginDto.setPassword(AccountEmail.getPassword());

                accountLoginDto.setToken(jwtService.generateToken(username));
            }


        return accountLoginDto;
    }



    public String addUser(Account userInfo){
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return "User added successfully";
    }
    public List<Account> getAllUser(){
        return userInfoRepository.findAll();
    }
    public Account getUser(Long id){
        return userInfoRepository.findById(id).get();
    }
}