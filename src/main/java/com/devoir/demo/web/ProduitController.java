package com.devoir.demo.web;

import com.devoir.demo.dao.ProduitRepository;
import com.devoir.demo.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping(value = "/admin")
public class ProduitController {

    @Autowired
    private ProduitRepository produitRepository;

    @RequestMapping(value = "/home")
    public String admin(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "5") int size) {

        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        Page<Produit> pageProduits = produitRepository.findAll(new PageRequest(page, size));
        model.addAttribute("listProduits", pageProduits.getContent());

        int[] pagesLentgh = new int[pageProduits.getTotalPages()];
        model.addAttribute("pagesLentgh", pagesLentgh);
        model.addAttribute("currentPage", page);


        return "products";
    }


    @RequestMapping(value = "/search")
    public String search(Model model, @RequestParam(name = "name", defaultValue = "") String name) {

        List<Produit> produits = produitRepository.findByNom(name);
        model.addAttribute("listProduits", produits);

        return "products";
    }


    @RequestMapping(value = "/delete")
    public String delete(@RequestParam(name = "id") Long id,
                         @RequestParam(name = "page", defaultValue = "0") int page) {
        produitRepository.deleteById(id);
        return "redirect:/admin?page=" + page;
    }

    @RequestMapping(value = "/edit")
    public String edit(Model model, @RequestParam(name = "id") Long id) {
        Produit produit = produitRepository.findById(id).get();
        model.addAttribute("produit", produit);
        return "editProduct";
    }


    @RequestMapping(value = "/addProduct")
    public String addProduct() {
        return "addProduct";
    }

    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public String saveProduct(Model model, Produit produit) {
        produitRepository.save(produit);
        return "addProductResult";
    }

}
