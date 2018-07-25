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

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.BaseDao;
import filter.JumpNumber;
import impl.BallRedFilterImpl;
import model.BallRedFilter;

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

//            sqlSession = baseDao.getSqlSession();
//            BallHistoryImpl ballHistoryImpl = new BallHistoryImpl();
//            List<Integer> list = ballHistoryImpl.getHistoryByDataNo(2016147);
//            System.out.println(list);
            JumpNumber jumpNumber = new JumpNumber();
            BallRedFilterImpl ballRedFilterImpl = new BallRedFilterImpl();
            ballRedFilterImpl.fillFromBase();
            List<BallRedFilter> datas = ballRedFilterImpl.getRed();
//            jumpNumber.filter(Arrays.asList(0,1), datas, 2016147);
    }
}
