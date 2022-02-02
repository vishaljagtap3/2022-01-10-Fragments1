package `in`.bitcode.fragments1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class CounterFragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var txtInfo = TextView(activity)
        txtInfo.setTextSize(50F)
        txtInfo.text = "This is a fragment"
        txtInfo.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        txtInfo.setOnClickListener {
            Toast.makeText(activity, "You clicked me!!", Toast.LENGTH_LONG).show()
        }

        return txtInfo
    }

}



