package com.restress.kotlin.flow.Repository_list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.restress.kotlin.R
import com.restress.kotlin.R.id.text_view_title
import com.restress.kotlin.model.Repository
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_repository.*

/**
 * Created by win10 on 2017/12/13.
 */
class RepositoriesAdapter(private val repositories: MutableList<Repository>,
                          val onClick: (Repository) -> Unit)
    :RecyclerView.Adapter<RepositoriesAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindData(repositories[position])
    }

    override fun getItemCount(): Int = repositories.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_repository,parent,false).let{
            ViewHolder(it,onClick)
        }
    }


    class ViewHolder(override val containerView: View, val onClick: (Repository) -> Unit)
        :RecyclerView.ViewHolder(containerView),LayoutContainer{

        fun bindData(repository: Repository){
            with(repository){
                text_view_title.text = name
                text_view_description.text = description
                containerView.setOnClickListener { onClick(this) }
            }
        }
    }

    fun addRepositories(newRepositories: List<Repository>){
        repositories.addAll(newRepositories)
    }
}