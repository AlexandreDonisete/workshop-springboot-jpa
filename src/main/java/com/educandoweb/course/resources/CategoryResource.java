package com.educandoweb.course.resources;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
@Tag(name = "Categorias", description = "Operações relacionadas às categorias")
public class CategoryResource {

    @Autowired
    private CategoryService Category;

    @Operation(
            summary = "Listar todos as categorias",
            description = "Busca todas as categorias"
    )
    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = Category.findAll();
        return ResponseEntity.ok().body(list);
    }

    @Operation(
            summary = "Buscar categoria por ID",
            description = "Busca uma categoria pelo ID"
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category obj = Category.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
