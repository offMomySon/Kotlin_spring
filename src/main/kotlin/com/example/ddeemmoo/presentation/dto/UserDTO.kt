package com.example.ddeemmoo.presentation.dto

import com.example.ddeemmoo.domain.User
import com.fasterxml.jackson.annotation.JsonProperty


class UserDTO(
        @JsonProperty(value = "name")
        private val name: String
) {
    fun toUser(): User {
        return User(name = name)
    }
}