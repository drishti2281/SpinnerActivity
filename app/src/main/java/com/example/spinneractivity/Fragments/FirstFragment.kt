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

    lateinit var btnMoveToSecond: Button
    lateinit var btnGetSpinnerValues: Button
    lateinit var binding: FragmentFirstBinding
    lateinit var spinnerAdapter: SpinnerAdapter
    //var companyArray: CompanyArray?=null

    lateinit var arrayAdapter: ArrayAdapter<String>
    lateinit var mainActivity: MainActivity
    var array = arrayListOf<String>("O7 Services", "O7 Services", "O7 Technowlege")
    val TAG = FirstFragment::class.java.canonicalName

    var companyArray: ArrayList<ArrayModel>
        get() = arrayListOf<ArrayModel>(
            ArrayModel("O7 Services",),
            ArrayModel("O7 Solution"),
            ArrayModel("O7 Technowlege")
        )
        set(value) = TODO()
    lateinit var companyAdapter: ArrayAdapter<ArrayModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  MainActivity = activity as MainActivity
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
        btnMoveToSecond.setOnClickListener {
            findNavController().navigate(R.id.secondFragment)
        }
        binding.spinner.setOnItemClickListener { adapterView, view, i, l ->

            var selectedItem = binding.spinner.selectedItem as String
            println("selectedItem $selectedItem")
            binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }
            }
            arrayAdapter = ArrayAdapter(mainActivity, android.R.layout.simple_list_item_1, array)
            binding.spinner.adapter = arrayAdapter

            binding.userClassSpinner.adapter = spinnerAdapter

            binding.btnGetSpinnerValues.setOnClickListener {
                Log.e(TAG,"binding.userClassSpinner.selectedItem ${binding.userClassSpinner.selectedItem}")
                Log.e(TAG,"binding.userClassSpinner.selectedItemId ${binding.userClassSpinner.selectedItemId}")
            }

            companyAdapter = ArrayAdapter(mainActivity, android.R.layout.simple_list_item_1, companyArray)
            binding.companyArray.adapter = companyAdapter

        }

    }
}