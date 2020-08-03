package com.microservices.chapter3

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include

//@JsonInclude(Include.NON_NULL) //널이 아닌값만 직렬화..스프링전역에 적용하려면 application.yaml 수정
data class Customer(var id: Int = 0, var name: String = "", var telephone: Telephone? = null) {
    data class Telephone(var countryCode: String = "",
    var telephoneNumber: String = "")
}