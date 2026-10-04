package com.qtm.healthstructure.entity;
import jakarta.persistence.*; import lombok.*;
@Entity @Table(name="hospital_type") @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class HospitalTypeEntity { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @Column(nullable=false,unique=true) private String code; private String description; }