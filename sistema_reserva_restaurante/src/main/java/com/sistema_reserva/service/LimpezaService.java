package com.sistema_reserva.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class LimpezaService {
    
    // ... injeta o UsuarioRepository ...
    
    // "rodar todo dia às 3 da manhã"
    @Scheduled(cron = "0 0 3 * * ?") 
    @Transactional
    public void limparUsuariosPendentes() {
        System.out.println("--- RODANDO JOB DE LIMPEZA DE USUÁRIOS PENDENTES ---");
        
        // Deleta usuários PENDENTES cujo token expirou
        // repository.deleteByRoleAndExpiracaoTokenVerificacaoBefore(
        //     Role.ROLE_PENDENTE, 
        //     Instant.now()
        // ); 
        // (Teria que criar esse método no Repository)
    }
}
