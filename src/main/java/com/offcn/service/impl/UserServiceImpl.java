package com.offcn.service.impl;

import com.offcn.pojo.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<User> getUserList() {

        return jdbcTemplate.query("select * from user", new BeanPropertyRowMapper(User.class));
    }

    @Override
    public void createUser(User user) {

        String sql="insert into user(username,password) values(?,?)";
        jdbcTemplate.update(sql,new Object[]{user.getUsername(),user.getPassword()});
    }

    @Override
    public User getUser(Long id) {

        return (User)jdbcTemplate.queryForObject("select * from user where id=?",new BeanPropertyRowMapper(User.class),id);

    }

    @Override
    public void updateUser(Long id, User user) {
        jdbcTemplate.update("update user set username=?,password=? where id=?",user.getUsername(),user.getPassword(),id);
    }

    @Override
    public void deleteUser(Long id) {

        jdbcTemplate.update("delete from user where id=?",id);
    }
}
