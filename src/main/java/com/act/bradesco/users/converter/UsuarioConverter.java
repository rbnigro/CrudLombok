package com.act.bradesco.users.converter;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.act.bradesco.users.DTO.EnderecoRequestDTO;
import com.act.bradesco.users.DTO.UsuarioRequestDTO;
import com.act.bradesco.users.entity.EnderecoEntity;
import com.act.bradesco.users.entity.UsuarioEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UsuarioConverter {

    public UsuarioEntity paraUsuarioEntity(UsuarioRequestDTO usuarioRequestDTO) {
    	return UsuarioEntity.builder()
    			.id(UUID.randomUUID().toString())
                .nome(usuarioRequestDTO.getNome())
                .email(usuarioRequestDTO.getEmail())
                .dataCadastro(LocalDateTime.now())
                .build();

    }


    public EnderecoEntity paraEnderecoEntity(EnderecoRequestDTO enderecoRequestDTO, String usuarioId) {
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
