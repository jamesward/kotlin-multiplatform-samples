package com.example.hellokmp.shared

// implementation shared across all target platforms
fun hello(): String = "hello, world"

// or if you need different platform implementations:
//    remove the previous `fun hello()`
//    uncomment the `expect fun hello()`
//    use the quick-fix "add missing actual declarations"
//    to add the actual definitions for your target platforms
// expect fun hello(): String