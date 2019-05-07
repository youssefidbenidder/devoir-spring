package com.devoir.demo.web;

import com.devoir.demo.dao.*;
import com.devoir.demo.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProduitRepository produitRepository;
    private final PanierRepository panierRepository;
    private final PanierItemRepository panierItemRepository;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ClientRepository clientRepository;

    @Autowired
    public DataInitializer(ProduitRepository produitRepository, PanierRepository panierRepository,
                           PanierItemRepository panierItemRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, ClientRepository clientRepository) {
        this.produitRepository = produitRepository;
        this.panierRepository = panierRepository;
        this.panierItemRepository = panierItemRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.clientRepository = clientRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Produit produit = Produit.builder().nom("produit1").prix(13.0).description("Unde Rufinus ea tempestate " +
                "praefectus praetorio ad discrimen trusus est ultimum. ire enim ipse\n" +
                "compellebatur ad militem, quem exagitabat inopia simul et feritas, et alioqui coalito more in").build();
        produitRepository.save(produit);
        Produit produit1 = Produit.builder().nom("produit2").prix(13.0).description("Unde Rufinus ea tempestate praefectus" +
                " praetorio ad discrimen trusus est ultimum. ire enim ipse\n" +
                " compellebatur ad militem, quem exagitabat inopia simul et feritas, et alioqui coalito more in").build();
        produitRepository.save(produit1);
        Produit produit2 = Produit.builder().nom("produit3").prix(13.0).description("Unde Rufinus ea tempestate praefectus" +
                " praetorio ad discrimen trusus est ultimum. ire enim ipse\n" +
                " compellebatur ad militem, quem exagitabat inopia simul et feritas, et alioqui coalito more in").build();
        produitRepository.save(produit2);
        Produit produit3 = Produit.builder().nom("produit4").prix(13.0).description("Unde Rufinus ea tempestate praefectus" +
                " praetorio ad discrimen trusus est ultimum. ire enim ipse\n" +
                " compellebatur ad militem, quem exagitabat inopia simul et feritas, et alioqui coalito more in").build();
        produitRepository.save(produit3);
        Produit produit4 = Produit.builder().nom("produit5").prix(13.0).description("Unde Rufinus ea tempestate praefectus" +
                " praetorio ad discrimen trusus est ultimum. ire enim ipse\n" +
                " compellebatur ad militem, quem exagitabat inopia simul et feritas, et alioqui coalito more in").build();
        produitRepository.save(produit4);
        Produit produit5 = Produit.builder().nom("produit6").prix(13.0).description("Unde Rufinus ea tempestate praefectus" +
                " praetorio ad discrimen trusus est ultimum. ire enim ipse\n" +
                " compellebatur ad militem, quem exagitabat inopia simul et feritas, et alioqui coalito more in").build();
        produitRepository.save(produit5);
        Produit produit6 = Produit.builder().nom("produit7").prix(13.0).description("Unde Rufinus ea tempestate praefectus" +
                " praetorio ad discrimen trusus est ultimum. ire enim ipse\n" +
                " compellebatur ad militem, quem exagitabat inopia simul et feritas, et alioqui coalito more in").build();
        produitRepository.save(produit6);
        Produit produit7 = Produit.builder().nom("produit8").prix(13.0).description("Unde Rufinus ea tempestate praefectus" +
                " praetorio ad discrimen trusus est ultimum. ire enim ipse\n" +
                " compellebatur ad militem, quem exagitabat inopia simul et feritas, et alioqui coalito more in").build();
        produitRepository.save(produit7);
        Produit produit8 = Produit.builder().nom("produit9").prix(13.0).description("Unde Rufinus ea tempestate praefectus" +
                " praetorio ad discrimen trusus est ultimum. ire enim ipse\n" +
                " compellebatur ad militem, quem exagitabat inopia simul et feritas, et alioqui coalito more in").build();
        produitRepository.save(produit8);
        Produit produit9 = Produit.builder().nom("produit10").prix(13.0).description("Unde Rufinus ea tempestate praefectus" +
                " praetorio ad discrimen trusus est ultimum. ire enim ipse\n" +
                " compellebatur ad militem, quem exagitabat inopia simul et feritas, et alioqui coalito more in").build();
        produitRepository.save(produit9);
        Produit produit10 = Produit.builder().nom("produit11").prix(13.0).description("Unde Rufinus ea tempestate praefectus" +
                " praetorio ad discrimen trusus est ultimum. ire enim ipse\n" +
                " compellebatur ad militem, quem exagitabat inopia simul et feritas, et alioqui coalito more in").build();
        produitRepository.save(produit10);
        Produit produit11 = Produit.builder().nom("produit12").prix(13.0).description("Unde Rufinus ea tempestate praefectus" +
                " praetorio ad discrimen trusus est ultimum. ire enim ipse\n" +
                " compellebatur ad militem, quem exagitabat inopia simul et feritas, et alioqui coalito more in").build();
        produitRepository.save(produit11);
        Produit produit12 = Produit.builder().nom("produit13").prix(13.0).description("Unde Rufinus ea tempestate praefectus" +
                " praetorio ad discrimen trusus est ultimum. ire enim ipse\n" +
                " compellebatur ad militem, quem exagitabat inopia simul et feritas, et alioqui coalito more in").build();
        produitRepository.save(produit12);


        Panier panier = Panier.builder().build();
        panierRepository.save(panier);


        PanierItem panierItem = PanierItem.builder()
                .id(
                        PanierItemId.builder()
                                .panierId(panier.getId())
                                .produitId(produit.getId())
                                .build()
                )
                .panier(panier)
                .produit(produit)
                .quantite(13)
                .build();
        panierItemRepository.save(panierItem);
        panierItemRepository.save(panierItem);

        User user = this.userRepository.save(User.builder().username("youssef").password(
                this.passwordEncoder.encode("youssef")).roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN")).build());

        Client client = Client.builder().email("youssef@gmail.com").user(user).panier(panier).build();
        clientRepository.save(client);


        User user1 = this.userRepository.save(User.builder().username("ucef").password(
                this.passwordEncoder.encode("ucef")).roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN")).build());

        Client client1 = Client.builder().email("ucef@gmail.com").user(user1).panier(panier).build();
        clientRepository.save(client1);


    }
}
