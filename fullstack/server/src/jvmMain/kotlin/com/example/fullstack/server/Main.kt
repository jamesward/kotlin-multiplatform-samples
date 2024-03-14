package com.example.fullstack.server

import com.example.fullstack.shared.*

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun main() {
    val server = embeddedServer(CIO, port = 8080) {
        routing {
            get("/taxrate") {
                val taxRegion = TaxRegion(call.request.queryString())
                val taxRate = TaxCalculator.taxRate(taxRegion)
                call.respondText(taxRate.toString())
            }
        }
    }

    server.start(wait = true)
}
