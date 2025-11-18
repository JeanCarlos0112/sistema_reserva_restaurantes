package com.sistema_reserva.repository;

import com.sistema_reserva.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByUsuarioNome(String name);
    List<Reserva> findByUsuarioId(Long usuarioId);
    List<Reserva> findByMesaNumero(int numero);
    List<Reserva> findByMesaId(Long mesaId);
}
