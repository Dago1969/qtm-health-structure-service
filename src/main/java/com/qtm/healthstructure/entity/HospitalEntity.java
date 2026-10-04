package com.qtm.healthstructure.entity;
import jakarta.persistence.*; import lombok.*;
@Entity @Table(name="hospital", uniqueConstraints=@UniqueConstraint(columnNames={"codice_asl","codice_struttura"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class HospitalEntity {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; private Integer anno;
 private String codiceRegione; private String regione; private String codiceAsl; @Column(name="asl") private String aslDescrizione;
 private String codiceStruttura; private String struttura; private String comune; private String siglaProvincia; private String indirizzo; private String tipoStruttura;
 @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="hospital_type_id") private HospitalTypeEntity hospitalType;
 @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="asl_id") private ASLEntity asl; private Long cityId;
}