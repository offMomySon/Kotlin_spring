package com.example.ddeemmoo.application

import com.example.ddeemmoo.domain.User
import com.example.ddeemmoo.infrastructure.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
        val userRepository: UserRepository
) {
    @Transactional
    fun create(user: User){
        userRepository.save(user)
    }

    @Transactional(readOnly = true)

    fun read(id: Long):User{
        // ?:  -  엘비스 연산자.
        // 앞에 있는 fun 이 nullable 타입이 null 이면 뒷쪽을 실행해라.
        // exception 처리안함.
        // Throws(Exception::class) -> 명시적으로 할때.
        return userRepository.findByIdOrNull(id) ?: throw Exception()
    }
}