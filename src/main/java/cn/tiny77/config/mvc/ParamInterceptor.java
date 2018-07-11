package cn.tiny77.config.mvc;

import cn.tiny77.constant.SessionKey;
import cn.tiny77.constant.Url;
import cn.tiny77.model.dto.UserDTO;
import cn.tiny77.util.AuthUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // user
        Object user = request.getSession().getAttribute(SessionKey.USER_KEY);
        if(user != null){
            request.setAttribute(SessionKey.USER_KEY, user);
        }
        return true;
    }
}
