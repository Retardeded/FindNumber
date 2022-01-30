package com.example.findnumber.presentation.detail_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.findnumber.data.NumbersDto
import com.example.findnumber.data.toNumbers


class DetailViewModel(
    numbersDto:String
) : ViewModel() {

    private var _state = mutableStateOf(1)
    val state: State<Int> = _state

    init {

        val numbers = NumbersDto(numbers = numbersDto).toNumbers()

        var even = 0
        var evenNum = 0
        var odd = 0
        var oddNum = 0

        for (number in numbers.numbers) {
                if(number % 2 == 0) {
                    evenNum = number
                    even++
                } else {
                    oddNum = number
                    odd++
                }
            }

        _state.value = if(even > odd)
            oddNum
        else
            evenNum
    }
}