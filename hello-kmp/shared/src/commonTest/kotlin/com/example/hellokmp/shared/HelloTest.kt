package com.example.hellokmp.shared

import kotlin.test.Test
import kotlin.test.assertEquals

class HelloTest {

    @Test
    fun hello_should_work() {
        assertEquals(hello(), "hello, world")
    }

}