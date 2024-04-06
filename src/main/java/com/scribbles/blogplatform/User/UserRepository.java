package com.scribbles.blogplatform.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public class UserRepository {
    private final JdbcClient jdbcClient;

    public UserRepository(JdbcClient jdbcClient)
    {
        this.jdbcClient=jdbcClient;
    }
    RowMapper<User> UserRowMapper=(rs,rowNo)->{
        int id=rs.getInt("BLOGUSERID");
        String UserName=rs.getString("USERNAME");
        String UserPhoneNo=rs.getString("USERPHONENO");
        String UserEmail=rs.getString("USEREMAIL");
        User user=new User();
        user.setUserId(id);
        user.setUserName(UserName);
        user.setUserEmail(UserEmail);
        user.setUserPhoneNo(UserPhoneNo);
        return user;
    };
    Iterable<User> findAll(){
        return jdbcClient.sql("SELECT BLOGUSERID,USERNAME,USERPHONENO,USERMAIL FROM USERS")
                .query(UserRowMapper).list();
    }

    Optional<User> FindById(Integer id){
        return jdbcClient.sql("SELECT BLOGUSERID,USERNAME,USERPHONENO,USERMAIL FROM USERS WHERE BLOGUSERID=:id")
                .param("BLOGUSERID",id)
                .query(UserRowMapper)
                .optional();
    }
}
