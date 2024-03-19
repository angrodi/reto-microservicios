package com.intercorp.junior.reto.model.repository;

import com.intercorp.junior.reto.model.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    @Query("SELECT AVG(c.edad) FROM ClienteEntity c")
    Double getPromedioEdad();

    @Query("SELECT SQRT(AVG(c.edad * c.edad) - AVG(c.edad) * AVG(c.edad)) FROM ClienteEntity c")
    Double getDesviacionEstandarEdad();

}
