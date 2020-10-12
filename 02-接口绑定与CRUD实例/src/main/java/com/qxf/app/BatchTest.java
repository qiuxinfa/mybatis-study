package com.qxf.app;

import com.qxf.mapper.UserMapper;
import com.qxf.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BatchTest {
    public static void main(String[] args) throws IOException {
        //读取配置信息
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //根据配置信息，创建SqlSession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //SqlSession工厂创建SqlSession
        SqlSession sqlSession = factory.openSession(ExecutorType.BATCH,false);
        //获取接口的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = new ArrayList<User>(100000);

        for (int i=0;i<100000;i++){
            User user = new User();
            user.setId(UUID.randomUUID().toString().replace("-",""));
            user.setIsValid(1);
            user.setPassword("123456");
            user.setUsername("test"+i);
            userList.add(user);
        }
        long start = System.currentTimeMillis();
        // 在sql中foreach循环拼接， 耗时： 16740 ms
       // mapper.addBatch(userList);

        // ExecutorType.BATCH， 耗时： 47374 ms
        for (int i=0;i<100000;i++){
            mapper.addUser(userList.get(i));
        }
        sqlSession.commit();
        long end = System.currentTimeMillis();
        System.out.println("耗时： "+(end-start)+" ms");
    }
}
