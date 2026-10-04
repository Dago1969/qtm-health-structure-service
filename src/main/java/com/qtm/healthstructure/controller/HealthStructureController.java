package com.qtm.healthstructure.controller;

import com.qtm.healthstructure.entity.*;
import com.qtm.healthstructure.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/health")
@RequiredArgsConstructor
public class HealthStructureController {
    private final ASLRepository aslRepository;
    private final HospitalRepository hospitalRepository;
    private final DisciplinaRepository disciplinaRepository;
    private final StructureDepartmentRepository departmentRepository;

    @GetMapping("/asl") public List<ASLEntity> findAsl() { return aslRepository.findAll(); }
    @GetMapping("/asl/{id}") public ResponseEntity<ASLEntity> findAsl(@PathVariable Long id) { return ResponseEntity.of(aslRepository.findById(id)); }
    @PostMapping("/asl") public ASLEntity createAsl(@RequestBody ASLEntity entity) { return aslRepository.save(entity); }
    @PutMapping("/asl/{id}") public ResponseEntity<ASLEntity> updateAsl(@PathVariable Long id, @RequestBody ASLEntity entity) { entity.setId(id); return ResponseEntity.ok(aslRepository.save(entity)); }
    @DeleteMapping("/asl/{id}") public ResponseEntity<Void> deleteAsl(@PathVariable Long id) { aslRepository.deleteById(id); return ResponseEntity.noContent().build(); }

    @GetMapping("/ospedali") public List<HospitalEntity> findHospitals() { return hospitalRepository.findAll(); }
    @GetMapping("/ospedali/{id}") public ResponseEntity<HospitalEntity> findHospital(@PathVariable Long id) { return ResponseEntity.of(hospitalRepository.findById(id)); }
    @PostMapping("/ospedali") public HospitalEntity createHospital(@RequestBody HospitalEntity entity) { return hospitalRepository.save(entity); }
    @PutMapping("/ospedali/{id}") public ResponseEntity<HospitalEntity> updateHospital(@PathVariable Long id, @RequestBody HospitalEntity entity) { entity.setId(id); return ResponseEntity.ok(hospitalRepository.save(entity)); }
    @DeleteMapping("/ospedali/{id}") public ResponseEntity<Void> deleteHospital(@PathVariable Long id) { hospitalRepository.deleteById(id); return ResponseEntity.noContent().build(); }

    @GetMapping("/discipline") public List<DisciplinaEntity> findDisciplines() { return disciplinaRepository.findAll(); }
    @GetMapping("/discipline/{id}") public ResponseEntity<DisciplinaEntity> findDiscipline(@PathVariable String id) { return ResponseEntity.of(disciplinaRepository.findById(id)); }
    @PostMapping("/discipline") public DisciplinaEntity createDiscipline(@RequestBody DisciplinaEntity entity) { return disciplinaRepository.save(entity); }
    @DeleteMapping("/discipline/{id}") public ResponseEntity<Void> deleteDiscipline(@PathVariable String id) { disciplinaRepository.deleteById(id); return ResponseEntity.noContent().build(); }

    @GetMapping("/dipartimenti") public List<StructureDepartmentEntity> findDepartments(@RequestParam(required=false) String codiceStruttura) { return codiceStruttura == null ? departmentRepository.findAll() : departmentRepository.findByCodiceStruttura(codiceStruttura); }
    @PostMapping("/dipartimenti") public StructureDepartmentEntity createDepartment(@RequestBody StructureDepartmentEntity entity) { return departmentRepository.save(entity); }
    @DeleteMapping("/dipartimenti/{id}") public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) { departmentRepository.deleteById(id); return ResponseEntity.noContent().build(); }
}