package com.qtm.healthstructure.entity;
import jakarta.persistence.*; import lombok.*;
@Entity @Table(name="discipline") @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class DisciplinaEntity { @Id @Column(name="codice_disciplina", length=20) private String codiceDisciplina; @Column(nullable=false,length=200) private String disciplina; }