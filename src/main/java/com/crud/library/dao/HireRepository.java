package com.crud.library.dao;

import com.crud.library.domain.Hire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface HireRepository extends CrudRepository<Hire, Long> {
}
