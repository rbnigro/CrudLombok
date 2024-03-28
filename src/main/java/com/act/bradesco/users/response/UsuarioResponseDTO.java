package com.act.bradesco.users.response;

public record UsuarioResponseDTO(
		Long id,
        String nome,
        String email,
        EnderecoResponseDTO endereco) {

}
