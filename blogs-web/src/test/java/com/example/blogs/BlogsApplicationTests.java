package com.example.blogs;

import com.example.blogs.dao.UsersMapper;
import com.example.blogs.model.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@MapperScan("com.example.blogs.dao")
@EnableTransactionManagement
public class BlogsApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UsersMapper usersMapper;

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void contextLoads() {
        Users users = usersMapper.selectByPrimaryKey(1L);
        users.setPassword("123456");
        usersMapper.updateByPrimaryKey(users);
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }

}
