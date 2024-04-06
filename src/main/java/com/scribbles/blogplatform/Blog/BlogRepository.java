package com.scribbles.blogplatform.Blog;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.*;
import java.util.Optional;


@Repository
public class BlogRepository {
    private final JdbcClient jdbcClient;

    public BlogRepository(JdbcClient jdbcClient)
    {
        this.jdbcClient = jdbcClient;
    }
    RowMapper<Blog> BlogRowMapper=(rs,rowNo)->{
        int id = rs.getInt("BLOGID");
        int BlogUserId = rs.getInt("BLOGUSERID");
        int BlogCategoryId = rs.getInt("BLOGCATEGORYID");
        String BlogTitle = rs.getString("BLOGTITLE");
        String BlogContent = rs.getString("BLOGCONTENT");
        Blog blog =new Blog();
        blog.setBlogId(id);
        blog.setBlogUserId(BlogUserId);
        blog.setBlogCategoryId(BlogCategoryId);
        blog.setBlogTitle(BlogTitle);
        blog.setBlogContent(BlogContent);
        return blog;
    };
    Iterable<Blog> findAll() {
        return jdbcClient.sql("SELECT BLOGID,BLOGUSERID,BLOGCATEGORYID,BLOGTITLE,BLOGCONTENT FROM BLOGS")
                .query(BlogRowMapper).list();
    }
    Optional<Blog> FindById(Integer id){
        return jdbcClient.sql("SELECT BLOGID,BLOGUSERID,BLOGCATEGORYID,BLOGTITLE,BLOGCONTENT FROM BLOGS WHERE BLOGID=:id")
                .param("id",id)
                .query(BlogRowMapper)
                .optional();
    }
    public Blog CreateBlog(Blog blog) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcClient.sql("INSERT INTO BLOGS(BLOGID,BLOGUSERID,BLOGCATEGORYID,BLOGTITLE,BLOGCONTENT) VALUES (:blogId ,:blogUserId, :blogCategoryId, :blogTitle, :blogContent)")
                .params(Map.of(
                        "BLOGID", blog.getBlogId(),
                        "BLOGUSERID", blog.getBlogUserId(),
                        "BLOGCATEGORYID", blog.getBlogCategoryId(),
                        "BLOGTITLE", blog.getBlogTitle(),
                        "BLOGCONTENT", blog.getBlogContent()
                ))
                .update(keyHolder);

        blog.setBlogId(Integer.parseInt(keyHolder.getKey().toString()));
        return blog;
    }

    public void insert(Blog blog) {
        this.jdbcClient.sql("INSERT INTO BLOGS (BLOGID,BLOGUSERID,BLOGCATEGORYID,BLOGTITLE,BLOGCONTENT) VALUES (:blogId ,:blogUserId, :blogCategoryId, :blogTitle, :blogContent)")
                .param("blogId", blog.getBlogId())
                .param("blogUserId", blog.getBlogUserId())
                .param("blogCategoryId", blog.getBlogCategoryId())
                .param("blogTitle",blog.getBlogTitle() )
                .param("blogContent", blog.getBlogContent())
                .update();
    }

    public void update(Blog blog) {
        this.jdbcClient.sql("UPDATE BLOGS SET BLOGID = :blogId, BLOGUSERID= :blogUserId, BLOGCATEGORYID = :blogCategoryId, BLOGTITLE = :blogTitle, BLOGCONTENT = :blogContent WHERE BLOGID = :blogId")
                .param("blogId", blog.getBlogId())
                .param("blogUserId", blog.getBlogUserId())
                .param("blogCategoryId", blog.getBlogCategoryId())
                .param("blogTitle",blog.getBlogTitle() )
                .param("blogContent", blog.getBlogContent())
                .update();
    }

    public void deleteById(Integer id) {
        jdbcClient.sql("DELETE FROM BLOGS WHERE BLOGID = :id")
                .param("id", id)
                .update();
    }

    public void save(Blog blog) {
        this.jdbcClient.sql("INSERT INTO BLOGS (BLOGID,BLOGUSERID,BLOGCATEGORYID,BLOGTITLE) VALUES (:BlogId, :BlogUserId, :BlogCategoryId, :BlogTitle)")
                .param("BlogId", blog.getBlogId())
                .param("BlogUserId", blog.getBlogUserId())
                .param("BlogCategoryId", blog.getBlogCategoryId())
                .param("BlogTitle", blog.getBlogTitle())
                .update();
    }

}