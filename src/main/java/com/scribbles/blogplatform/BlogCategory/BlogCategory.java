package com.scribbles.blogplatform.BlogCategory;

public class BlogCategory {
    private int BlogCategoryId;
    private String CategoryTitle;
    private String CategoryType;
    private String CategoryDescription;

    public BlogCategory(int blogCategoryId, String categoryTitle, String categoryType, String categoryDescription) {
        BlogCategoryId = blogCategoryId;
        CategoryTitle = categoryTitle;
        CategoryType = categoryType;
        CategoryDescription = categoryDescription;
    }

    public BlogCategory() {

    }

    public int getBlogCategoryId() {
        return BlogCategoryId;
    }

    public void setBlogCategoryId(int blogCategoryId) {
        BlogCategoryId = blogCategoryId;
    }

    public String getCategoryTitle() {
        return CategoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        CategoryTitle = categoryTitle;
    }

    public String getCategoryType() {
        return CategoryType;
    }

    public void setCategoryType(String categoryType) {
        CategoryType = categoryType;
    }

    public String getCategoryDescription() {
        return CategoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        CategoryDescription = categoryDescription;
    }

    @Override
    public String toString() {
        return "BlogCategory{" +
                "BlogCategoryId=" + BlogCategoryId +
                ", CategoryTitle='" + CategoryTitle + '\'' +
                ", CategoryType='" + CategoryType + '\'' +
                ", CategoryDescription='" + CategoryDescription + '\'' +
                '}';
    }
}
