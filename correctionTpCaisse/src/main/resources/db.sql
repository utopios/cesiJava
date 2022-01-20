
CREATE TABLE produit (
    id int(11) PRIMARY KEY AUTO_INCREMENT,
    titre varchar(255) not null,
    prix decimal not null,
    stock int(11) not null
);


CREATE TABLE vente (
    id int(11) PRIMARY KEY AUTO_INCREMENT,
    etat varchar(255) not null,
    total decimal not null,
    paiement varchar(255) not null,
    date_et_heure DATETIME not null
);



CREATE TABLE vente_produit (
    id int(11) PRIMARY KEY AUTO_INCREMENT,
    vente_id int(11) not null,
    produit_id int(11) not null
);
