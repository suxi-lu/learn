package com.learn.core.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/6 0006 12:41
 */
public class WebUtils {

    /**
     * 获取servlet请求对象request
     * @return
     */
    public static ServletRequestAttributes getServletRequest() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    /**
     * 获取请求对象
     * @return
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = getServletRequest();
        return attributes.getRequest();
    }

    /**
     * 获取请求参数值
     * @return
     */
    public static String getRequestParam(String paramName) {
        HttpServletRequest request = getRequest();
        return request.getParameter(paramName);
    }

    /**
     * 获取请求属性值
     * @return
     */
    public static Object getRequestAttribute(String attrName) {
        HttpServletRequest request = getRequest();
        return request.getAttribute(attrName);
    }

    /**
     * 获取响应对象
     * @return
     */
    public static HttpServletResponse getResponse() {
        ServletRequestAttributes attributes = getServletRequest();
        return attributes.getResponse();
    }

    /**
     * 获取会话
     * @return
     */
    public static HttpSession getSession() {
        HttpServletRequest request = getRequest();
        return request.getSession();
    }

    /**
     * 获取会话属性值
     * @return
     */
    public static Object getSessionAttribute(String attrName) {
        HttpSession session = getSession();
        return session.getAttribute(attrName);
    }

    /**
     * 设置会话属性
     * @param object
     */
    public static void setSessionAttribute(String attrName, Object object) {
        if (object == null) return;
        HttpSession session = getSession();
        session.setAttribute(attrName, object);
    }

}
