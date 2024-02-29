package com.pfe.authsecurity.Parent;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {
    private final ParentRepository parentRepository;

    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    public Parent add(Parent parent) {
        if (parent.getIdParent() != null) {
            throw new IllegalArgumentException("Cannot add parent with existing ID");
        }
        // Enregistrer le parent dans la base de données
        return parentRepository.save(parent);
    }

    public Parent getParentById(Long parentId) {
        return parentRepository.findById(parentId)
                .orElseThrow(() -> new CustomNotFoundException("Parent not found"));
    }

    public Parent createParent(Parent parent) {
        return parentRepository.save(parent);
    }

    public Parent update(Parent parent) {
        if (parent.getIdParent() == null) {
            throw new IllegalArgumentException("Cannot update parent without ID");
        }
        // Vérifier si le parent existe dans la base de données
        getParentById(parent.getIdParent());
        return parentRepository.save(parent);
    }

    public void deleteParent(Long parentId) {
        if (!parentRepository.existsById(parentId)) {
            throw new CustomNotFoundException("Parent not found");
        }
        parentRepository.deleteById(parentId);
    }
}
