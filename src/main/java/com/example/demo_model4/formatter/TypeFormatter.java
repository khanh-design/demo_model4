package com.example.demo_model4.formatter;

import com.example.demo_model4.model.Type;
import com.example.demo_model4.service.ITypeService;
import com.example.demo_model4.service.Impl.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class TypeFormatter implements Formatter<Type> {
    private final ITypeService typeService;

    @Autowired
    public TypeFormatter(ITypeService typeService) {
        this.typeService = typeService;
    }

    @Override
    public Type parse(String text, Locale locale) {
        Optional<Type> provinceOptional = typeService.findById(Long.parseLong(text));
        return provinceOptional.orElse(null);
    }

    @Override
    public String print(Type object, Locale locale) {
        return "[" + object.getCid() + ", " +object.getName() + "]";
    }
}
