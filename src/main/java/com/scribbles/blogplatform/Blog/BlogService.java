package com.scribbles.blogplatform.Blog;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService {
    public final BlogRepository repository;

    public BlogService(BlogRepository repository)
    {
        this.repository=repository;
    }
    public Iterable<Blog> getAllBlogs(){
         return this.repository.findAll();
    }
    public Blog getOneBlog(Integer id) {
        return this.repository.FindById(id).orElseThrow(() -> new BlogNotFoundException(id));
    }
    Optional<Blog> getBlogById(Integer id) {
        return repository.FindById(id);
    }
    public void saveBlog(Blog blog) {
        if (blog.getBlogId() == 0) {
            this.repository.insert(blog);
        } else {
            this.repository.update(blog);
        }
    }

    public void deleteBlog(Integer id) {
        this.repository.deleteById(id);
    }
}
