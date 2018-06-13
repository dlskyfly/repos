/**
 * @Title  MyTest.java
 * @Package  lottery
 * @Description  TODO
 * @author  Andy
 * @date  2018年6月13日 下午3:05:19
 * @version  V1.0
 * @Copyright  2018 http://www.dlmzk.com Inc. All rights reserved.
 */

package lottery;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mapper.BallHistoryMapper;
import mapper.BaseDao;
import model.BallHistory;

/**
 * @ClassName  MyTest
 * @Description  TODO
 */
public class MyTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public final void test() {
        BaseDao baseDao = new BaseDao();
        SqlSession sqlSession = null;

        try {
            sqlSession = baseDao.getSqlSession();
            BallHistoryMapper ballHistoryMapper = sqlSession.getMapper(BallHistoryMapper.class);
            BallHistory ballHistory = ballHistoryMapper.getHistoryByDataNo(2018001);
            System.out.println(ballHistory);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

    }

}

