package impl;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import mapper.BaseDao;
import model.BallHistory;

public class BallHistoryImpl extends BaseDao {

	public int[] getHistoryByDataNo(int dataNo) {
	    SqlSession sqlSession = null;

	    try {
	        sqlSession = getSqlSession();
            BallHistory ballHistory = sqlSession.getMapper(BallHistory.class);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

		int[] historys = new int[6];
		return historys;
	}
}
