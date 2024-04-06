package com.scribbles.blogplatform.Blog;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Optional;
@Controller
@RequestMapping("blogs")
public class BlogController {
    private final BlogService blogService;

    public BlogController(
            BlogService blogService
    ) {
        this.blogService = blogService;
    }

    @GetMapping("new")
    public String newBlogForm(
            Model model
    ) {
        Blog blog = new Blog();
        model.addAttribute("blog", blog);
        return "NewBlog";
    }

    @PutMapping
    public String updateOrCreateBlog(
            @ModelAttribute Blog blog
    ) {
        this.blogService.saveBlog(blog);
        return "redirect:/blogs";
    }
    @GetMapping("{BlogId}")
    public String showOneBlog (
            Model model,
            @PathVariable("BlogId") Integer id,
            HttpServletRequest request
    ) {
        Integer userId = (Integer) request.getSession().getAttribute("BlogId");
        Optional<Blog> blog = this.blogService.getBlogById(id);
        if (blog.isEmpty()) {
            model.addAttribute(
                    "error",
                    "Blog with id " + id + " not found"
            );
        } else {
            model.addAttribute(
                    "blog",
                    blog.get()
            );
        }
        return "view";
    }

    @GetMapping
    public String showAllBlogs(
            Model model,
            HttpServletRequest request

    ){
        Integer UserId=(Integer)request.getSession().getAttribute("UserId");
        System.out.println("user id: = "+UserId);
        Iterable<Blog> allBlogs=this.blogService.getAllBlogs();
        model.addAttribute("data",allBlogs);
        return "blogs";
    }

    @GetMapping("{blogId}/update")
    public String showUpdateForm(
            @PathVariable("blogId") Integer id,
            HttpServletRequest request,
            Model model
    ) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        Optional<Blog> blog = this.blogService.getBlogById(id);
        if (blog.isEmpty()) {
            return "redirect:/blogs";
        }
        model.addAttribute("blog", blog.get());
        return "NewBlog";
    }

    @DeleteMapping("{blogId}")
    public String deleteBlog(
            @PathVariable("blogId") Integer id,
            HttpServletRequest request,
            Model model
    ) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");

        this.blogService.deleteBlog(id);
        return "redirect:/blogs";
    }



}
