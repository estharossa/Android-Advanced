package com.example.mvpcalculator.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mvpcalculator.R
import com.example.mvpcalculator.contract.ContractInterface
import com.example.mvpcalculator.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ContractInterface.View {

    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)

        calculateButton.setOnClickListener {
            Log.d("current", numberEditText.text.toString())
            presenter?.calculate(numberEditText.text.toString())
        }
        plusButton.setOnClickListener {
            val text = numberEditText.text.toString()
            val newText = text + plusButton.text
            numberEditText.setText(newText)
            numberEditText.setSelection(numberEditText.text.length)
        }
        minusButton.setOnClickListener {
            val text = numberEditText.text.toString()
            val newText = text + minusButton.text
            numberEditText.setText(newText)
            numberEditText.setSelection(numberEditText.text.length)
        }
        multiplyButton.setOnClickListener {
            val text = numberEditText.text.toString()
            val newText = text + multiplyButton.text
            numberEditText.setText(newText)
            numberEditText.setSelection(numberEditText.text.length)
        }
        divideButton.setOnClickListener {
            val text = numberEditText.text.toString()
            val newText = text + divideButton.text
            numberEditText.setText(newText)
            numberEditText.setSelection(numberEditText.text.length)
        }
    }

    override fun showResult(output: String) {
        resultTextView.text = output
    }

    override fun clearField() {
        numberEditText.setText("")
    }
}