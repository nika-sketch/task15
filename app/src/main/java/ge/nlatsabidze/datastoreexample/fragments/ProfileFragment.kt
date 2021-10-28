package ge.nlatsabidze.datastoreexample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ge.nlatsabidze.datastoreexample.BaseFragment
import ge.nlatsabidze.datastoreexample.R
import ge.nlatsabidze.datastoreexample.WorkManager
import ge.nlatsabidze.datastoreexample.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    private lateinit var manager: WorkManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btneditProfile.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_editProfileFragment)
        }
        setResult()
    }

    private fun setResult() {
        manager = WorkManager(requireContext())

        manager.firstName.observe(viewLifecycleOwner, {
            binding.firstName.text = it.toString()
        })
        manager.lastName.observe(viewLifecycleOwner, {
            binding.lastName.text = it.toString()
        })
        manager.age.observe(viewLifecycleOwner, {
            binding.Age.text = it.toString()
        })
        manager.email.observe(viewLifecycleOwner, {
            binding.Email.text = it.toString()
        })
        manager.gender.observe(viewLifecycleOwner, {
            binding.Gender.text = it.toString()
        })
        manager.address.observe(viewLifecycleOwner, {
            binding.Address.text = it.toString()
        })
        manager.phoneNumber.observe(viewLifecycleOwner, {
            binding.PhoneNumber.text = it.toString()
        })

    }
}