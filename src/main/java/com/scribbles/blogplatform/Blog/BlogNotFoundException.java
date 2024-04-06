package com.scribbles.blogplatform.Blog;
public class BlogNotFoundException extends RuntimeException{
    public BlogNotFoundException(Integer id) {
        super("Blog with id  = " + id + " not found.");
    }
}
