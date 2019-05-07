package com.devoir.demo.web;


import com.devoir.demo.dao.ClientRepository;
import com.devoir.demo.dao.UserRepository;
import com.devoir.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/login")
    public String login(User user) {

        userRepository.findByUsername(user.getUsername());

        return "login";
    }


}
