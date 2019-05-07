package com.devoir.demo.web;


import com.devoir.demo.dao.ClientRepository;
import com.devoir.demo.dao.PanierItemRepository;
import com.devoir.demo.dao.ProduitRepository;
import com.devoir.demo.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private PanierItemRepository panierItemRepository;
    @Autowired
    private ClientRepository clientRepository;


    @RequestMapping(value = "/home")
    public String home(Model model, HttpSession session,
                       @RequestParam(name = "page", defaultValue = "0") int page,
                       @RequestParam(name = "size", defaultValue = "9") int size) {

        Client client;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            client = clientRepository.findByUser((User) principal);
            session.setAttribute("client", client);
        } else {
            String username = principal.toString();
            System.out.println(username + " Principal");
        }

        Page<Produit> pageProduits = produitRepository.findAll(new PageRequest(page, size));
        model.addAttribute("listProduits", pageProduits.getContent());

        int[] pagesLentgh = new int[pageProduits.getTotalPages()];
        model.addAttribute("pagesLentgh", pagesLentgh);
        model.addAttribute("currentPage", page);

        return "home";

    }

    @RequestMapping(value = "/addCart", method = RequestMethod.POST)
    public String addCart(@ModelAttribute("p") Produit p , HttpSession session) {

        Client client = (Client) session.getAttribute("client");
        Panier panier = client.getPanier();
        PanierItem panierItem = PanierItem.builder().id(
                PanierItemId.builder()
                        .panierId(panier.getId())
                        .produitId(p.getId())
                        .build()
        ).produit(p).panier(panier).quantite(1).build();
        panierItemRepository.save(panierItem);

        return "redirect:/home";
    }


}
