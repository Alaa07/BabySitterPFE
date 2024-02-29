package com.pfe.authsecurity.Parent;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pfe.authsecurity.Parent.Parent;

public interface ParentRepository extends JpaRepository<Parent, Long> {
    // Aucune implémentation nécessaire, Spring Data JPA gère cela pour vous
}

