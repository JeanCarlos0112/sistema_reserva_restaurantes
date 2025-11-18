// package com.sistema_reserva.controller;

// import org.springframework.web.bind.annotation.GetMapping;

// @GetMapping("/api/auth/verificar")
// public ResponseEntity<String> verificarConta(@RequestParam("token") String token) {
//     // (Vamos precisar de um novo AuthService para isso)
//     authService.verificarToken(token);
//     return ResponseEntity.ok("Sua conta foi ativada com sucesso!");
// }

// // No AuthService.java (lógica)
// public void verificarToken(String token) {
//     Usuario usuario = usuarioRepository.findByTokenVerificacao(token) // (Criar este método no Repository)
//         .orElseThrow(() -> new RuntimeException("Token inválido"));

//     if (usuario.getExpiracaoTokenVerificacao().isBefore(Instant.now())) {
//         // Opcional: reenviar e-mail de verificação? Ou só dar erro?
//         throw new RuntimeException("Token expirado");
//     }
    
//     usuario.ativarUsuario(); // Muda o role, limpa o token
//     usuarioRepository.save(usuario);
// }