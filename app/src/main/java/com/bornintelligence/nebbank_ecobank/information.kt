package com.bornintelligence.nebbank_ecobank

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestoreSettings

class information : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)
        hideSystemUI()
        val but = findViewById<Button>(R.id.submit)
        but.setOnClickListener(View.OnClickListener { submitData() })

    }


    private fun hideSystemUI() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    private fun submitData(){
        //Get Name
        val in_name = findViewById<EditText>(R.id.et_name)
        val txt_name = in_name.text.toString();
        if(txt_name.length < 3){
            Toast.makeText(this, "Name is to Short", Toast.LENGTH_SHORT).show()
            return
        }

        //Get Surname
        val in_surname = findViewById<EditText>(R.id.et_surname)
        val txt_surname = in_surname.text.toString();

        //Get Email
        val in_mail = findViewById<EditText>(R.id.et_mail)
        val txt_mail = in_mail.text.toString();
        //Check if Email is long enough
        if(txt_mail.length < 5){
            Toast.makeText(this, "Email is to Short", Toast.LENGTH_SHORT).show()
            return
        }
        //Check if Email is Valid
        if( !isValidEmail(txt_mail)){
            Toast.makeText(this, "Email is invalid", Toast.LENGTH_SHORT).show()
            return
        }

        //Get cellphone
        val in_cell = findViewById<EditText>(R.id.et_cell)
        val txt_cell = in_cell.text.toString();

        //Check if Cellphone is long enough
        if(txt_cell.length < 10){
            Toast.makeText(this, "Cell is to Short", Toast.LENGTH_SHORT).show()
            return
        }


        //Get Origin
        val in_origin = findViewById<EditText>(R.id.et_origin)
        val txt_origin = in_origin.text.toString();

        //Get Branch
        val in_branch = findViewById<EditText>(R.id.et_branch)
        val txt_branch = in_branch.text.toString();

        //Get Marketing
        val in_marketing = findViewById<RadioGroup>(R.id.marketing)
        val selected = in_marketing.checkedRadioButtonId;
        val val_selected = findViewById<RadioButton>(selected);
        val txt_marketing = val_selected.text.toString();

        //Get Account
        val in_account = findViewById<RadioGroup>(R.id.account)
        val acc_selected = in_account.checkedRadioButtonId;
        val val_acc_selected = findViewById<RadioButton>(acc_selected);
        val txt_account = val_acc_selected.text.toString();
        //Get TOC Agreement
        val in_agree = findViewById<CheckBox>(R.id.ch_agree)
        //Execute is agreed
            if(in_agree.isChecked){
                val db = FirebaseFirestore.getInstance()

                val settings = FirebaseFirestoreSettings.Builder()
                    .setPersistenceEnabled(true)
                    .build()
                db.firestoreSettings = settings
                val user = HashMap<String,Any>()
                user.put("name", txt_name)
                user.put("surname", txt_surname)
                user.put("email", txt_mail)
                user.put("cell", txt_cell)
                user.put("origin", txt_origin)
                user.put("branch", txt_branch)
                user.put("marketing", txt_marketing)
                user.put("hasAccount", txt_account)
                val tsLong = System.currentTimeMillis() / 1000
                val ts = tsLong.toString()
                user.put("timestamp", ts)
                val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
                val currentDate = sdf.format(Date())
                user.put("date", currentDate.toString())

    // Add a new document with a generated ID
                val addOnFailureListener = db.collection("Entries")
                    .add(user as Map<String, Any>)
                    .addOnSuccessListener(OnSuccessListener<DocumentReference> { documentReference ->
                        Log.d(
                            "Information",
                            "DocumentSnapshot added with ID: " + documentReference.id
                        )
                    })
                    .addOnFailureListener(OnFailureListener { e ->
                        Log.w(
                            "Information",
                            "Error adding document",
                            e
                        )
                    })

                val intent = Intent(this, gameScreen::class.java)
                startActivity(intent)


        }
        else
        {

            Toast.makeText(this, R.string.disagree, Toast.LENGTH_SHORT).show()
        }


    }


    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
