package com.example.demo_model4.service.Impl;

import com.example.demo_model4.model.Product;
import com.example.demo_model4.model.Type;
import com.example.demo_model4.repository.IProductRepository;
import com.example.demo_model4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Iterable<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public Iterable<Product> findAllByType(Type types) {
        return iProductRepository.findAllByType(types);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }
}
