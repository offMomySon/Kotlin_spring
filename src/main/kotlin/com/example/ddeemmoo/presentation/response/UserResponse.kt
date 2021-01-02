package com.example.ddeemmoo.presentation.response

import com.example.ddeemmoo.domain.User
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty


@JsonInclude(JsonInclude.Include.NON_NULL)
class UserResponse(user: User) {

    @JsonProperty("id")
    val id: Long? = user.id

    @JsonProperty("name")
    val name:String = user.name
}