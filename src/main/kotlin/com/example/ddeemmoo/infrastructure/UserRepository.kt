package com.example.ddeemmoo.infrastructure

import com.example.ddeemmoo.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>