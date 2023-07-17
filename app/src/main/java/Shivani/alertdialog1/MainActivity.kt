package Shivani.alertdialog1

import Shivani.alertdialog1.R.id.btnCheckBoxListAlertDialog
import android.annotation.SuppressLint
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    //variable declaration
    var tvValue0: TextView?=null
    var button: Button?=null
    var number:Int=0
    var btnSimpleListAlertDialog: Button?=null
    var tvSelectedColors: TextView?=null
    var simpleList= arrayOf("black","blue","red","green")
    var btnCheckBoxListAlertDialog:Button?=null
    var booleanArray= booleanArrayOf(false, false, false, false)
    var btnCustomDialog:Button?=null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialization
        tvValue0 = findViewById(R.id.value0)
        button = findViewById(R.id.Button)
        btnSimpleListAlertDialog = findViewById(R.id.btnSimpleListAlertDialog)
        tvSelectedColors= findViewById(R.id.tvSelectedColors)
        btnCheckBoxListAlertDialog=findViewById(R.id.btnCheckBoxListAlertDialog)
        btnCustomDialog=findViewById(R.id.btnCustomDialog)


        button?.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Change number press:")
                .setMessage("Press Yes to increase in me 1,No to decrease -1 ,set->0")
                .setCancelable(false)
                .setPositiveButton("Yes") { _, _ ->
                    number++
                    tvValue0?.text = number.toString()
                }
                .setNegativeButton("No"){_,_->
                    number--
                    tvValue0?.text= number.toString()
                }
                .setNeutralButton("set 0"){_,_->
                    number=0
                    tvValue0?.text= number.toString()
                }
                .show()
        }
        btnSimpleListAlertDialog?.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("This is simple List alert")
               // .setMessage("This is simple list alert message")
                .setItems(simpleList, {_, position->
                    Toast.makeText(this, "Clicked Item ${simpleList[position]}",
                        Toast.LENGTH_SHORT).show()
                })
            .show()

                }
        btnCheckBoxListAlertDialog?.setOnClickListener {
            AlertDialog.Builder(this)
                .setMultiChoiceItems(simpleList, booleanArray, { _, position, isChecked ->
                    Toast.makeText(this, "position $position isChecked $isChecked",
                        Toast.LENGTH_LONG).show()
                    System.out.println("position $position isChecked $isChecked")
                })
                .setPositiveButton("Ok", { _, _ ->
                    var selectedColor = ""
                    for (i in 0..booleanArray.size - 1) {
                        if (booleanArray[i] == true) {
                            selectedColor = selectedColor + simpleList[i] + ""
                        }
                    }
                    tvSelectedColors?.setText(selectedColor)
                })
                .show()
        }
        btnCustomDialog?.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.customdialog)
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
            dialog.show()
            var btnGetName : Button = dialog.findViewById(R.id.btnGetName)
            var etname : EditText = dialog.findViewById(R.id.etName)

            btnGetName.setOnClickListener {
                if(etname.text.toString().isNullOrEmpty()){
                    etname.error="Enter your name"
                }else {
                    btnCustomDialog?.setText(etname.text.toString())
                    dialog.dismiss()
                }


                }


        }
                        }

}







