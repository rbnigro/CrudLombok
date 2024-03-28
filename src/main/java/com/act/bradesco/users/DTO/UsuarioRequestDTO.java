package com.act.bradesco.users.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class UsuarioRequestDTO {
	private String nome;
	
	@JsonProperty(required = true)
	private String email;
	
	private EnderecoRequestDTO endereco;

}
