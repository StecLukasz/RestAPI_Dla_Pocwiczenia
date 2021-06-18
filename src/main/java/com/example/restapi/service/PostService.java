package com.example.restapi.service;

import com.example.restapi.model.Post;
import com.example.restapi.repository.CommentRepository;
import com.example.restapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    public static final int PAGE_SIZE = 20;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;


public List<Post> getPosts(int page, Sort.Direction sort){
    return postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));  // robi się stała z liczby poprzez ctrl + alt + c
}


    public Post getSinglePost(long id) {
        return postRepository.findById(id)
                .orElseThrow();
    }


}
