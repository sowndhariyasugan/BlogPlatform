package com.scribbles.blogplatform.Comment;

public class Comment {
    private int CommentId;
    private String  CommentDescription;
    private int CommentedUserId;
    private int CommentBlogId;

    public Comment(int commentId, String commentDescription, int commentedUserId, int commentBlogId) {
        CommentId = commentId;
        CommentDescription = commentDescription;
        CommentedUserId = commentedUserId;
        CommentBlogId = commentBlogId;
    }

    public int getCommentId() {
        return CommentId;
    }

    public void setCommentId(int commentId) {
        CommentId = commentId;
    }

    public String getCommentDescription() {
        return CommentDescription;
    }

    public void setCommentDescription(String commentDescription) {
        CommentDescription = commentDescription;
    }

    public int getCommentedUserId() {
        return CommentedUserId;
    }

    public void setCommentedUserId(int commentedUserId) {
        CommentedUserId = commentedUserId;
    }

    public int getCommentBlogId() {
        return CommentBlogId;
    }

    public void setCommentBlogId(int commentBlogId) {
        CommentBlogId = commentBlogId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "CommentId=" + CommentId +
                ", CommentDescription='" + CommentDescription + '\'' +
                ", CommentedUserId=" + CommentedUserId +
                ", CommentBlogId=" + CommentBlogId +
                '}';
    }
}
