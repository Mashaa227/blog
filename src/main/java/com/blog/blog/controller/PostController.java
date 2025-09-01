package com.blog.blog.controller;

import com.blog.blog.dto.PostDto;
import com.blog.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
