package com.zup.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zup.app.model.Endereco;

@Repository
@Transactional
public interface EnderecoRepository extends CrudRepository<Endereco, Long> {

}
