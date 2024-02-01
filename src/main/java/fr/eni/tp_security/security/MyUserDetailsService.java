package fr.eni.tp_security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.eni.tp_security.entity.Utilisateur;
import fr.eni.tp_security.repository.UtilisateurRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UtilisateurRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String pseudo) {

        Utilisateur user;
        try {
            user = userRepository.findByPseudo(pseudo);
            if (user == null) {
                throw new UsernameNotFoundException(pseudo);
            }
        } catch (Exception e) {
            throw new UsernameNotFoundException(pseudo);
        }
        return new MyUserDetail(user);
    }
}