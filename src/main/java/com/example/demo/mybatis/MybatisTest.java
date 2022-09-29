package com.example.demo.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author dou.guo
 * @version MybatisTest, v 0.1 2022-09-26 3:39 下午 dou.guo Exp $
 */
public class MybatisTest {

    public static void main(String[] args) throws IOException {

        String resource = "config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        try {
            // 通过sqlSession先获取到Mapper接口对象
            /*BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog = mapper.selectBlogById(1688);
            System.out.println(blog);*/
        } finally {
            session.close();
        }
    }

}
