package com.liugx.testsystem.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.liugx.testsystem.mapper.NoticeMapper;
import com.liugx.testsystem.mapper.UserMapper;
import com.liugx.testsystem.model.User;
import com.liugx.testsystem.service.NoticeService;

@Service
public class SessionInterceptor implements HandlerInterceptor {
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private UserMapper userMapper;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0)
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    Long id = Long.valueOf(token);
					User user = userMapper.selectByPrimaryKey(id);
                    if (user != null) {
                        HttpSession session = request.getSession();
                        int unreadCount = noticeService.unreadCount(user);
                        session.setAttribute("user", user);
                        session.setAttribute("unreadCount", unreadCount);
                    }
                    return true;
                }
            }
        response.sendRedirect("/");
        return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
