package com.example.ddeemmoo.presentation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RootController {

    @GetMapping("/")
    fun welcome() :String{
        return "2012_good_luck"
    }
}