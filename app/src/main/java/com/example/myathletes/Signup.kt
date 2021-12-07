package com.example.myathletes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.myathletes.database.SignupDatabase
import com.example.myathletes.databinding.CredentialsBinding
import com.example.myathletes.databinding.SignupBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Signup.newInstance] factory method to
 * create an instance of this fragment.
 */
class Signup : Fragment() {
    private lateinit var binding: SignupBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val binding: SignupBinding =
            DataBindingUtil.inflate(inflater, R.layout.signup,container, false)

        val application = requireActivity().application
        val dataSource = SignupDatabase.getInstance(application).signupDao
        val viewModelFactory = SignupViewModelFactory(dataSource, application)
        val signupViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(SignupViewModel::class.java)
        // Connect the IntersectionViewModel with the variable in the layout
        binding.signupViewModel = signupViewModel
        // Assign the lifecycle owner to the activity so it manages the data accordingly.
        binding.lifecycleOwner = this

        binding.back.setOnClickListener(){ view: View ->
            view.findNavController()
                .navigate(R.id.action_signup2_to_credentials)
        }
        return binding.root
    }

}