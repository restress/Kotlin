package com.restress.kotlin.flow.Repository_list

import android.content.ClipData.newIntent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.restress.kotlin.R
import com.restress.kotlin.R.id.fab
import com.restress.kotlin.model.Repository
import com.restress.kotlin.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_organization.*
import kotlinx.android.synthetic.main.activity_repository.*

/**
 * Created by win10 on 2017/12/13.
 */
class RepositoriesListActivity : BaseMvpActivity<RepositoriesContract.View,
        RepositoriesPresenter>(),
        RepositoriesContract.View{

    private var mAdapter:RepositoriesAdapter? = null
    override var mPresenter: RepositoriesPresenter = RepositoriesPresenter()

    override fun showOrganizations(repositories: MutableList<Repository>) {
        mAdapter?.addRepositories(repositories)
        mAdapter?.notifyDataSetChanged()
        hideProgress()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organization)
        setUpRecyclerView()
        mPresenter.loadRepositories()

        tool_bar.title = getString(R.string.title_activity_repositories)
        showProgress()
        fab.setOnClickListener(){
            showProgress()
            mPresenter.loadRepositories()
        }
    }

    private fun setUpRecyclerView(){
        mAdapter = RepositoriesAdapter(ArrayList<Repository>(),{4
                //TODO 这个需要后续的修改啊
           /* startActivitiy(RepositoryDetailActivity,newIntent(this,it.name))*/
        })
        recyclerViewRepository.layoutManager = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false)
        recyclerViewRepository.adapter = mAdapter
    }

    private fun showProgress(){
        recyclerViewRepository.visibility = View.GONE
        progress_bar.visibility = View.VISIBLE
        fab.isEnabled = false
    }

    private fun hideProgress(){
        recyclerViewRepository.visibility  =View.VISIBLE
        progress_bar.visibility = View.GONE
        fab.isEnabled = true
    }

    override fun showError(error: String?) {
        super.showError(error)
        progress_bar.visibility = View.GONE
        fab.isEnabled = true
    }

}