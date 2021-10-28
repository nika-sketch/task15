package ge.nlatsabidze.datastoreexample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import ge.nlatsabidze.datastoreexample.BaseFragment
import ge.nlatsabidze.datastoreexample.R
import ge.nlatsabidze.datastoreexample.WorkManager
import ge.nlatsabidze.datastoreexample.databinding.FragmentEditProfileBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EditProfileFragment : BaseFragment<FragmentEditProfileBinding>(FragmentEditProfileBinding::inflate) {

    private lateinit var manager: WorkManager
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        manager = WorkManager(requireContext())
        getResultsAndReturnToProfile()
    }

    private fun getResultsAndReturnToProfile() {
        binding.button.setOnClickListener {
            val firstname = binding.firstname.text.toString()
            val lastname = binding.lastname.text.toString()
            val age = binding.age.text.toString()
            val email = binding.email.text.toString()
            val gender = binding.gender.text.toString()
            val address = binding.address.text.toString()
            val phonenumber = binding.phonenumber.text.toString()
            lifecycleScope.launch {
                manager.savetoDataStore(firstname, lastname, age, email, gender, address, phonenumber)
            }
            findNavController().navigate(R.id.action_editProfileFragment_to_profileFragment)
        }
    }
}