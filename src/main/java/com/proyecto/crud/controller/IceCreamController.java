package com.proyecto.crud.controller;

import com.proyecto.crud.model.IceCream;
import com.proyecto.crud.service.IceCreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/icecream")
public class IceCreamController {
    private final IceCreamService iceCreamService;

    @Autowired
    public IceCreamController(IceCreamService iceCreamService) {
        this.iceCreamService = iceCreamService;
    }

    @GetMapping
    public List<IceCream> getAllIceCreams() {
        return iceCreamService.getIceCreams();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IceCream> getIceCreamById(@PathVariable Long id) {
        Optional<IceCream> iceCream = iceCreamService.getIceCreamById(id);
        return iceCream.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public IceCream createIceCream(@RequestBody IceCream iceCream) {
        return iceCreamService.createIceCream(iceCream);
    }

    @PostMapping("/{id}")
    public ResponseEntity<IceCream> updateIceCream(@PathVariable Long id, @RequestBody IceCream iceCreamDetails) {
        Optional<IceCream> iceCream = iceCreamService.updateIceCream(id, iceCreamDetails);
        return iceCream.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIceCream(@PathVariable Long id) {
        if (iceCreamService.deleteIceCream(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
