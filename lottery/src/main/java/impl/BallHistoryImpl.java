package impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.BaseDao;
import mapper.BallHistoryMapper;
import model.BallHistory;

public class BallHistoryImpl extends BaseDao {

    private static Logger logger = LoggerFactory.getLogger("lottery");

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
        } catch (NullPointerException ne) {
            logger.info(dataNo + "期中奖记录未找到:", ne);
        } catch (IOException e) {
            logger.error("ERR", e);
        } finally {
            sqlSession.close();
        }
        return result;
    }

    public List<Integer> getHistoryDate() {
        SqlSession sqlSession = null;
        List<Integer> result = new ArrayList<Integer>();
        try {
            sqlSession = getSqlSession();
            BallHistoryMapper ballHistoryMapper = sqlSession.getMapper(BallHistoryMapper.class);
            result = ballHistoryMapper.getHistoryDate();
        } catch (IOException e) {
            logger.error("ERR", e);
        } finally {
            sqlSession.close();
        }
        return result;
    }

    //取得仅次于给定时间之下的中奖时间（如historyDate的给定时间为2017146期，实际上为2017145期）
    public List<Integer> getHistoryDate2(String historyDate) {
        SqlSession sqlSession = null;
        List<Integer> result = new ArrayList<Integer>();
        BallHistory ballHistory = new BallHistory();
        try {
            sqlSession = getSqlSession();
            BallHistoryMapper ballHistoryMapper = sqlSession.getMapper(BallHistoryMapper.class);
            ballHistory = ballHistoryMapper.getHistoryDate2(Integer.parseInt(historyDate));

            result.add(ballHistory.getRed1());
            result.add(ballHistory.getRed2());
            result.add(ballHistory.getRed3());
            result.add(ballHistory.getRed4());
            result.add(ballHistory.getRed5());
            result.add(ballHistory.getRed6());
        } catch (NullPointerException ne) {
            logger.info(historyDate + "的前一期中奖记录未找到:", ne);
        }catch (IOException e) {
            logger.error("ERR", e);
        } finally {
            sqlSession.close();
        }
        return result;
    }
}
