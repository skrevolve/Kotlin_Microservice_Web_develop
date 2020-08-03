package com.microservices.chapter3

import java.util.concurrent.ConcurrentHashMap

class CustomerServiceImpl : CustomerService {
    //데이터베이스를 안쓰고 잇으므로 고객을 포함시켜야한다
    companion object {
        val initialCustomers = arrayOf(Customer(1,"Kotlin"),
        Customer(2,"Spring"),Customer(3,"Microservice"))
    }
    
    val customers = ConcurrentHashMap<Int,Customer>(initialCustomers.associateBy(Customer::id))

    override fun getCustomer(id: Int): Customer? {
        TODO("Not yet implemented")
    }

    override fun createCustomer(customer: Customer) {
        TODO("Not yet implemented")
    }

    override fun deleteCustomer(id: Int) {
        TODO("Not yet implemented")
    }

    override fun updateCustomer(id: Int, customer: Customer) {
        TODO("Not yet implemented")
    }

    override fun searchCustomers(nameFilter: String): List<Customer> {
        TODO("Not yet implemented")
    }
}