package com.educandoweb.course.resources;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
@Tag(name = "Produtos", description = "Operações relacionadas aos produtos")
public class ProductResource {

    @Autowired
    private ProductService Product;

    @Operation(
            summary = "Listar todos os produtos",
            description = "Busca todos os produtos"
    )
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = Product.findAll();
        return ResponseEntity.ok().body(list);
    }

    @Operation(
            summary = "Buscar produto por ID",
            description = "Busca um produto pelo ID"
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product obj = Product.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
