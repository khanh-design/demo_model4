package com.example.demo_model4.repository;

import com.example.demo_model4.model.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeRepository extends CrudRepository<Type, Long> {
}
