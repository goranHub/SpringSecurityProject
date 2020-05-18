package com.example.data;

import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDataAccessService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> selectAllUsers() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, mapUserFomDb());
    }


    //POST user
    public void setUser(User user) {
        this.jdbcTemplate.update(
                "INSERT INTO user (id, login, password, fname, lname, email) VALUES(?,?,?,?,?,?)",
                user.getId(), user.getLogin(), user.getPassword(),
                user.getFname(),user.getLname(),user.getEmail());
    }


    //PUT user
    public void updateUser(int userId, User user) {
        this.jdbcTemplate.update(
                "UPDATE user SET login = ?, password = ?, fname = ?, lname = ?, email = ? WHERE id = ?",
                user.getLogin(), user.getPassword(), user.getFname(), user.getLname(), user.getEmail(), userId);
    }


    //GET /user/{id}
    public User getUserbyID(int userID) {
        String sql = "SELECT * FROM user WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userID}, mapUserFomDb());
    }

    //delete
    public boolean deleteUser(int userId) {
        return jdbcTemplate.update("DELETE FROM user where id = ?", userId) > 0;
    }



    public User loadUserByUsername(String username) {
        String sql = "SELECT * FROM user WHERE fname=?";
        User user = jdbcTemplate.queryForObject(sql, new Object[]{username}, mapUserFomDb());
        return user;
    }



    private RowMapper<User> mapUserFomDb() {
        return (resultSet, i) -> {
            int id = Integer.valueOf(resultSet.getString("id"));
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");
            String fname = resultSet.getString("fname");
            String lname = resultSet.getString("lname");
            String email = resultSet.getString("email");
            return new User(id,login,password,fname,lname,email);
        };
    }
}
