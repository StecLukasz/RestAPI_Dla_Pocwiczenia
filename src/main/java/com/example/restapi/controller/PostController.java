package com.example.restapi.controller;

import com.example.restapi.controller.dto.PostDto;
import com.example.restapi.model.Post;
import com.example.restapi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<PostDto> getPosts(@RequestParam(required = false) int page, Sort.Direction sort) {
        int pageNumber= page>=0 ? page: 0; // zabezpieczenie przed ujemnymi stronami
        return PostDtoMapper.mapToPostDtos(postService.getPosts(pageNumber, sort));
    }


    @GetMapping("/posts{id}")
    public Post getSinglePost(@PathVariable long id) {
        return postService.getSinglePost(id);
    }


}
