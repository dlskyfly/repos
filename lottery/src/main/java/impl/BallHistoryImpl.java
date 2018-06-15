package impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.BaseDao;
import mapper.BallHistoryMapper;
import model.BallHistory;

public class BallHistoryImpl extends BaseDao {

	public List<Integer> getHistoryByDataNo(int dataNo) {
	    SqlSession sqlSession = null;
	    List<Integer> result = new ArrayList<Integer>();
	    try {
	        sqlSession = getSqlSession();
	        BallHistoryMapper ballHistoryMapper = sqlSession.getMapper(BallHistoryMapper.class);
	        BallHistory ballHistory = ballHistoryMapper.getHistoryByDataNo(dataNo);
            result.add(ballHistory.getRed1());
            result.add(ballHistory.getRed2());
            result.add(ballHistory.getRed3());
            result.add(ballHistory.getRed4());
            result.add(ballHistory.getRed5());
            result.add(ballHistory.getRed6());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
		return result;
	}
}
