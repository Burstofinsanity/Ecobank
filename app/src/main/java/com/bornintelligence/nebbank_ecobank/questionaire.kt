package com.bornintelligence.nebbank_ecobank

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import org.w3c.dom.Text
import java.util.*
import kotlin.concurrent.schedule

class questionaire : AppCompatActivity() {


    private var questions = arrayOf("If you were to send R500 home using the Nedbank cross boarder  transfer,\n How much do you think it will cost for the transaction?")
    private var answers = arrayOf(arrayOf("R50","R17.50","R20"),arrayOf("R17.50","R50","R20"),arrayOf("R50","R20","R17.50"));
    private var correct = arrayOf("R17.50","R17.50","R17.50")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questionaire)
        hideSystemUI();
        val len = questions.size - 1;

        val ran = (0..len).random()
        var qts = findViewById<TextView>(R.id.question)
        qts.setText(questions[ran])
        var answer = answers[ran];

        var a1 = findViewById<TextView>(R.id.answer_01)
        var a2 = findViewById<TextView>(R.id.answer_02)
        var a3 = findViewById<TextView>(R.id.answer_03)
        a1.setText(answer[0]);
        a2.setText(answer[1]);
        a3.setText(answer[2]);
        a1.setOnClickListener(View.OnClickListener {
            if(a1.text.equals(correct[ran]))
            {
                a1.setBackgroundResource(R.mipmap.correct_question)
                findViewById<TextView>(R.id.txtCorrect).text = "CORRECT!"

                Timer("SettingUp", false).schedule(500) {
                    goToMap()
                }
            }
            else
            {
                a1.setBackgroundResource(R.drawable.ic_incorrect_question)
                findViewById<TextView>(R.id.txtCorrect).text = "OOOPSY!"
            }
        })
        a2.setOnClickListener(View.OnClickListener {
            if(a2.text.equals(correct[ran]))
            {
                a2.setBackgroundResource(R.mipmap.correct_question)
                findViewById<TextView>(R.id.txtCorrect).text = "CORRECT!"
                Timer("SettingUp", false).schedule(500) {
                    goToMap()
                }
            }
            else
            {
                a2.setBackgroundResource(R.drawable.ic_incorrect_question)
                findViewById<TextView>(R.id.txtCorrect).text = "OOOPSY!"
            }
        })
        a3.setOnClickListener(View.OnClickListener {
            if(a3.text.equals(correct[ran]))
            {
                a3.setBackgroundResource(R.mipmap.correct_question)
                findViewById<TextView>(R.id.txtCorrect).text = "CORRECT!"
                Timer("SettingUp", false).schedule(500) {
                    goToMap()
                }
            }
            else
            {
                a3.setBackgroundResource(R.drawable.ic_incorrect_question)
                findViewById<TextView>(R.id.txtCorrect).text = "OOOPSY!"
            }
        })

    }

    private fun goToMap(){

        val intent = Intent(this,map::class.java)
        startActivity(intent)
    }

    private fun hideSystemUI() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }
}
