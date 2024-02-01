package fr.eni.tp_security.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.eni.tp_security.entity.Utilisateur;
import fr.eni.tp_security.repository.UtilisateurRepository;
import jakarta.transaction.Transactional;

@Service
public class UtilisateurService {
    @Autowired
    UtilisateurRepository repo;

    @Autowired
    PasswordEncoder encodeur;


    @Transactional
    public void addUtilisateur(Utilisateur utilisateur) {
        // encodage du mot de passe
        utilisateur.setMdp(encodeur.encode(utilisateur.getMdp()));

        // insertion en base
        repo.insert(utilisateur);
    }

    public Utilisateur findByPseudo(String pseudo){
        return repo.findByPseudo(pseudo);
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return repo.getAll();
    }

}