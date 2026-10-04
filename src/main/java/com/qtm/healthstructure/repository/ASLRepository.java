package com.qtm.healthstructure.repository;
import com.qtm.healthstructure.entity.ASLEntity; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface ASLRepository extends JpaRepository<ASLEntity,Long> { Optional<ASLEntity> findByCodiceRegioneAndCodiceAzienda(String region,String company); }