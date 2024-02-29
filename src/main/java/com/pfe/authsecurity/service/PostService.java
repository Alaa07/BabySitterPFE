package com.pfe.authsecurity.service;

import com.pfe.authsecurity.entity.Post;
import com.pfe.authsecurity.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public Post savePost(Post post){
        return repository.save(post);
    }
    public List<Post> savePosts(List<Post> posts){
        return repository.saveAll(posts);
    }
    public  List<Post> getPosts(){
        return repository.findAll();
    }
    public  Post getPostById(Long idPost){
        return repository.findById(idPost).orElse(null);
    }
    public String deletePost(Long idPost){ repository.deleteById(idPost); return "post removed !!"+idPost; }
  /*  public Post updatePost(Post post){
        Post existingPost=repository.findById(post.getIdPost()).orElse(null);
        existingPost.setSubject(post.getSubject());
        existingPost.setContent(post.getContent());
        existingPost.setPublicationDate(post.getPublicationDate());
        return repository.save(existingPost);
    }

   */
  public Post updatePost(Long id, Post post){
      Optional<Post> existingPostOptional = repository.findById(id);
      if (existingPostOptional.isPresent()) {
          Post existingPost = existingPostOptional.get();
          existingPost.setSubject(post.getSubject());
          existingPost.setContent(post.getContent());
          existingPost.setPublicationDate(post.getPublicationDate());
          existingPost.setUser(post.getUser());
          return repository.save(existingPost);
      } else {
          return null; // Or handle the case where the post with the given id does not exist
      }
  }
}
