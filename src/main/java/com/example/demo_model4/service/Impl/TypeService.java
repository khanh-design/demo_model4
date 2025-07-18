package com.example.demo_model4.service.Impl;

import com.example.demo_model4.model.Type;
import com.example.demo_model4.repository.ITypeRepository;
import com.example.demo_model4.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeService implements ITypeService {
    @Autowired
    private ITypeRepository iTypeRepository;
    @Override
    public Iterable<Type> findAll() {
        return iTypeRepository.findAll();
    }

    @Override
    public Optional<Type> findById(Long id) {
        return iTypeRepository.findById(id);
    }

    @Override
    public void save(Type type) {
        iTypeRepository.save(type);
    }

    @Override
    public void delete(Long id) {
        iTypeRepository.deleteById(id);
    }
}
