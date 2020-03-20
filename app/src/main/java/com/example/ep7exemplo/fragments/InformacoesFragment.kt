package com.example.ep7exemplo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.ep7exemplo.R
import com.example.ep7exemplo.viewModels.CadastroViewModel
import kotlinx.android.synthetic.main.fragment_informacoes.*


/**
 * A simple [Fragment] subclass.
 */
class InformacoesFragment : Fragment() {

    private lateinit var cadastroViewModel: CadastroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_informacoes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            cadastroViewModel = ViewModelProviders.of(it).get(CadastroViewModel::class.java)
        }
        cadastroViewModel.idade.observe(viewLifecycleOwner, Observer {
            txtInformacao.text = it
        })


    }
}
