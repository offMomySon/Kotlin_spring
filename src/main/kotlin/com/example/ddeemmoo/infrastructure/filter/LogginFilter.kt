package com.example.ddeemmoo.infrastructure.filter

import org.springframework.stereotype.Component
import org.springframework.web.filter.GenericFilterBean
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.util.ContentCachingRequestWrapper
import org.springframework.web.util.ContentCachingResponseWrapper
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

// Filter - 일판 필터
// GenericFilterBean - 필터 + spring 설정 값 저장
// 사용자가 요청이 servlet 객체를 만드는 데 dispatcher 로 인해 서블릿 객체를 만들게 되서 이미 인증된 서블릿 객체의 인증 인가 같은 경우 2벙이 탈 수 있다.

// 필터가 체인으로 인해 여거래의 필터를 탈수도 있다.
// https://stackoverflow.com/questions/13152946/what-is-onceperrequestfilter


// OncecPerRequestFilter  - 위의 상황을 타개하기 위해. 클라이언트 요청 한번에 딱한번의 필터만 타게 하기 위해.

@Component
class LogginFilter : OncePerRequestFilter() {
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {

        // body 의 copy 를 뜨기 위해.
        val contentCachingResponseWrapper = ContentCachingResponseWrapper(response)
        val contentCachingRequestWrapper = ContentCachingRequestWrapper(request)

        println("=====Filter Start=====")

        filterChain.doFilter(request, contentCachingResponseWrapper)

        // body 를 한번쓰면 다른곳에서 쓰지못한다.
        // 그래서 post man 에도 no response 출력.
        println(String(contentCachingResponseWrapper.contentAsByteArray))

        // ES 에 쓰면 , t사용자가 요청 응답을 못받음. - > 이제 가능.
        println("=====Filter End=====")
        contentCachingResponseWrapper.copyBodyToResponse()
    }
    //    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
//        // !! - yelling
//        // chain!!.doFilter()
//        // NULL 아니니까 실행해 달라.
//
//        // ?. 이 safety call
//        // cahin?.
//        // cahin 이 null 이 아닐떄만 호출해달라. - safety call
//        println("=====Filter Start===== ")
//        chain!!.doFilter(request, response)
//        // ES 로깅을 넣어줄 수 있다.
//
//        println("=====Filter End===== ")
//    }
}