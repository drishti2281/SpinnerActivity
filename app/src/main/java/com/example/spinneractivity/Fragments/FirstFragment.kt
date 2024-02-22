package com.example.spinneractivity.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.spinneractivity.ArrayModel
import com.example.spinneractivity.MainActivity
import com.example.spinneractivity.R
import com.example.spinneractivity.SpinnerAdapter
import com.example.spinneractivity.databinding.FragmentFirstBinding



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var btnMoveToSecond : Button
    lateinit var binding : FragmentFirstBinding
    var array = arrayListOf<String>("Testing","Testing 1","Testing 2")
    lateinit var arrayAdapter : ArrayAdapter<String>
    lateinit var mainActivity : MainActivity
    var spinnerAdapter = SpinnerAdapter(array)
    private  val TAG = FirstFragment::class.java.canonicalName

    var companyArray = arrayListOf<ArrayModel>(ArrayModel(1, "O7 Services", "Jalandhar"), ArrayModel(2, "O7 Solutions", "Jalandhar"), ArrayModel(2, "O7 Tec", "Hsp"))
    lateinit var companyAdapter : ArrayAdapter<ArrayModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnMoveToSecond = view.findViewById(R.id.btnMoveToSecond)
        btnMoveToSecond.setOnClickListener{
            findNavController().navigate(R.id.secondFragment)
        }
        /* binding.spinner.setOnItemClickListener { adapterView, view, i, l ->

           var selectedItem =  binding.spinner.selectedItem as String
             println("selectedItem $selectedItem")
         }*/

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        arrayAdapter = ArrayAdapter(mainActivity, android.R.layout.simple_list_item_1, array)
        binding.adapterspinner.adapter = arrayAdapter

        binding.userClassSpinner.adapter = spinnerAdapter

        binding.btnGetSpinnerValues.setOnClickListener {
            Log.e(TAG,"binding.userClassSpinner.selectedItem ${binding.userClassSpinner.selectedItem}")
            Log.e(TAG,"binding.userClassSpinner.selectedItemId ${binding.userClassSpinner.selectedItemId}")
        }

        companyAdapter = ArrayAdapter(mainActivity, android.R.layout.simple_list_item_1, companyArray)
        binding.companyspinner.adapter = companyAdapter

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}