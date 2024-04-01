package com.act.bradesco.users.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.act.bradesco.users.entity.EnderecoEntity;

@Repository
public interface EnderecoRepository extends MongoRepository<EnderecoEntity, String> {

    EnderecoEntity findByUsuarioId(String usuarioId);

    @Transactional
    void deleteByUsuarioId(String usuarioId);
}
