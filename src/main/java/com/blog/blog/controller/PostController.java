package com.blog.blog.controller;

import com.blog.blog.dto.PostDto;
import com.blog.blog.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    //create handler method for findAllPost
    @GetMapping("/admin/posts")
    public String post(Model model) {
         List<PostDto> postDtoList = postService.findAllPost();
         model.addAttribute("postDtoList", postDtoList);
         return "/admin/posts";
    }

    //create handler method for newPost
    @GetMapping("/admin/posts/newPost")
    public String newPost(Model model) {
        PostDto postDto = new PostDto();
        model.addAttribute("postDto", postDto);
        return "/admin/newPost";
    }

    //create handler method for savePost
    @PostMapping("/admin/posts")
    public String savePost(@Valid @ModelAttribute PostDto postDto, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("postDto", postDto);
            return "/admin/newPost";
        }
        postDto.setUrl(getUri(postDto.getTitle()));
        postService.createPost(postDto);
        return "redirect:/admin/posts";
    }

    //handler method to handle edit post
    @GetMapping("/admin/posts/{id}/edit")
    public String editPost(@PathVariable Long id, Model model) {
        PostDto postDto = postService.getPostById(id);
        model.addAttribute("postDto", postDto);
        return "/admin/editPost";
    }

    //Handler method to handle delete post
    @GetMapping("/admin/posts/{id}/delete")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/admin/posts";
    }

    //handler  methd to handle View post by id
    @GetMapping("/admin/posts/{id}/view")
    public String viewPost(@PathVariable Long id, Model model) {
        PostDto postDto = postService.getPostById(id);
        model.addAttribute("postDto", postDto);
        return "/admin/viewPost";
    }

    //Handler method to handle search post
    @GetMapping("/admin/posts/search")
    public String searchPost(@RequestParam String query, Model model) {
        List<PostDto> postDtoList = postService.searchPosts(query);
        model.addAttribute("postDtoList", postDtoList);
        return "/admin/posts";
    }

    private static String getUri(String postTitle) {
        String uri = postTitle.trim().toLowerCase();
        uri = uri.replaceAll("[^A-Za-z0-9]+", "-");
        uri = uri.replaceAll("\\s+", "-");
        return uri;
    }
}
