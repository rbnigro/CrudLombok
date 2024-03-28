package com.act.bradesco.users.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.act.bradesco.users.entity.EnderecoEntity;

public interface EnderecoRepository extends MongoRepository<EnderecoEntity, Long> {

}
