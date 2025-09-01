package com.blog.blog.mapper;

import com.blog.blog.dto.PostDto;
import com.blog.blog.entity.Post;

public class PostMapper {

    //map post entity to post dto
    public static PostDto mapToDto(Post post) {
        PostDto postDto = PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .url(post.getUrl())
                .shortDescription(post.getShortDescription())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
        return postDto;
    }

    //map post dto to post entity
    public static Post mapToEntity(PostDto postDto) {
        Post post = Post.builder()
                .id(postDto.getId())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .url(postDto.getUrl())
                .shortDescription(postDto.getShortDescription())
                .createdAt(postDto.getCreatedAt())
                .updatedAt(postDto.getUpdatedAt())
                .build();
        return post;
    }
}
