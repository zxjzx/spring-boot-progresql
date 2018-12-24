package com.main.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.main.mapper.UserMapper;
import com.main.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.main.model.User;

@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserMapper userMapper;

    public List<User> getList() {
        String sql = "SELECT id, name, password FROM test.user ";
        return (List<User>) jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                return user;
            }

        });
    }


    public List<User> getMyList() {
        String sql = "SELECT id,name,password FROM public.user";
        return (List<User>) jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        });
    }

    public String getString() {
        return "hello my name";
    }


    /**
     * 获取所有list
     * @return
     */
    public List<UserEntity> testMapping(){
        List<UserEntity> list =  userMapper.getAll();
        return list;
    }

    /**
     * 新增
     * @param user
     * @return
     */
    public Long insertData(UserEntity user){
        userMapper.insert(user);
        return user.getId();
    }

}
