package `in`.bitcode.fragments1

import `in`.bitcode.fragments1.databinding.CounterFragmentBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class CounterFragment : Fragment() {

    var count = 0
    set(value) {
        if(value >= 0 ) {
            field = value
            binding.txtCount.text = "$count"
        }
    }

    private lateinit var binding : CounterFragmentBinding

    /*private lateinit var txtCount : TextView
    private lateinit var btnPlus : Button
    private lateinit var btnMinus : Button*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = CounterFragmentBinding.inflate(
            inflater,
            container,
            false
        )

        /*var view = inflater.inflate(R.layout.counter_fragment, null)

        txtCount = view.findViewById(R.id.txtCount)
        btnPlus = view.findViewById(R.id.btnPlus)
        btnMinus = view.findViewById(R.id.btnMinus)*/

        binding.btnPlus.setOnClickListener {
            count++
            binding.txtCount.text = "$count"
        }
        binding.btnMinus.setOnClickListener {
            count--
            binding.txtCount.text = "$count"
        }


        //return view
        return binding.root
    }
}