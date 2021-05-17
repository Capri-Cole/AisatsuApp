package jp.techacademy.cole.capri.aisatsuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.TimePickerDialog
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        showTimePickerDialog()
    }

    private fun showTimePickerDialog() {
        textView1.text = ""
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                textView1.text = setMessage(hour)
            },
            13, 0, true
        )
        timePickerDialog.show()
    }

    //時刻で設定するメッセージを判定
    //2:00 ~ 9:59では「おはよう」
    //10:00 ~ 17:59では「こんにちは」
    //18:00 ~ 1:59では「こんばんは」
    private fun setMessage(hour: Int):String {
        var message = ""
        when (hour) {
            0, 1 -> message = "こんばんは"
            in 2..9 -> message = "おはよう"
            in 10..17 -> message = "こんにちは"
            in 18..23 -> message = "こんばんは"
        }
        return message
    }
}