package com.educandoweb.course.resources;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;
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
@RequestMapping(value = "/orders")
@Tag(name = "Ordens", description = "Operações relacionadas às ordens")
public class OrderResource {

    @Autowired
    private OrderService order;

    @Operation(
            summary = "Listar todos as ordens",
            description = "Busca todas as ordens"
    )
    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = order.findAll();
        return ResponseEntity.ok().body(list);
    }

    @Operation(
            summary = "Buscar ordem por ID",
            description = "Busca uma ordem pelo ID"
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order obj = order.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
