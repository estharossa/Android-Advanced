package com.example.mvpcalculator.contract

interface ContractInterface {

    interface View {
        fun showResult(output: String)
        fun clearField()
    }

    interface Presenter {
        fun calculate(input: String)
        fun getSign(input: String) : String
    }

    interface Model {

    }
}