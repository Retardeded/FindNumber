package com.example.findnumber.data

import com.example.findnumber.domain.model.Numbers

data class NumbersDto(
    val numbers: String,
)

fun NumbersDto.toNumbers(): Numbers {
        return Numbers(
            numbers.removeSurrounding(",").split(",").map { number -> number.toInt() }
        )
}