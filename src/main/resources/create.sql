DROP TABLE IF EXISTS utilisateur;
CREATE TABLE utilisateur (
            idUtilisateur INT AUTO_INCREMENT PRIMARY KEY,
            pseudo VARCHAR(255),
            mdp VARCHAR(255),
            nom VARCHAR(255),
            date_de_naissance DATE,
            a_vote BOOLEAN default false,
            roles VARCHAR(255)
);




