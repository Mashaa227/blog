package com.blog.blog.controller;

import com.blog.blog.dto.PostDto;
import com.blog.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BlogController {

    private final PostService postService;

    //handler method to handle default request
    @GetMapping("/")
    public String home(Model model) {
        List<PostDto> posts = postService.findAllPost();
        model.addAttribute("posts", posts);
        return "blog/index";
    }

    //handler method to handle post request
    @GetMapping("/post/{url}")
    public String viewPost(Model model, @PathVariable String url) {
        PostDto postDto = postService.findByUrl(url);
        model.addAttribute("postDto", postDto);
        return "blog/viewPost";
    }

    //handler method to handle search request
    @GetMapping("/search")
    public String searchPosts(Model model, @RequestParam String query) {
        List<PostDto> posts = postService.searchPosts(query);
        model.addAttribute("posts", posts);
        return "blog/index";
    }
}
