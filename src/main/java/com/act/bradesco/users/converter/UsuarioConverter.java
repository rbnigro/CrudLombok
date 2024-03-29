package com.act.bradesco.users.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.act.bradesco.users.DTO.EnderecoRequestDTO;
import com.act.bradesco.users.DTO.UsuarioRequestDTO;
import com.act.bradesco.users.entity.EnderecoEntity;
import com.act.bradesco.users.entity.UsuarioEntity;

import java.time.LocalDateTime;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class UsuarioConverter {

    public UsuarioEntity paraUsuarioEntity(UsuarioRequestDTO usuarioRequestDTO) {
    	
        return UsuarioEntity.builder()
                .id(new Random().nextLong())
                .nome(usuarioRequestDTO.getNome())
         //       .documento(usuarioRequestDTO.getDocumento())
                .email(usuarioRequestDTO.getEmail())
                .dataCadastro(LocalDateTime.now())
                .build();

    }


    public EnderecoEntity paraEnderecoEntity(EnderecoRequestDTO enderecoRequestDTO, Long usuarioId) {
        return EnderecoEntity.builder()
                .logradouro(enderecoRequestDTO.getLogradouro())
                .numero(enderecoRequestDTO.getNumero())
                .complemento(enderecoRequestDTO.getComplemento())
                .cep(enderecoRequestDTO.getCep())
                .cidade(enderecoRequestDTO.getCidade())
                .uf(enderecoRequestDTO.getUf())
                .usuarioId(usuarioId)
                .build();
    }

}
