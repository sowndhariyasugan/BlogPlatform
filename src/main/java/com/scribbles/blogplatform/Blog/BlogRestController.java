package com.scribbles.blogplatform.Blog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/blogs")
public class BlogRestController {
    private final BlogService blogService;

    public BlogRestController(BlogService blogService){
        this.blogService=blogService;
    }

    @GetMapping
    public Iterable<Blog> getAll(){
        return this.blogService.getAllBlogs();
    }

    @GetMapping("{BlogId}")
    public Optional<Blog> getOne(
            @PathVariable("BlogId") Integer id
    ){
        return this.blogService.getBlogById(id);
    }
}
