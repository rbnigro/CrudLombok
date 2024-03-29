package com.act.bradesco.users.service;

import org.springframework.stereotype.Service;

import com.act.bradesco.users.entity.EnderecoEntity;
import com.act.bradesco.users.repository.EnderecoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnderecoService {
	
    private final EnderecoRepository enderecoRepository;

    public EnderecoEntity salvaEndereco(EnderecoEntity enderecoEntity) {
        return enderecoRepository.save(enderecoEntity);
    }

    public EnderecoEntity findByUsuarioId(Long usuarioId) {
        return enderecoRepository.findByUsuarioId(usuarioId);
    }

    public void deleteByUsuarioId(Long usuarioId) {
        enderecoRepository.deleteByUsuarioId(usuarioId);
    }
}
