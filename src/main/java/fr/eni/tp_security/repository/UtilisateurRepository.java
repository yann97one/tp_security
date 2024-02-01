package fr.eni.tp_security.repository;

import fr.eni.tp_security.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Repository
public class UtilisateurRepository {
    final String SELECT = "SELECT * FROM utilisateur";
    final String INSERT = "INSERT INTO utilisateur(pseudo,mdp,nom,roles,dt_naissance) VALUES(:pseudo,:mdp,:nom,:roles,:dt_naissance)";
    final String SELECT_BY_PSEUDO = "SELECT * FROM utilisateur WHERE pseudo=:pseudo";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    RowMapper<Utilisateur> mapper = (rs, i) -> new Utilisateur(rs.getString("pseudo"),
            rs.getString("mdp"), rs.getString("nom"),rs.getString("roles"),rs.getDate("dt_naissance").toLocalDate());


    public List<Utilisateur> getAll() {
        return jdbcTemplate.query(SELECT, mapper);
    }

    public void insert(Utilisateur utilisateur) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        BeanPropertySqlParameterSource namedParameters = new BeanPropertySqlParameterSource(utilisateur);
        namedParameterJdbcTemplate.update(INSERT, namedParameters,keyHolder);
        utilisateur.setIdUtilisateur(Objects.requireNonNull(keyHolder.getKey()).intValue());
    }

    public Utilisateur findByPseudo(String pseudo) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("pseudo", pseudo);
        return  namedParameterJdbcTemplate.queryForObject(SELECT_BY_PSEUDO,namedParameters, new BeanPropertyRowMapper<>(Utilisateur.class));
    }


}
