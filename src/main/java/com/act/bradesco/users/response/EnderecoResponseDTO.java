package com.act.bradesco.users.response;

public record EnderecoResponseDTO(
		String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cep,
        String cidade,
        String uf
        ) {

}
