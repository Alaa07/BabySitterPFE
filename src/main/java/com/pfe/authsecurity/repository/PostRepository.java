package com.pfe.authsecurity.repository;

import com.pfe.authsecurity.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
