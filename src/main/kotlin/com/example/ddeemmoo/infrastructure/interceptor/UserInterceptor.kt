package com.example.ddeemmoo.infrastructure.interceptor

import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse



// 특정 path 에만 공통로직을 타게 하기 위해서. // 똑같은 검증을 하기 위해서
@Component
class UserInterceptor: HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        println("=====Interceptor Start=====")
        return true;
    }

    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any, modelAndView: ModelAndView?) {
        println("=====Interceptor End=====")
    }
}