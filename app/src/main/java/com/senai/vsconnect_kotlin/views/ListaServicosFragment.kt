package com.senai.vsconnect_kotlin.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.senai.vsconnect_kotlin.adapters.ListaServicoAdaper
import com.senai.vsconnect_kotlin.apis.EndpointInterface
import com.senai.vsconnect_kotlin.apis.RetrofitConfig
import com.senai.vsconnect_kotlin.databinding.FragmentListaServicosBinding
import com.senai.vsconnect_kotlin.models.Servico
import retrofit2.Call

import retrofit2.Callback
import retrofit2.Response

class ListaServicosFragment : Fragment() {

    private val clienteRetrofit = RetrofitConfig.obterInstanciaRetrofit()

    private val endpoint  =clienteRetrofit.create(EndpointInterface::class.java)

    private var _binding: FragmentListaServicosBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListaServicosBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.recyclerServicos.layoutManager = LinearLayoutManager(requireContext())

        endpoint.listarServicos().enqueue(object : Callback<List<Servico>>{
            override fun onResponse(call: Call<List<Servico>>, response: Response<List<Servico>>) {
             // println(response.body())//
                val servico = response.body()

                binding.recyclerServicos.adapter = servico?.let{ListaServicoAdaper(requireContext()
                , it)

                }

            }

            override fun onFailure(call: Call<List<Servico>>, t: Throwable) {
                println("Falha na requisiçao:  ${t.message}")
            }


        } )

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}