package com.scribbles.blogplatform.Comment;
import com.scribbles.blogplatform.Blog.Blog;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public class CommentRepository {
    private final JdbcClient jdbcClient;
    public CommentRepository(JdbcClient jdbcClient){
        this.jdbcClient=jdbcClient;

    }
    RowMapper<Comment> CommentRowMapper=(rs, rowNo)->{
        int id = rs.getInt("COMMENTID");
        String CommentDescriptiom = rs.getString("COMMENTDESCRIPTION");
        int CommentedUser = rs.getInt("COMMENTEDUSER");
        String CommentSBlogId = rs.getString("COMMENTBLOGID");
        Comment comment=new Comment(id,CommentDescriptiom,CommentedUser,CommentedUser);
        return comment;
    };
    Iterable<Comment> findAll() {
        return jdbcClient.sql("SELECT COMMENTID,COMMENTDESCRIPTION,COMMENTEDUSER,BLOGID FROM COMMENT")
                .query(CommentRowMapper).list();
    }
    Optional<Comment> FindById(Integer id){
        return jdbcClient.sql("SELECT COMMENTID,COMMENTDESCRIPTION,COMMENTEDUSER,BLOGID FROM COMMENT WHERE COMMENTID=:id")
                .param("COMMENTID",id)
                .query(CommentRowMapper)
                .optional();
    }
}
