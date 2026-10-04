package com.qtm.healthstructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name="asl", uniqueConstraints=@UniqueConstraint(columnNames={"codice_regione","codice_azienda"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ASLEntity {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(name="codice_azienda", nullable=false, length=50) private String codiceAzienda;
    @Column(name="denominazione_azienda", nullable=false, length=500) private String denominazioneAzienda;
    @Column(name="city_id") private Long cityId; @Column(name="province_id") private Long provinceId;
    @Column(name="codice_regione", nullable=false, length=10) private String codiceRegione;
    private Integer anno; @Column(length=500) private String indirizzo; @Column(length=20) private String cap;
    @Column(length=100) private String telefono; @Column(length=100) private String fax;
    @Column(length=200) private String email; @Column(name="sito_web", length=200) private String sitoWeb;
    @Column(name="partita_iva", length=50) private String partitaIva;
}