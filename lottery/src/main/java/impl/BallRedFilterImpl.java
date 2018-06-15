package impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.BaseDao;
import mapper.BallRedFilterMapper;
import model.BallRedBase;
import model.BallRedFilter;

public class BallRedFilterImpl extends BaseDao {

    public void fillFromBase() {
        delAll();
        BallRedBaseImpl ballRedBaseImpl = new BallRedBaseImpl();
        List<BallRedBase> redBaseList = ballRedBaseImpl.getAll();
        List<BallRedFilter> redFilterList = new ArrayList<BallRedFilter>();
        for(BallRedBase b: redBaseList) {
            BallRedFilter ballRedFilter = new BallRedFilter();
            ballRedFilter.setRed1(b.getRed1());
            ballRedFilter.setRed2(b.getRed2());
            ballRedFilter.setRed3(b.getRed3());
            ballRedFilter.setRed4(b.getRed4());
            ballRedFilter.setRed5(b.getRed5());
            ballRedFilter.setRed6(b.getRed6());
        }
        saveToDb(redFilterList);
    }

//    public List<List<Integer>> getRed() {
//        SqlSession sqlSession = null;
//        List<List<Integer>> results = new ArrayList<List<Integer>>();
//        try {
//            sqlSession = getSqlSession();
//            BallRedFilterMapper mapper = sqlSession.getMapper(BallRedFilterMapper.class);
//            List<BallRedFilter> lists = (List<BallRedFilter>) mapper.getRed();
//            for (BallRedFilter ballRedFilter : lists) {
//                List<Integer> result = new ArrayList<Integer>();
//                result.add(ballRedFilter.getRed1());
//                result.add(ballRedFilter.getRed2());
//                result.add(ballRedFilter.getRed3());
//                result.add(ballRedFilter.getRed4());
//                result.add(ballRedFilter.getRed5());
//                result.add(ballRedFilter.getRed6());
//                results.add(result);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            sqlSession.close();
//        }
//        return results;
//    }
    public List<BallRedFilter> getRed() {
        SqlSession sqlSession = null;
        List<BallRedFilter> results = new ArrayList<BallRedFilter>();
        try {
            sqlSession = getSqlSession();
            BallRedFilterMapper mapper = sqlSession.getMapper(BallRedFilterMapper.class);
            results = mapper.getRed();
        } catch (IOException e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
            result = mapper.insertByBatch(datas);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
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
