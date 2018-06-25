package impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import comm.Common;
import dao.BaseDao;
import mapper.BallRedFilterMapper;
import model.BallRedBase;
import model.BallRedFilter;

public class BallRedFilterImpl extends BaseDao {

    private static Logger logger = LoggerFactory.getLogger("lottery");

    public void fillFromBase() {
        BallRedBaseImpl ballRedBaseImpl = new BallRedBaseImpl();
        List<BallRedBase> redBaseList = ballRedBaseImpl.getAll();
        List<BallRedFilter> redFilterList = new ArrayList<BallRedFilter>();
        for (BallRedBase b : redBaseList) {
            BallRedFilter ballRedFilter = new BallRedFilter();
            ballRedFilter.setRed1(b.getRed1());
            ballRedFilter.setRed2(b.getRed2());
            ballRedFilter.setRed3(b.getRed3());
            ballRedFilter.setRed4(b.getRed4());
            ballRedFilter.setRed5(b.getRed5());
            ballRedFilter.setRed6(b.getRed6());
            redFilterList.add(ballRedFilter);
        }
        saveToDb(redFilterList);
    }

    public List<BallRedFilter> getRed() {
        SqlSession sqlSession = null;
        List<BallRedFilter> results = new ArrayList<BallRedFilter>();
        try {
            sqlSession = getSqlSession();
            BallRedFilterMapper mapper = sqlSession.getMapper(BallRedFilterMapper.class);
            results = mapper.getRed();
        } catch (IOException e) {
            logger.error("ERR", e);
        } finally {
            sqlSession.close();
        }
        return results;
    }

    public void delAll() {
        SqlSession sqlSession = null;
        try {
            sqlSession = getSqlSession();
            BallRedFilterMapper mapper = sqlSession.getMapper(BallRedFilterMapper.class);
            mapper.truncateTable();
            sqlSession.commit();
        } catch (IOException e) {
            logger.error("ERR", e);
        } finally {
            sqlSession.close();
        }
    }

    public int insertByBatch(List<BallRedFilter> datas) {
        int result = 0;
        SqlSession sqlSession = null;
        try {
            sqlSession = getSqlSession();
            BallRedFilterMapper mapper = sqlSession.getMapper(BallRedFilterMapper.class);
            int size = datas.size();
            int remainder = size % Common.PAGE_INTERCEPT;// 余数
            int quotient = (size - remainder) / Common.PAGE_INTERCEPT;// 商
            int count = 0;
            while (quotient-- > 0) {
                List<BallRedFilter> tmp = datas.subList((count * Common.PAGE_INTERCEPT),
                        (++count * Common.PAGE_INTERCEPT));
                result += mapper.insertByBatch(tmp);
                sqlSession.commit();
                logger.debug("Count: " + count);
            }
            result += mapper.insertByBatch(datas.subList(count * Common.PAGE_INTERCEPT, size));
            logger.debug("result: " + result);
            sqlSession.commit();
        } catch (IOException e) {
            logger.error("ERR", e);
        } finally {
            sqlSession.close();
        }
        return result;
    }

    public void saveToDb(List<BallRedFilter> datas) {
        delAll();
        insertByBatch(datas);
    }
}
