package com.qxf.app;

import com.qxf.mapper.UserMapper;
import com.qxf.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: qiuxinfa
 * @Date: 2020/3/4
 * @Description: com.qxf.app
 */
public class One2OneQuery {
    public static void main(String[] args) throws IOException{
        //读取配置信息
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //根据配置信息，创建SqlSession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //SqlSession工厂创建SqlSession
        SqlSession sqlSession = factory.openSession();
        //获取接口的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById("123");
        System.out.println(user);
    }

}
