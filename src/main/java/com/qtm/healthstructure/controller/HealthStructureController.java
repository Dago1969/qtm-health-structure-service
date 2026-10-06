package com.qtm.healthstructure.controller;

import com.qtm.commonlib.api.HealthStructureApi;
import com.qtm.commonlib.dto.ASLDto;
import com.qtm.commonlib.dto.DisciplinaDto;
import com.qtm.commonlib.dto.HospitalDto;
import com.qtm.commonlib.dto.StructureDepartmentSourceDto;
import com.qtm.healthstructure.entity.ASLEntity;
import com.qtm.healthstructure.entity.DisciplinaEntity;
import com.qtm.healthstructure.entity.HospitalEntity;
import com.qtm.healthstructure.entity.HospitalTypeEntity;
import com.qtm.healthstructure.entity.StructureDepartmentEntity;
import com.qtm.healthstructure.repository.ASLRepository;
import com.qtm.healthstructure.repository.DisciplinaRepository;
import com.qtm.healthstructure.repository.HospitalRepository;
import com.qtm.healthstructure.repository.StructureDepartmentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** Implementa il contratto condiviso convertendo i DTO REST nelle Entity persistite. */
@RestController
@RequiredArgsConstructor
public class HealthStructureController implements HealthStructureApi {
    private final ASLRepository aslRepository;
    private final HospitalRepository hospitalRepository;
    private final DisciplinaRepository disciplinaRepository;
    private final StructureDepartmentRepository departmentRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ASLDto> findAsl() {
        return aslRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public ResponseEntity<ASLDto> findAsl(Long id) {
        return ResponseEntity.of(aslRepository.findById(id).map(this::toDto));
    }

    @Override
    public ASLDto createAsl(ASLDto dto) {
        return toDto(aslRepository.save(toEntity(dto)));
    }

    @Override
    public ASLDto updateAsl(Long id, ASLDto dto) {
        ASLEntity entity = toEntity(dto);
        entity.setId(id);
        return toDto(aslRepository.save(entity));
    }

    @Override
    public ResponseEntity<Void> deleteAsl(Long id) {
        aslRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public List<HospitalDto> findHospitals() {
        return hospitalRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public ResponseEntity<HospitalDto> findHospital(Long id) {
        return ResponseEntity.of(hospitalRepository.findById(id).map(this::toDto));
    }

    @Override
    public HospitalDto createHospital(HospitalDto dto) {
        return toDto(hospitalRepository.save(toEntity(dto)));
    }

    @Override
    public HospitalDto updateHospital(Long id, HospitalDto dto) {
        HospitalEntity entity = toEntity(dto);
        entity.setId(id);
        return toDto(hospitalRepository.save(entity));
    }

    @Override
    public ResponseEntity<Void> deleteHospital(Long id) {
        hospitalRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public List<DisciplinaDto> findDisciplines() {
        return disciplinaRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public ResponseEntity<DisciplinaDto> findDiscipline(String id) {
        return ResponseEntity.of(disciplinaRepository.findById(id).map(this::toDto));
    }

    @Override
    public DisciplinaDto createDiscipline(DisciplinaDto dto) {
        return toDto(disciplinaRepository.save(toEntity(dto)));
    }

    @Override
    public ResponseEntity<Void> deleteDiscipline(String id) {
        disciplinaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public List<StructureDepartmentSourceDto> findDepartments(String codiceStruttura) {
        List<StructureDepartmentEntity> departments = codiceStruttura == null
                ? departmentRepository.findAll()
                : departmentRepository.findByCodiceStruttura(codiceStruttura);
        return departments.stream().map(this::toDto).toList();
    }

    @Override
    public StructureDepartmentSourceDto createDepartment(StructureDepartmentSourceDto dto) {
        StructureDepartmentEntity entity = new StructureDepartmentEntity();
        entity.setCodiceStruttura(dto.getCodiceStruttura());
        entity.setIndirizzo(dto.getIndirizzo());
        if (dto.getCodiceDisciplina() != null) {
            entity.setDisciplina(entityManager.getReference(DisciplinaEntity.class, dto.getCodiceDisciplina()));
        }
        return toDto(departmentRepository.save(entity));
    }

    @Override
    public ResponseEntity<Void> deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private ASLDto toDto(ASLEntity entity) {
        return ASLDto.builder()
                .id(entity.getId())
                .anno(entity.getAnno())
                .codiceAzienda(entity.getCodiceAzienda())
                .denominazioneAzienda(entity.getDenominazioneAzienda())
                .cityId(entity.getCityId())
                .provinceId(entity.getProvinceId())
                .indirizzo(entity.getIndirizzo())
                .cap(entity.getCap())
                .telefono(entity.getTelefono())
                .fax(entity.getFax())
                .email(entity.getEmail())
                .sitoWeb(entity.getSitoWeb())
                .partitaIva(entity.getPartitaIva())
                .codiceRegione(entity.getCodiceRegione())
                .build();
    }

    private ASLEntity toEntity(ASLDto dto) {
        return ASLEntity.builder()
                .id(dto.getId())
                .anno(dto.getAnno())
                .codiceAzienda(dto.getCodiceAzienda())
                .denominazioneAzienda(dto.getDenominazioneAzienda())
                .cityId(dto.getCityId())
                .provinceId(dto.getProvinceId())
                .indirizzo(dto.getIndirizzo())
                .cap(dto.getCap())
                .telefono(dto.getTelefono())
                .fax(dto.getFax())
                .email(dto.getEmail())
                .sitoWeb(dto.getSitoWeb())
                .partitaIva(dto.getPartitaIva())
                .codiceRegione(dto.getCodiceRegione())
                .build();
    }

    private HospitalDto toDto(HospitalEntity entity) {
        return HospitalDto.builder()
                .id(entity.getId())
                .anno(entity.getAnno())
                .codiceRegione(entity.getCodiceRegione())
                .regione(entity.getRegione())
                .codiceAsl(entity.getCodiceAsl())
                .asl(entity.getAslDescrizione())
                .codiceStruttura(entity.getCodiceStruttura())
                .struttura(entity.getStruttura())
                .indirizzo(entity.getIndirizzo())
                .hospitalTypeId(entity.getHospitalType() == null ? null : entity.getHospitalType().getId())
                .tipoStruttura(entity.getTipoStruttura())
                .aslId(entity.getAsl() == null ? null : entity.getAsl().getId())
                .comune(entity.getComune())
                .cityId(entity.getCityId())
                .siglaProvincia(entity.getSiglaProvincia())
                .build();
    }

    private HospitalEntity toEntity(HospitalDto dto) {
        HospitalEntity entity = HospitalEntity.builder()
                .id(dto.getId())
                .anno(dto.getAnno())
                .codiceRegione(dto.getCodiceRegione())
                .regione(dto.getRegione())
                .codiceAsl(dto.getCodiceAsl())
                .aslDescrizione(dto.getAsl())
                .codiceStruttura(dto.getCodiceStruttura())
                .struttura(dto.getStruttura())
                .indirizzo(dto.getIndirizzo())
                .tipoStruttura(dto.getTipoStruttura())
                .comune(dto.getComune())
                .cityId(dto.getCityId())
                .siglaProvincia(dto.getSiglaProvincia())
                .build();
        if (dto.getHospitalTypeId() != null) {
            entity.setHospitalType(entityManager.getReference(HospitalTypeEntity.class, dto.getHospitalTypeId()));
        }
        if (dto.getAslId() != null) {
            entity.setAsl(entityManager.getReference(ASLEntity.class, dto.getAslId()));
        }
        return entity;
    }

    private DisciplinaDto toDto(DisciplinaEntity entity) {
        return DisciplinaDto.builder()
                .codiceDisciplina(entity.getCodiceDisciplina())
                .disciplina(entity.getDisciplina())
                .build();
    }

    private DisciplinaEntity toEntity(DisciplinaDto dto) {
        return DisciplinaEntity.builder()
                .codiceDisciplina(dto.getCodiceDisciplina())
                .disciplina(dto.getDisciplina())
                .build();
    }

    private StructureDepartmentSourceDto toDto(StructureDepartmentEntity entity) {
        String disciplina = entity.getDisciplina() == null ? null : entity.getDisciplina().getDisciplina();
        return StructureDepartmentSourceDto.builder()
                .id(entity.getId())
                .codiceStruttura(entity.getCodiceStruttura())
                .codiceDisciplina(entity.getDisciplina() == null ? null : entity.getDisciplina().getCodiceDisciplina())
                .disciplina(disciplina)
                .descrizioneDisciplina(disciplina)
                .indirizzo(entity.getIndirizzo())
                .build();
    }
}