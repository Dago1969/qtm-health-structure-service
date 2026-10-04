package com.qtm.healthstructure.repository;
import com.qtm.healthstructure.entity.StructureDepartmentEntity; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface StructureDepartmentRepository extends JpaRepository<StructureDepartmentEntity,Long> { List<StructureDepartmentEntity> findByCodiceStruttura(String code); }