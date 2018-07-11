package cn.tiny77.config.mvc;

import cn.tiny77.constant.SessionKey;
import cn.tiny77.constant.Url;
import cn.tiny77.util.AuthUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean isLogin = request.getAttribute(SessionKey.USER_KEY) != null;
        if (!isLogin) {
            response.sendRedirect(Url.LOGIN);
        }
        return true;
    }
}
