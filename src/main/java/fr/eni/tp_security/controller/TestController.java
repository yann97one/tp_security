package fr.eni.tp_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.eni.tp_security.service.UtilisateurService;

@Controller
public class TestController {
    @Autowired
    public UtilisateurService service;

    @GetMapping("/")
    public String accueil(Model model) {
        model.addAttribute("utilisateurs",service.getAllUtilisateurs());
        return "accueil";
    }

    @GetMapping("/vote")
    public String vote() {
        return "vote";
    }

    @GetMapping("/resultatVote")
    public String resultatVote(Authentication authentication) {
        return "resultatVote";
    }

}

