package com.example.demo_model4.controller;

import com.example.demo_model4.model.Product;
import com.example.demo_model4.service.Impl.ProductService;
import com.example.demo_model4.model.Type;
import com.example.demo_model4.service.Impl.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private TypeService typeService;

    @ModelAttribute("types")
    public Iterable<Type> ListTypes() {
        return typeService.findAll();
    }

//    @GetMapping("")
//    public ModelAndView home() {
//        Iterable<Product> products = productService.findAll();
//        ModelAndView modelAndView = new ModelAndView("/product/home");
//        modelAndView.addObject("products", products);
//        return modelAndView;
//    }

    @GetMapping("")
    public ModelAndView list(@PageableDefault(size = 2) Pageable pageable) {
        Page<Product> products = productService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/product/home");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(Model model) {
        model.addAttribute("products",new Product());
        ModelAndView modelAndView = new ModelAndView("/product/create");
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("product") Product product, @Valid
                        BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            return "/product/create";
        }
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        Iterable<Type> types = typeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/product/edit");
        modelAndView.addObject("product", product.get());
        modelAndView.addObject("types", types);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String updateProduct(@ModelAttribute Product product) {
        Long typeId = product.getType().getCid();
        Type type = typeService.findById(typeId).orElse(null);
        product.setType(type);
        productService.save(product);
        return "redirect:/products";
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        productService.delete(id);
        return new ModelAndView("redirect:/products");
    }
}
