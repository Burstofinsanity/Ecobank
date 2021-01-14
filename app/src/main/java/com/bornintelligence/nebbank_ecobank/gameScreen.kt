package com.bornintelligence.nebbank_ecobank

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class gameScreen : AppCompatActivity() {

    private var current_country = "zimbabwe";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)
        hideSystemUI();
        var imageViews = arrayOf(
            findViewById<ImageView>(R.id.al_algeria)
            ,findViewById<ImageView>(R.id.al_angola)
            ,findViewById<ImageView>(R.id.al_angola_smal)
            ,findViewById<ImageView>(R.id.al_morocco)
            ,findViewById<ImageView>(R.id.al_tunisia)
            ,findViewById<ImageView>(R.id.al_libya)
            ,findViewById<ImageView>(R.id.al_benin)
            ,findViewById<ImageView>(R.id.al_botswana)
            ,findViewById<ImageView>(R.id.al_burkina_faso)
            ,findViewById<ImageView>(R.id.al_burundi)
            ,findViewById<ImageView>(R.id.al_cameroon)
            ,findViewById<ImageView>(R.id.al_central_african_republic)
            ,findViewById<ImageView>(R.id.al_chad)
            ,findViewById<ImageView>(R.id.al_democratic_rebpulic_of_congo)
            ,findViewById<ImageView>(R.id.al_djbiouti)
            ,findViewById<ImageView>(R.id.al_egypt)
            ,findViewById<ImageView>(R.id.al_equatorial_guinea)
            ,findViewById<ImageView>(R.id.al_eritrea)
            ,findViewById<ImageView>(R.id.al_ethiopia)
            ,findViewById<ImageView>(R.id.al_gabon)
            ,findViewById<ImageView>(R.id.al_gambia)
            ,findViewById<ImageView>(R.id.al_ghana)
            ,findViewById<ImageView>(R.id.al_guinea)
            ,findViewById<ImageView>(R.id.al_guinea_bissau)
            ,findViewById<ImageView>(R.id.al_ivory_coast)
            ,findViewById<ImageView>(R.id.al_kenya)
            ,findViewById<ImageView>(R.id.al_liberia)
            ,findViewById<ImageView>(R.id.al_madagascar)
            ,findViewById<ImageView>(R.id.al_malawi)
            ,findViewById<ImageView>(R.id.al_mali)
            ,findViewById<ImageView>(R.id.al_mauritania)
            ,findViewById<ImageView>(R.id.al_mozambique)
            ,findViewById<ImageView>(R.id.al_namibia)
            ,findViewById<ImageView>(R.id.al_niger)
            ,findViewById<ImageView>(R.id.al_nigeria)
            ,findViewById<ImageView>(R.id.al_rawanda)
            ,findViewById<ImageView>(R.id.al_rebpulic_of_congo)
            ,findViewById<ImageView>(R.id.al_senegal)
            ,findViewById<ImageView>(R.id.al_sierra_leone)
            ,findViewById<ImageView>(R.id.al_somolia)
            ,findViewById<ImageView>(R.id.al_south_africa)
            ,findViewById<ImageView>(R.id.al_south_sudan)
            ,findViewById<ImageView>(R.id.al_sudan)
            ,findViewById<ImageView>(R.id.al_tanzania)
            ,findViewById<ImageView>(R.id.al_togo)
            ,findViewById<ImageView>(R.id.al_uganda)
            ,findViewById<ImageView>(R.id.al_western_sahara)
            ,findViewById<ImageView>(R.id.al_zambia)
            ,findViewById<ImageView>(R.id.al_zimbabwe)
        );

        var zim = findViewById<TextView>(R.id.txt_zimbabwe);
        zim.setTextColor(resources.getColor(R.color.colorPrimary));
        var zimbabwe = findViewById<ImageView>(R.id.al_zimbabwe);
        zimbabwe.bringToFront();

        for(view: ImageView in imageViews){
            view.setOnClickListener(View.OnClickListener {
                var Desciption = view.contentDescription.toString()
                if(!Desciption.equals(current_country)){
                    var name = "ic_"+Desciption+"_incorrect";
                    var idf = resources.getIdentifier(name,"drawable",packageName);
                    view.setImageDrawable(getDrawable(idf));
                    Toast.makeText(this, Desciption, Toast.LENGTH_SHORT).show()
                }
                else
                {

                    var name = "ic_"+Desciption+"_correct";
                    var idf = resources.getIdentifier(name,"drawable",packageName);
                    view.setImageDrawable(getDrawable(idf));
                    when(current_country){
                        "zimbabwe"->{
                            current_country = "malawi";
                            var old = findViewById<TextView>(R.id.txt_zimbabwe);
                            old.setTextColor(resources.getColor(R.color.colorFade));
                            var cont = findViewById<TextView>(R.id.txt_MALAWI);
                            cont.setTextColor(resources.getColor(R.color.colorPrimary));
                            var malawi = findViewById<ImageView>(R.id.al_malawi);
                            malawi.bringToFront();
                        }
                        "malawi"->{
                            current_country = "ghana";
                            var old = findViewById<TextView>(R.id.txt_MALAWI);
                            old.setTextColor(resources.getColor(R.color.colorFade));
                            var cont = findViewById<TextView>(R.id.txt_GHANA);
                            cont.setTextColor(resources.getColor(R.color.colorPrimary));
                            var ghana = findViewById<ImageView>(R.id.al_ghana);
                            ghana.bringToFront();
                        }
                        "ghana"->{
                            current_country = "nigeria";
                            var old = findViewById<TextView>(R.id.txt_GHANA);
                            old.setTextColor(resources.getColor(R.color.colorFade));
                            var cont = findViewById<TextView>(R.id.txt_NIGERIA);
                            cont.setTextColor(resources.getColor(R.color.colorPrimary));
                            var nigeria = findViewById<ImageView>(R.id.al_nigeria);
                            nigeria.bringToFront();
                        }
                        "nigeria"->{
                            current_country = "zambia";
                            var old = findViewById<TextView>(R.id.txt_NIGERIA);
                            old.setTextColor(resources.getColor(R.color.colorFade));
                            var cont = findViewById<TextView>(R.id.txt_ZAMBIA);
                            cont.setTextColor(resources.getColor(R.color.colorPrimary));
                            var zambia = findViewById<ImageView>(R.id.al_zambia);
                            zambia.bringToFront();
                        }
                        "zambia"->{
                            current_country = "zimbabwe";
                            var old = findViewById<TextView>(R.id.txt_ZAMBIA);
                            old.setTextColor(resources.getColor(R.color.colorFade));
                            var cont = findViewById<TextView>(R.id.txt_zimbabwe);
                            cont.setTextColor(resources.getColor(R.color.colorPrimary));
                            //var zimbabwe = findViewById<ImageView>(R.id.al_zimbabwe);
                            //zimbabwe.bringToFront();

                            val intent = Intent(this,questionaire::class.java)
                            startActivity(intent)

                        }
                    }
                }
            })
        }
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
