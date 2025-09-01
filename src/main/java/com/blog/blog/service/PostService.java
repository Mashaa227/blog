package com.blog.blog.service;

import com.blog.blog.dto.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> findAllPost();

    void createPost(PostDto postDto);

    PostDto getPostById(Long id);

    PostDto findByUrl(String url);

    void deletePost(Long id);

    List<PostDto> searchPosts(String query);
}
