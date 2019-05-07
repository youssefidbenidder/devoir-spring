package com.devoir.demo.web;


import com.devoir.demo.dao.ClientRepository;
import com.devoir.demo.dao.PanierRepository;
import com.devoir.demo.dao.UserRepository;
import com.devoir.demo.entities.Client;
import com.devoir.demo.entities.Panier;
import com.devoir.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;

@Controller
public class RegisterController{


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PanierRepository panierRepository;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("client" , new Client());
        model.addAttribute("user" , new User());
        return "register";
    }

    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public String register(Client client ){


        User user1 = this.userRepository.save(User.builder().username(client.getUser().getUsername()).password(
                this.passwordEncoder.encode(client.getUser().getPassword())).roles(Arrays.asList("ROLE_USER")).build());
        Panier panier = Panier.builder().build();
        Client client1 = Client.builder().email(client.getEmail()).user(user1).panier(panier).build();
        panierRepository.save(panier);
        clientRepository.save(client1);
        return "redirect:/home";
    }

}