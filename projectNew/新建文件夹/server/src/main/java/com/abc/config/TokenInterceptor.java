package com.abc.config;

import com.abc.entity.SysUser;
import com.abc.util.JWT;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class TokenInterceptor implements HandlerInterceptor {

    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception arg3)
            throws Exception {
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView model) throws Exception {
    }

    //拦截每个请求
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("拦截器启动");
        response.setCharacterEncoding("utf-8");
        HttpServletRequest re = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String token = re.getHeader("biu-token");
        System.out.println(token+"token");
        ResponseData responseData = ResponseData.ok();
        //token存在
        if(null != token) {
            SysUser user = JWT.unsign(token, SysUser.class);
            Subject subject = SecurityUtils.getSubject();
            SysUser u = (SysUser) subject.getPrincipal();
            String uId = u.getUid();
            String userId= user.getUid();
            if( null != user&& u != null&& uId.equals(userId)) {
                return true;
            }
            else
            {
                responseData = ResponseData.forbidden();
                responseMessage(response, response.getWriter(), responseData);
                return false;
            }
        }
        else
        {
            responseData = ResponseData.forbidden();
            responseMessage(response, response.getWriter(), responseData);
            return false;
        }
    }

    //请求不通过，返回错误信息给客户端
    private void responseMessage(HttpServletResponse response, PrintWriter out, ResponseData responseData) {
        responseData = ResponseData.forbidden();
        response.setContentType("application/json; charset=utf-8");
        String json = JSONObject.toJSONString(responseData);
        out.print(json);
        out.flush();
    }


}
