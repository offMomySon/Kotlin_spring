package com.example.ddeemmoo.presentation

import com.example.ddeemmoo.application.UserService
import com.example.ddeemmoo.presentation.dto.UserDTO
import com.example.ddeemmoo.presentation.response.UserResponse
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user")
class UserController(
        val  userService: UserService
) {

    // form, json 등등.
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody userDTO: UserDTO){
        userService.create(userDTO.toUser())
    }

    @GetMapping("/{id}")
    fun read(@PathVariable("id") id : Long): UserResponse{
        val user = userService.read(id)
        return UserResponse(user)
    }
}