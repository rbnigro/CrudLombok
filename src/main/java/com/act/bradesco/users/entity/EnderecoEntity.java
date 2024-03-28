package com.act.bradesco.users.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "endereco_entity")
public class EnderecoEntity {
	
	@Id
	private Long id;
	private Long usuarioId;
	private String logradouro;
	private String numero;
	private String complemento;
	private String cep;
	private String cidade;
	private String uf;

}
