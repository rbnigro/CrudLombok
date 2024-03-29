package com.act.bradesco.users.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.act.bradesco.users.DTO.UsuarioRequestDTO;
import com.act.bradesco.users.response.UsuarioResponseDTO;
import com.act.bradesco.users.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<UsuarioResponseDTO> gravaDadosUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return ResponseEntity.ok(usuarioService.gravarUsuarios(usuarioRequestDTO));
    }


    @GetMapping()
    public ResponseEntity<UsuarioResponseDTO> buscaUsuarioPorEmail(@RequestParam ("email") String email) {
        return ResponseEntity.ok(usuarioService.buscaDadosUsuario(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletaDadosUsuario(@RequestParam ("email") String email) {
        usuarioService.deletaDadosUsuario(email);
        return ResponseEntity.accepted().build();
    }

}
