package com.sec.cybersecurityproject.controller;

import com.sec.cybersecurityproject.model.Account;
import com.sec.cybersecurityproject.repository.AccountRepository;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class AccountController {
    
    @Autowired
    private AccountRepository accountRepo;
    
    
    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String register () {
        return "signup";
    }
    
    @RequestMapping (value = "/login", method = RequestMethod.GET)
    public String loginGet() {
        return "login";
    }
    
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public ResponseEntity registerNewAccount (@RequestBody Account account) {

        accountRepo.save(account);
        
        return ResponseEntity.status(200).build();
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public String getUserPage(@PathVariable Long id) {
        return "userPage";
    }
    
    
    
    
}
