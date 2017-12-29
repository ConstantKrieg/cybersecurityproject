package com.sec.cybersecurityproject.controller;

import com.sec.cybersecurityproject.model.Account;
import com.sec.cybersecurityproject.repository.AccountRepository;
import com.sec.cybersecurityproject.service.AccountService;
import java.util.Objects;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    private AccountService accService;

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String register() {
        return "signup";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet() {
        return "login";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public ResponseEntity registerNewAccount(@RequestBody Account account) {

        if (account.getPassword().length() < 3) {
            return ResponseEntity.status(500).body("Password is too short");
        }

        try {
            account.setPassword(accService.encodePassword(account.getPassword()));
            accountRepo.save(account);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(500).body("Username " + account.getUsername() + " already exists");
        }

        return ResponseEntity.status(200).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getUserPage(@PathVariable Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Account acc = accountRepo.findByUsername(auth.getName());

        if (acc.getId().longValue() == id) {
            return "userPage";
        }
        return "redirect:/users/" + acc.getId();

    }

}
