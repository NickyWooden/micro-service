package com.ly.cloud.servicezuul.rute;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Component
@Slf4j
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
//        pre：路由之前
//        routing：路由之时
//        post： 路由之后
//        error：发送错误调用
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }else if("888888".equals(accessToken)){
            log.warn("token is right!");
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);


            return "token is right!";
        }else {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is wrong!");
            }catch (Exception e){}

            return null;
        }
    }
}
