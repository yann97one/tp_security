package fr.eni.tp_security.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {
    private Integer idUtilisateur;
    private String pseudo;
    private String mdp;
    private String nom;
    private String roles;
    private LocalDate dtNaissance;
    private Boolean aVote;

    public Utilisateur(String pseudo, String mdp, String nom,String roles,LocalDate dtNaissance) {
        super();
        this.dtNaissance = dtNaissance;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.nom = nom;
        this.roles = roles;
    }
}
