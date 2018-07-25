/**
 * @Title  FilterServlet.java
 * @Package  servlet
 * @Description  TODO
 * @author  Andy
 * @date  2018年7月3日 上午10:46:13
 * @version  V1.0
 * @Copyright  2018 http://www.dlmzk.com Inc. All rights reserved.
 */

package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import impl.BallRedFilterImpl;

/**
 * @ClassName FilterServlet
 * @Description TODO
 * @author Andy
 * @date 2018年7月3日
 */

public class FilterServlet extends HttpServlet {

    private static final long serialVersionUID = 8504248510294309124L;

    private static Logger logger = LoggerFactory.getLogger("lottery");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");

        String initValue = req.getParameter("init");
        String historydate = req.getParameter("historydate");
        String[] bigsmall = req.getParameterValues("bigsmall"); // 大小比
        String[] repeatnumber = req.getParameterValues("repeatnumber");// 重号
        String[] sumvalue = req.getParameterValues("sumvalue");// 和值
        String[] consecutivenumber = req.getParameterValues("consecutivenumber");// 连号
        String[] parityratio = req.getParameterValues("parityratio");// 奇偶比
        String[] primecomposite = req.getParameterValues("primecomposite");// 质合
        String[] jumpnumber = req.getParameterValues("jumpnumber");// 跳号
        String tailNumber1 = req.getParameter("tailNumber1");// 同尾号
        String tailNumber2 = req.getParameter("tailNumber2");// 同尾号

        // 重新初始化：即从基表填充到filter表
        if (initValue != null && initValue.equals("0")) {
            BallRedFilterImpl ballRedFilterImpl = new BallRedFilterImpl();
//
//            // 清空filter表
//            ballRedFilterImpl.delAll();
//
//            // 从基表填充到filter表
//            ballRedFilterImpl.fillFromBase();

            ballRedFilterImpl.postFromBase();
        }

        // BigSmall.filter(bigsmall); //大小比
        // RepeatNumber.filter(repeatnumber, historydate);//重号
        // SumValue.filter(sumvalue);//和值
        // ConsecutiveNumber.filter(consecutivenumber);//连号
        // ParityRatio.filter(parityratio); //奇偶比
        // PrimeComposite.filter(primecomposite); //质合
        // JumpNumber.filter(jumpnumber, historydate); //跳号
        // TailNumber.filter(tailNumber1, tailNumber2); //同尾号

        // String testPage = "test.jsp";
        // resp.sendRedirect(testPage);
        String resultview = "resultview.jsp";
        resp.sendRedirect(resultview);
    }
}
