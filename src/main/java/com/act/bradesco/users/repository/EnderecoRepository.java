package com.act.bradesco.users.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.act.bradesco.users.entity.EnderecoEntity;

public interface EnderecoRepository extends MongoRepository<EnderecoEntity, Long> {

    EnderecoEntity findByUsuarioId(Long usuarioId);

    @Transactional
    void deleteByUsuarioId(Long usuarioId);
}
