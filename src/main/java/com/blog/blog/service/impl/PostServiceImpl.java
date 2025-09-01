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

    @Override
    public void createPost(PostDto postDto) {
        Post post = PostMapper.mapToEntity(postDto);
        postRepository.save(post);
    }

    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepository.findById(id).get();
        return PostMapper.mapToDto(post);
    }

    @Override
    public PostDto findByUrl(String url) {
        return PostMapper.mapToDto(postRepository.findByUrl(url).get());
    }


    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);

    }

    @Override
    public List<PostDto> searchPosts(String query) {
        List<Post> posts = postRepository.searchPosts(query);
        return posts.stream().map(PostMapper::mapToDto).toList();
    }
}
