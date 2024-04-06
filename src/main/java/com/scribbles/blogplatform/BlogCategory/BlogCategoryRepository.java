package com.scribbles.blogplatform.BlogCategory;
import com.scribbles.blogplatform.Blog.Blog;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public class BlogCategoryRepository {
    private final JdbcClient jdbcClient;

    public BlogCategoryRepository(JdbcClient jdbcClient)
    {
        this.jdbcClient=jdbcClient;
    }

    RowMapper<BlogCategory> BlogCategoryRowMapper=(rs,rowNo)->
    {
        int id=rs.getInt("BLOGCATEGORYID");
        String BlogCategoryTitle=rs.getString("CATEGORYTITLE");
        String CategoryType=rs.getString("CATEGORYTYPE");
        String CategoryDescription=rs.getString("CATEGORYDESCRITION");
        BlogCategory blogCategory=new BlogCategory();
        blogCategory.setBlogCategoryId(id);
        blogCategory.setCategoryTitle(BlogCategoryTitle);
        blogCategory.setCategoryType(CategoryType);
        blogCategory.setCategoryDescription((CategoryDescription));
        return blogCategory;
    };

    Iterable<BlogCategory> findAll(){
        return jdbcClient.sql("SELECT BLOGCATEGORYID,CATEGORYTITLE,CATEGORYTYPE,CATEGORYDESCRIPTION FROM BLOGCATEGORY")
                .query(BlogCategoryRowMapper).list();
    }
    Optional<BlogCategory> FindById(Integer id){
        return jdbcClient.sql("SELECT BLOGCATEGORYID,CATEGORYTITLE,CATEGORYTYPE,CATEGORYDESCRIPTION FROM BLOGCATEGORY WHERE BLOGCATEGORYID=:id")
                .param("BLOGID",id)
                .query(BlogCategoryRowMapper)
                .optional();
    }

}
