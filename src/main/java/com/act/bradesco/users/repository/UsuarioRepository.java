package com.act.bradesco.users.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.act.bradesco.users.entity.UsuarioEntity;

public interface UsuarioRepository extends MongoRepository<UsuarioEntity, Long> {
	
    UsuarioEntity findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);

}
