package com.example.servlet;

import com.alibaba.fastjson.JSON;
import com.example.entities.PO.Log;
import com.example.entities.VO.UserVO;
import com.example.mapper.LogMapper;
import com.example.utils.Action;
import com.example.utils.MybatisUtil;
import com.example.utils.ResultInfo;
import com.example.utils.SnowIdUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author youngoo
 * @date 2021/12/22 15:23
 */
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger logger = Logger.getLogger(this.getClass());
        String uri = req.getRequestURI();
        String methodName = uri.lastIndexOf('?') != -1 ? uri.substring(uri.lastIndexOf('/') + 1, uri.lastIndexOf('?')) : uri.substring(uri.lastIndexOf('/') + 1);
        try {
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // 添加日志操作

            if (!"login".equals(method.getName())) {
                if (method.isAnnotationPresent(Action.class)) {
                    Action annotation = method.getAnnotation(Action.class);

                    String token = req.getHeader("token");
                    UserVO userVO = (UserVO) req.getSession().getAttribute(token);
                    if (userVO != null) {
                        logger.info(userVO.getUserName() + annotation.value());
                        try (SqlSession session = MybatisUtil.getSession()) {
                            LogMapper logMapper = session.getMapper(LogMapper.class);
                            Log log = new Log(SnowIdUtils.uniqueLong(), userVO.getRealName() + "执行" + annotation.value() + "操作", LocalDateTime.now());
                            if (logMapper.insertLog(log) != 0) {
                                session.commit();
                            }
                        } catch (Exception e) {
                            logger.error("数据库操作异常", e);
                        }
                    }
                }


            }

            ResultInfo invoke = (ResultInfo)method.invoke(this, req, resp);
            resp.getWriter().write(JSON.toJSONString(invoke));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            logger.error(e.getMessage(), e);
            resp.getWriter().write(JSON.toJSONString(ResultInfo.err()));
        }
    }
}
