package com.act.bradesco.users.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.act.bradesco.users.entity.EnderecoEntity;
import com.act.bradesco.users.entity.UsuarioEntity;
import com.act.bradesco.users.response.UsuarioResponseDTO;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "id", source = "usuario.id")
    @Mapping(target = "nome", source = "usuario.nome")
    @Mapping(target = "email", source = "usuario.email")
//    @Mapping(target = "bairro", source = "usuario.bairro")
  //  @Mapping(target = "documento", source = "usuario.documento")
    @Mapping(target = "endereco", source = "enderecoEntity")
    UsuarioResponseDTO paraUsuarioResponseDTO(UsuarioEntity usuario, EnderecoEntity enderecoEntity);

}
