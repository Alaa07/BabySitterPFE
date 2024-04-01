package com.pfe.BabySitterPFE.repositories;

import com.pfe.BabySitterPFE.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
