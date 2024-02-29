package com.pfe.authsecurity.BabySitter;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BabySitterRepository extends JpaRepository<BabySitter, Long> {
    // Aucune implémentation nécessaire, Spring Data JPA gère cela pour vous
}
