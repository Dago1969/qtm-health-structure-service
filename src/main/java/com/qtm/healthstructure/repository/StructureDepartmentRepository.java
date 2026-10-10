package com.qtm.healthstructure.repository;

import com.qtm.healthstructure.entity.StructureDepartmentEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StructureDepartmentRepository extends JpaRepository<StructureDepartmentEntity, Long> {

	@Override
	@EntityGraph(attributePaths = "disciplina")
	List<StructureDepartmentEntity> findAll();

	@EntityGraph(attributePaths = "disciplina")
	List<StructureDepartmentEntity> findByCodiceStruttura(String code);
}