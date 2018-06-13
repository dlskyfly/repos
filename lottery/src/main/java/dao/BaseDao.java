
/**
 * @Title  BaseDao.java
 * @Package  impl
 * @Description  TODO
 * @author  Andy
 * @date  2018年6月13日 下午1:56:15
 * @version  V1.0
 * @Copyright  2018 http://www.dlmzk.com Inc. All rights reserved.
 */

package dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @ClassName BaseDao
 * @Description TODO
 * @author Andy
 * @date 2018年6月13日
 */

public class BaseDao {

    private SqlSessionFactory sqlSessionFactory;

    public BaseDao() {
        super();
    }

    private SqlSessionFactory getSqlSessionFactory() throws IOException {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
           return new SqlSessionFactoryBuilder().build(inputStream);
    }

    public SqlSession getSqlSession() throws IOException {
        if (sqlSessionFactory == null) {
            sqlSessionFactory = getSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}
