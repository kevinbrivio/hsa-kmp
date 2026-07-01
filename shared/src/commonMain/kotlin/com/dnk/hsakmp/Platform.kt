package com.dnk.hsakmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform