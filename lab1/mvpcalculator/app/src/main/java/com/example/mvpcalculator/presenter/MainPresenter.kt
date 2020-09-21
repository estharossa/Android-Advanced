package com.example.mvpcalculator.presenter

import android.util.Log
import com.example.mvpcalculator.contract.ContractInterface

class MainPresenter(private val _view: ContractInterface.View) : ContractInterface.Presenter {

    companion object {
        private const val plus = "+"
        private const val minus = "-"
        private const val division = "/"
        private const val multiplication = "*"
    }

    override fun calculate(input: String) {
        val sign = getSign(input)
        Log.d("sign", sign)
        Log.d("input", input)
        val numbers = input.split(sign[0])
        Log.d("nums", numbers.toString())
        val firstNumber = numbers[0].toInt()
        val secondNumber = numbers[1].toInt()
        when (sign) {
            plus -> _view.showResult((firstNumber + secondNumber).toString())
            minus -> _view.showResult((firstNumber - secondNumber).toString())
            division -> _view.showResult((firstNumber / secondNumber).toString())
            multiplication -> _view.showResult((firstNumber * secondNumber).toString())
        }
    }

    override fun getSign(input: String): String {
        val signs = listOf(plus, minus, division, multiplication)
        var outputSign = ""
        signs.forEach {
            if (input.contains(it))
                outputSign = it
        }
        return outputSign
    }
}