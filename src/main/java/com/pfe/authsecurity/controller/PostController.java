package com.pfe.authsecurity.controller;

import com.pfe.authsecurity.entity.Post;
import com.pfe.authsecurity.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
//@RequiredArgsConstructor
public class PostController {

   @Autowired
    private PostService service;
    @PostMapping("/addpost")
    public Post addPost(@RequestBody Post post){
        return service.savePost(post);
    }
    @PostMapping("/addposts")
    public List<Post> addPost(@RequestBody List<Post> posts){
        return service.savePosts(posts);
    }
    @GetMapping
    public List<Post> findAllPosts(){
        return service.getPosts();
    }
    @GetMapping("/post/{idPost}")
    public Post findPostById(@PathVariable Long idPost){
        return service.getPostById(idPost);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        Post updatedPostResult = service.updatePost(id, updatedPost);

        if (updatedPostResult != null) {
            return ResponseEntity.ok(updatedPostResult);
        } else {
            return ResponseEntity.notFound().build(); // Or any other appropriate response
        }
    }
    @DeleteMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id){
        return service.deletePost(id);
    }
}

