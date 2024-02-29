package com.pfe.authsecurity.Parent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parents")
public class ParentController {
    private final ParentService parentService;

    @Autowired
    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    // Ajouter un nouveau parent
    @PostMapping("/add")
    public ResponseEntity<Parent> add(@RequestBody Parent parent) {
        return ResponseEntity.ok(parentService.add(parent));
    }

    // Récupérer tous les parents
    @GetMapping("/allParent")
    public ResponseEntity<List<Parent>> getAllParents() {
        return new ResponseEntity<>(parentService.getAllParents(), HttpStatus.FOUND);
    }

    // Récupérer un parent par son ID
    @GetMapping("/{parentId}")
    public Parent getParentById(@PathVariable Long parentId) {
        return parentService.getParentById(parentId);
    }

    // Créer un nouveau parent
    @PostMapping
    public Parent createParent(@RequestBody Parent parent) {
        return parentService.createParent(parent);
    }

    // Mettre à jour un parent existant
    @PutMapping("/update")
    public ResponseEntity<Parent> update(@RequestBody Parent parent) {
        return ResponseEntity.ok(parentService.update(parent));
    }

    // Supprimer un parent
    @DeleteMapping("/{parentId}")
    public void deleteParent(@PathVariable Long parentId) {
        parentService.deleteParent(parentId);
    }
}
