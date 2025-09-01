package com.blog.blog.service.impl;

import com.blog.blog.dto.PostDto;
import com.blog.blog.entity.Post;
import com.blog.blog.mapper.PostMapper;
import com.blog.blog.repository.PostRepository;
import com.blog.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<PostDto> findAllPost() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(PostMapper::mapToDto).toList();
    }
}
