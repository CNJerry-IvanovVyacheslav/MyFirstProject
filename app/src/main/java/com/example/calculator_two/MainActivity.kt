package com.example.calculator_two

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.calculator_two.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btn0.setOnClickListener {setTexFields("0") }
        binding.btn1.setOnClickListener {setTexFields("1") }
        binding.btn2.setOnClickListener {setTexFields("2") }
        binding.btn3.setOnClickListener {setTexFields("3") }
        binding.btn4.setOnClickListener {setTexFields("4") }
        binding.btn5.setOnClickListener {setTexFields("5") }
        binding.btn6.setOnClickListener {setTexFields("6") }
        binding.btn7.setOnClickListener {setTexFields("7") }
        binding.btn8.setOnClickListener {setTexFields("8") }
        binding.btn9.setOnClickListener {setTexFields("9") }
        binding.btnMns.setOnClickListener {setTexFields("-") }
        binding.btnPls.setOnClickListener {setTexFields("+") }
        binding.btnSlh.setOnClickListener {setTexFields("/") }
        binding.btnMltp.setOnClickListener {setTexFields("*") }
        binding.btnPrtho.setOnClickListener {setTexFields("(") }
        binding.btnPrthc.setOnClickListener {setTexFields(")") }

        binding.btnAc.setOnClickListener {
            binding.mathOperation.text = ""
            binding.resultText.text = ""
        }

        binding.btnDel.setOnClickListener {
            val str = binding.mathOperation.text.toString()
            if(str.isNotEmpty())
                binding.mathOperation.text = str.substring(0, str.length - 1)

            binding.resultText.text = ""
        }
        binding.btnEql.setOnClickListener {
            try {

                val ex = ExpressionBuilder(binding.mathOperation.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if(result == longRes.toDouble())
                    binding.resultText.text = longRes.toString()
                else
                    binding.resultText.text = result.toString()

            } catch (e:Exception) {
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }

    }

    fun setTexFields(str: String) {
        if (binding.resultText.text != "") {
            binding.mathOperation.text = binding.resultText.text
            binding.resultText.text = ""
        }
        binding.mathOperation.append(str)
    }
}