package com.example.ep7exemplo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.ep7exemplo.R
import com.example.ep7exemplo.viewModels.CadastroViewModel
import kotlinx.android.synthetic.main.fragment_nascimento_form.*


class NascimentoFormFragment : Fragment() {

    private lateinit var cadastroViewModel: CadastroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nascimento_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            cadastroViewModel = ViewModelProviders.of(it).get(CadastroViewModel::class.java)
        }

        btNascAvancar.setOnClickListener{
            val data_nascimento = edtTxtDataNasc.text.toString()
            cadastroViewModel.nascimento = data_nascimento

            findNavController().navigate(R.id.local_dest)
        }
    }

}
