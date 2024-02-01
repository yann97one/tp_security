package fr.eni.tp_security;

import fr.eni.tp_security.entity.Utilisateur;
import fr.eni.tp_security.service.UtilisateurService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class TpSecurityApplication {


    @Autowired
    public UtilisateurService service;

    LocalDate date = LocalDate.of(2024,01,02);

    String input = "01/01/2009" ;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "MM/dd/yyyy" ) ;
    LocalDate localDate = LocalDate.parse( input, formatter ) ;
    Utilisateur util = new Utilisateur("aaa","123","Jessy","aaa", "localDate");


    @PostConstruct
    public void init() {
        //service.addUtilisateur(new Utilisateur("zzz","123","Jessy","USER",LocalDate.parse("1900-01-20")));
        service.addUtilisateur(new Utilisateur("aaa","123","Jessy","aaa", new LocalDate (1900,01,01)));
//        service.addUtilisateur(new Utilisateur("bbb","123","Jessy","aaa",LocalDate.of(1900,02,02)));
        service.getAllUtilisateurs().forEach(System.out::println);


    }

    public static void main(String[] args) {
        SpringApplication.run(TpSecurityApplication.class, args);
    }

}
