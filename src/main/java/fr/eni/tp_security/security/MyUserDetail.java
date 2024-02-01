package fr.eni.tp_security.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

import fr.eni.tp_security.entity.Utilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class MyUserDetail implements UserDetails {
    private Utilisateur user;

    public MyUserDetail(Utilisateur user) {
        this.user = user;
    }

    public Utilisateur getUser() {
        return user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        StringTokenizer stk = new StringTokenizer(user.getRoles(),",");
        while(stk.hasMoreTokens()) {
            authorities.add(new SimpleGrantedAuthority(stk.nextToken()));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getMdp();
    }

    @Override
    public String getUsername() {
        return user.getPseudo();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
