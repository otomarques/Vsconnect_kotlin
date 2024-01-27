package com.senai.vsconnect_kotlin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.senai.vsconnect_kotlin.R
import com.senai.vsconnect_kotlin.models.Servico

class ListaServicoAdaper (
    private  val context: Context,
    private val listaServico: List <Servico>
): RecyclerView.Adapter<ListaServicoAdaper.ViewHolder>()
{
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun vincularDadosNoItem(servico: Servico){
            val tituloServico = itemView.findViewById<TextView>(R.id.nomeServico)
            tituloServico.text = servico.titulo

            val propostaServico = itemView.findViewById<TextView>(R.id.valorServico)

            propostaServico.text = servico.proposta

            val descricaoServico = itemView.findViewById<TextView>(R.id.descricaoServico)

            descricaoServico.text = servico.descricao
        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaServicoAdaper.ViewHolder {
        val inflater = LayoutInflater.from(context)

        val view = inflater.inflate(R.layout.fragment_servico, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListaServicoAdaper.ViewHolder, position: Int) {
        val itemServico = listaServico[position]
        holder.vincularDadosNoItem(itemServico)
    }

    override fun getItemCount(): Int {

        return  listaServico.size

    }

}