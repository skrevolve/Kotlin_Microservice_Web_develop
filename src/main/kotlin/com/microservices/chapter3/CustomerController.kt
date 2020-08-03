package com.microservices.chapter3

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class CustomerController {
    @Autowired
    private lateinit var customerService: CustomerService

    @GetMapping(value=["/customer/{id}"])
    fun getCustomer(@PathVariable id: Int): ResponseEntity<Customer?> {
        val customer = customerService.getCustomer(id)
        val status = if(customer == null) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(customer,status)
    }

    @PostMapping(value=["/customer/"])
    fun createCustomer(@RequestBody customer: Customer): ResponseEntity<Unit?> { //이 시나리오에서는 아무것도 출력하지 않아서 Unit으로 처리했다.
        customerService.createCustomer(customer)
        return ResponseEntity<Unit?>(null, HttpStatus.CREATED) //빈객체를 반환하지 않도록 코드 변경
    }

    @DeleteMapping(value=["/customer/{id}"])
    fun deleteCustomer(@PathVariable id: Int): ResponseEntity<Unit> {
        var status = HttpStatus.NOT_FOUND
        if(customerService.getCustomer(id) != null) {
            customerService.deleteCustomer(id)
            status = HttpStatus.OK
        }
        return ResponseEntity(Unit, status)
    }

    @PutMapping(value=["/customer/{id}"])
    fun updateCustomer(@PathVariable id: Int, @RequestBody customer: Customer): ResponseEntity<Unit> {
        var status = HttpStatus.NOT_FOUND
        if(customerService.getCustomer(id) != null) {
            customerService.updateCustomer(id, customer)
            status = HttpStatus.ACCEPTED
        }
        return ResponseEntity(Unit, status)
    }

    @GetMapping(value=["/customers"])
    fun getCustomers(@RequestParam(required = false, defaultValue = "")nameFilter: String)
            = customerService.searchCustomers(nameFilter)
}