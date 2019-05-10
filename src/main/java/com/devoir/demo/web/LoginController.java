package com.devoir.demo.web;


import com.devoir.demo.dao.ClientRepository;
import com.devoir.demo.dao.UserRepository;
import com.devoir.demo.entities.Client;
import com.devoir.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/login")
    public String login(User user , HttpSession session) {
        return "login";
    }


}
