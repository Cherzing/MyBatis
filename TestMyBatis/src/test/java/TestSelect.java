import cn.cherzing.pojo.Employee;
import cn.cherzing.util.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

import static cn.cherzing.util.MybatisUtils.commitAndCloseSqlSession;

/**
 * @author Cherzing
 * @date 2024/09/28 0028 20:02
 * @description testSelect
 */
public class TestSelect {

    @Test
    public void testSelect() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Employee employee = sqlSession.selectOne("getEmployeeById", 2);
        System.out.println(employee.getName());
        sqlSession.close();
    }
    @Test
    public void testInsert() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Employee employee = new Employee();
        employee.setName("xinting");
        employee.setAge(18);
        employee.setPosition("学生");
        sqlSession.insert("insertInfoEmployee",employee);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testUpdate() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("张思");
        employee.setAge(22);
        employee.setPosition("副经理");
        sqlSession.update("updateEmployee",employee);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testDelete() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        sqlSession.delete("deleteEmployeeById",1);
        commitAndCloseSqlSession(sqlSession);
    }
}
