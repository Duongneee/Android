package com.example.calculatorconstraintlayout

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
          lateinit var textReuslt: TextView
          var op1 : Int = 0 // số hạng 1
          var op2 : Int = 0 // số hạng 2
          var op : Int = 0 // 1, 2, 3, 4 lần lượt là các phép tính cộng trừ nhân chia
          var state : Int = 1 // đang ở số thứ 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         textReuslt = findViewById(R.id.textViewResult)
        findViewById<Button>(R.id.button0).setOnClickListener(this)
        findViewById<Button>(R.id.button1).setOnClickListener(this)
        findViewById<Button>(R.id.button2).setOnClickListener(this)
        findViewById<Button>(R.id.button3).setOnClickListener(this)
        findViewById<Button>(R.id.button4).setOnClickListener(this)
        findViewById<Button>(R.id.button5).setOnClickListener(this)
        findViewById<Button>(R.id.button6).setOnClickListener(this)
        findViewById<Button>(R.id.button7).setOnClickListener(this)
        findViewById<Button>(R.id.button8).setOnClickListener(this)
        findViewById<Button>(R.id.button9).setOnClickListener(this)
        findViewById<Button>(R.id.buttonC).setOnClickListener(this)
        findViewById<Button>(R.id.buttonBS).setOnClickListener(this)
        findViewById<Button>(R.id.buttonCE).setOnClickListener(this)
        findViewById<Button>(R.id.buttonDot).setOnClickListener(this)
        findViewById<Button>(R.id.buttonPlusorMinimus).setOnClickListener(this)
        findViewById<Button>(R.id.buttonMinus).setOnClickListener(this)
        findViewById<Button>(R.id.buttonPlus).setOnClickListener(this)
        findViewById<Button>(R.id.buttonDivide).setOnClickListener(this)
        findViewById<Button>(R.id.buttonEquals).setOnClickListener(this)
        findViewById<Button>(R.id.buttonMultiply).setOnClickListener(this)

        }

    override fun onClick(p0: View?) {
        val id = p0?.id
        if (id == R.id.button0) {
            addDigit(0)
        } else if (id == R.id.button1) {
            addDigit(1)
        } else if (id == R.id.button2) {
            addDigit(2)
        } else if (id == R.id.button3) {
            addDigit(3)
        } else if (id == R.id.button4) {
            addDigit(4)
        }else if (id == R.id.button5) {
            addDigit(5)
        }else if (id == R.id.button6) {
            addDigit(6)
        }else if (id == R.id.button7) {
            addDigit(7)
        }else if (id == R.id.button8) {
            addDigit(8)
        }else if (id == R.id.button9) {
            addDigit(9)
        } else if(id == R.id.buttonPlus){
            op = 1
            state = 2
        } else if(id == R.id.buttonMinus){
            op = 2
            state = 2
        } else if(id == R.id.buttonMultiply){
            op = 3
            state =2
        } else if(id == R.id.buttonDivide){
            op = 4
            state = 2
        } else if(id == R.id.buttonEquals) {
            var result = 0
            when (op) {
                1 -> result = op1 + op2 // Cộng
                2 -> result = op1 - op2 // Trừ
                3 -> result = op1 * op2 // Nhân
                4 -> {
                    if (op2 != 0) {
                        result = op1 / op2
                    } else {
                        textReuslt.text = "Error"
                            return
                    }
                }
            }
            textReuslt.text = ("$result")
            op1 = result
            op2 = 0
            state = 2
            op = 0
        }else if(id == R.id.buttonC){
            state = 1
            op1 = 0
            op2 = 0
            op = 0
            textReuslt.text = ("0")
        }
        else if(id == R.id.buttonCE){
            if(state == 1){
                op1 = 0
                textReuslt.text = ("0")
            } else {
                op2 = 0
                textReuslt.text = ("0")  }
        }
        else if(id == R.id.buttonBS){
            if(state == 1){
                op1 = op1 /10
                textReuslt.text = if (op1 == 0) "0" else "$op1"
            }else{
                op2 = op2 /10
                textReuslt.text = if (op2 == 0) "0" else "$op2"
            }
        }

    }


    fun addDigit(c: Int) {
        if (state == 1) {
            op1 = op1 * 10 + c
            textReuslt.text = "$op1"
        } else {
            op2 = op2 * 10 + c
            textReuslt.text = "$op2"
        }
    }

}


