package com.main.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.main.entity.PageCondition;
import com.main.entity.PageList;
import com.main.entity.PagesResult;
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
     *
     * @return
     */
    public PageList<UserEntity> getUserList(UserEntity user, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<UserEntity> allList = userMapper.getUserList(user,currentPage,pageSize);
        PageInfo<UserEntity> pageInfo = new PageInfo<>(allList);

        PageList pageList = new PageList();
        pageList.setDataList(allList);
        PageCondition pageCondition = new PageCondition();
        pageCondition.setPageSize(pageSize);
        pageCondition.setCurrentPage(currentPage);
        pageCondition.setTotalCount(pageInfo.getTotal());
        pageList.setPager(pageCondition);

        return pageList;
    }

    public void getMyList(UserEntity user, Integer currentPage, Integer pageSize){
        List<UserEntity> allList = userMapper.getMyList(user,currentPage,pageSize);
        System.out.println(allList);
    }

    /**
     * 新增
     *
     * @param user
     * @return
     */
    public Long insertData(UserEntity user) {
        userMapper.insert(user);
        return user.getId();
    }

    /**
     * 删除
     */
    public Long deleteData(Long id) {
        return userMapper.delete(id);
    }

}
