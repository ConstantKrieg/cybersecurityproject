package com.sec.cybersecurityproject.controller;

import com.sec.cybersecurityproject.model.Account;
import com.sec.cybersecurityproject.repository.AccountRepository;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
    
    @Autowired
    private AccountRepository accountRepo; 

    @RequestMapping("/")
    public String handleDefault() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getName().isEmpty() || Objects.isNull(auth.getName())) {

            return "redirect:/login";

        } else {
            Account acc = accountRepo.findByUsername(auth.getName());
            if ( Objects.isNull(acc)) {
                return "redirect:/users/login";
            }
            return "redirect:/users/" + acc.getId();
        }
    }

}
