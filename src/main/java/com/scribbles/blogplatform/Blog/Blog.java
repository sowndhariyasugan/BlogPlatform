package com.scribbles.blogplatform.Blog;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
public class Blog {
    private int BlogId;
    @NotNull
    @NotBlank
    @Length(
            min = 5,
            max = 20
    )
    private int BlogUserId;
    private int BlogCategoryId;
    private String BlogTitle;
    private String BlogContent;


    public Blog(int blogId,int blogUserId,int BlogCategoryid,String BlogType,String BlogContent) {
        this.BlogId = blogId;
        this.BlogUserId=blogUserId;
        this.BlogCategoryId=BlogCategoryid;
        this.BlogTitle =BlogType;
        this.BlogContent=BlogContent;

    }

    public Blog() {

    }

    public String getBlogContent() {
        return BlogContent;
    }

    public void setBlogContent(String blogContent) {
        BlogContent = blogContent;
    }

    public int getBlogId() {
        return BlogId;
    }

    public void setBlogId(int blogId) {
        BlogId = blogId;
    }

    public int getBlogUserId() {
        return BlogUserId;
    }

    public void setBlogUserId(int blogUserId) {
        BlogUserId = blogUserId;
    }

    public int getBlogCategoryId() {
        return BlogCategoryId;
    }

    public void setBlogCategoryId(int blogCategory) {
        this.BlogCategoryId = blogCategory;
    }


    public String getBlogTitle() {
        return BlogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        BlogTitle = blogTitle;
    }


    @Override
    public String toString() {
        return "Blog{" +
                "BlogId=" + BlogId +
                ", BlogUserId=" + BlogUserId +
                ", BlogCategoryId=" + BlogCategoryId +
                ", BlogTtile='" + BlogTitle + '\'' +
                ", BlogContent='" + BlogContent + '\'' +
                '}';
    }
}
