package cn.cherzing.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Cherzing
 * @date 2024/10/07 0007 13:49
 * @description MybatisUtils
 */
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory = null;
    static InputStream inputStream;

    static {
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
    public static void commitAndCloseSqlSession(SqlSession sqlSession){
        sqlSession.commit();
        sqlSession.close();
    }
}
