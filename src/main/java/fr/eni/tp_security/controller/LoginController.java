package fr.eni.tp_security.controller;

import fr.eni.tp_security.entity.Utilisateur;
import fr.eni.tp_security.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @Autowired
    private UtilisateurService service;
    @GetMapping("/login")
    public String login(Utilisateur utilisateur) {
        return "login";
    }

    @PostMapping("/login")
    public String affectLogin(@ModelAttribute("utilisateur") Utilisateur utilisateur, Model model) {
        Utilisateur user = service.findByPseudo(utilisateur.getPseudo());
        if (user != null) {
            if (user.getMdp().equals(utilisateur.getMdp()) && user.getPseudo().equals(utilisateur.getPseudo())) {
                return "redirect:/";
            }
        }else{
            return "redirect:/login-error";
        }
        model.addAttribute("loginError", true);
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
