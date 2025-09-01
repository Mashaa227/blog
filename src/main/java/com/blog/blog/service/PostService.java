package com.blog.blog.service;

import com.blog.blog.dto.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> findAllPost();
}
