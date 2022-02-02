package `in`.bitcode.fragments1

import `in`.bitcode.fragments1.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var counterFragmentList = ArrayList<CounterFragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReset.setOnClickListener {
            //code to set the new count to the fragments
            (supportFragmentManager.findFragmentById(R.id.counterFragment1) as CounterFragment)
                .count = binding.edtCount.text.toString().toInt()

            (supportFragmentManager.findFragmentById(R.id.counterFragment2) as CounterFragment)
                .count = binding.edtCount.text.toString().toInt()

        }

        binding.btnAddCounterFragment.setOnClickListener {

            var counterFragment = CounterFragment()
            counterFragmentList.add(counterFragment)

            var fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.mainContainer, counterFragment, "tag")
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        binding.btnRemoveCounterFragment.setOnClickListener {
            if(counterFragmentList.size == 0) {
                return@setOnClickListener
            }
            supportFragmentManager.beginTransaction()
                .remove(counterFragmentList[counterFragmentList.size-1])
                .addToBackStack(null)
                .commit()

            counterFragmentList.removeAt(counterFragmentList.size-1)
        }
    }
}