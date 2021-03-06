package com.andreamw96.imageviewapplication.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

object EditTextUtils {
    fun EditText.afterTextChanged(doAfterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                doAfterTextChanged(s.toString())
            }
        })
    }
}