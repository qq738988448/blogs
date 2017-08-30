package com.example.blogs;

import com.example.blogs.model.Blog;
import com.example.blogs.repository.BlogRepository;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by puhui on 2017-08-30.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "application.yml")
public class ElasticSearchTest {
    @Autowired
    private BlogRepository blogRepository;

    @Test
    public void test() {
        List<Blog> list = new ArrayList<>();
        list.add(new Blog("王瀚", "默认进行了elasticsearch安装和ik安装, 超时配置, 分页压力配置等"));
        list.add(new Blog("李志昂", "更换哦啊说大话了速度快回家啊电话开始"));
        list.add(new Blog("阿斯达", "阿萨帝吃奶utypovvhjuasdmfgyasdjgb"));
        blogRepository.save(list);
    }

    @Test
    public void searchTest() {
        QueryStringQueryBuilder builder=new QueryStringQueryBuilder("速度快回");
        Iterable<Blog> search = blogRepository.search(builder);
        Iterator<Blog> iterator = search.iterator();
        while (iterator.hasNext()){
            Blog next = iterator.next();
            System.out.println(next.toString());
        }
        System.out.println();
    }

}
