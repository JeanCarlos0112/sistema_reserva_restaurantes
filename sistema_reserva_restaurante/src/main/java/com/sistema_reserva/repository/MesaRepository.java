package com.sistema_reserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sistema_reserva.model.Mesa;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {
    
}
