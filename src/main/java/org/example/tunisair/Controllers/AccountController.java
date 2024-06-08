package org.example.tunisair.Controllers;


import org.example.tunisair.Dto.AccountLoginDto;
import org.example.tunisair.Dto.AuthRequest;
import org.example.tunisair.Entities.Account;
import org.example.tunisair.Services.AccountSecurityService;
import org.example.tunisair.Services.IServiceAccount;
import org.example.tunisair.Services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private IServiceAccount accountIService;

    @Autowired
    AccountSecurityService accountSecurityService;


    @PostMapping("/login")
    public AccountLoginDto login(@RequestBody AuthRequest authRequest){
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if(authenticate.isAuthenticated()){
            return accountSecurityService.loginSucces(authRequest.getUsername());

            // return jwtService.generateToken(authRequest.getUsername());
        }else {
            throw new UsernameNotFoundException("Invalid user request");
        }
    }


    @GetMapping("/admin")
    public List<AccountLoginDto> getAllAccount(){
        return accountIService.getAllUser();
    }


    @PostMapping("/signup")
    public Account signup(@RequestBody Account admin) {
        return accountIService.signup(admin);
    }

    @PostMapping("/addEmploye")
    public Account addEmplye(@RequestBody Account employe) {
        return accountIService.addEmploye(employe);
    }


    @DeleteMapping("/deleteEmploye/{idAccount}")
    public void deleteEmploye(@PathVariable Long idAccount){
        accountIService.deleteEmploye(idAccount);
    }

}
