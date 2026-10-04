package com.qtm.healthstructure.entity;
import jakarta.persistence.*; import lombok.*;
@Entity @Table(name="structure_departments", uniqueConstraints=@UniqueConstraint(columnNames={"codice_struttura","codice_disciplina"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class StructureDepartmentEntity { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @Column(nullable=false,length=100) private String codiceStruttura; @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="codice_disciplina",referencedColumnName="codice_disciplina") private DisciplinaEntity disciplina; private String indirizzo; }