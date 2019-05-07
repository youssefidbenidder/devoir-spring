package com.devoir.demo.web;

import com.devoir.demo.dao.PanierItemRepository;
import com.devoir.demo.dao.PanierRepository;
import com.devoir.demo.dao.ProduitRepository;
import com.devoir.demo.entities.*;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class CartController {


    @Autowired
    private PanierItemRepository panierItemRepository;
    @Autowired
    private PanierRepository panierRepository;
    @Autowired
    private ProduitRepository produitRepository;


    @RequestMapping(value = "/cart" , method = RequestMethod.GET)
    public String cart(HttpSession session, Model model) {
        Client client = (Client) session.getAttribute("client");
        Panier panier = client.getPanier();

        List<PanierItem> items = new ArrayList<>(panier.getItems());
        model.addAttribute("items", items);

        System.out.println(client.getEmail());
        return "cart";
    }


    @RequestMapping(value = "/deleteItem")
    public String deleteItem(HttpSession session,
                             @RequestParam(name = "id") Long id) {
        Client client = (Client) session.getAttribute("client");
        Panier panier = client.getPanier();
        Produit produit =  produitRepository.getOne(id);

        PanierItem panierItem = panierItemRepository.findByPanierAndProduit(panier,produit);
        panierItemRepository.delete(panierItem);
        return "redirect:/cart";
    }

}
