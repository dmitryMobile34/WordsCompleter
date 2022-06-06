package com.nike.wordstest

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.flexbox.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: RVAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flexLayoutManager = FlexboxLayoutManager(this).apply {
            justifyContent = JustifyContent.CENTER
            alignItems = AlignItems.CENTER
            flexDirection = FlexDirection.ROW
            flexWrap = FlexWrap.WRAP
        }

        val flexLayoutManagerLast = FlexboxLayoutManager(this).apply {
            justifyContent = JustifyContent.CENTER
            alignItems = AlignItems.CENTER
            flexDirection = FlexDirection.ROW
            flexWrap = FlexWrap.WRAP
        }
        recyclerView.layoutManager = flexLayoutManager
        recyclerViewLast.layoutManager = flexLayoutManagerLast

        val letterArray = ArrayList<String>()
        val letterArrayLast = ArrayList<String>()

        rezButton.setOnClickListener {
            for (i in editText.text.toString().indices) {
                letterArray.add(editText.text.toString()[i].toString())
                recyclerView.adapter = RVAdapter(this@MainActivity, letterArray, letterArrayLast)
            }
            Log.d("devx", letterArray.toString())
            rezButton.isEnabled = false
        }

        recreateButton.setOnClickListener {
            editText.text.clear()
            recreate()
        }



//        editText.addTextChangedListener(object: TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
////                TODO("Not yet implemented")
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//
//                word = editText.text.toString()
//
//
//
//
//                recyclerView.adapter = RVAdapter(this@MainActivity, word)
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
////                TODO("Not yet implemented")
//            }
//
//        })





//        adapter.notifyDataSetChanged()




    }



}