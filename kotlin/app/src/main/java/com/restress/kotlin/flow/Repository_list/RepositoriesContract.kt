package com.restress.kotlin.flow.Repository_list

import com.restress.kotlin.model.Repository
import com.restress.kotlin.mvp.BaseMvpPresenter
import com.restress.kotlin.mvp.BaseMvpView

/**
 * Created by win10 on 2017/12/13.
 */
object RepositoriesContract{

    interface View: BaseMvpView{
        fun showOrganizations(repositories: MutableList<Repository>)
    }

    interface Presenter : BaseMvpPresenter<View>{
        fun loadRepositories()
    }

}