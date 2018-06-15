/**
 * @Title  BallRedBaseImpl.java
 * @Package  impl
 * @Description  TODO
 * @author  Andy
 * @date  2018年6月14日 下午4:01:04
 * @version  V1.0
 * @Copyright  2018 http://www.dlmzk.com Inc. All rights reserved.
 */

package impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.BaseDao;
import mapper.BallRedBaseMapper;
import model.BallRedBase;

/**
 * @ClassName BallRedBaseImpl
 * @Description TODO
 */
public class BallRedBaseImpl extends BaseDao {

    public List<BallRedBase> getAll() {
        SqlSession sqlSession = null;
        List<BallRedBase> result = new ArrayList<BallRedBase>();
        try {
            sqlSession = getSqlSession();
            BallRedBaseMapper ballRedBaseMapper = sqlSession.getMapper(BallRedBaseMapper.class);
            result = ballRedBaseMapper.getAll();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return result;
    }
}
