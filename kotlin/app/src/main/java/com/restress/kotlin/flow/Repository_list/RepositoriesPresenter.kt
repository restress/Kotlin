package com.restress.kotlin.flow.Repository_list

import com.restress.kotlin.api.GeneralErrorHandler
import com.restress.kotlin.manaer.ApiManager
import com.restress.kotlin.mvp.BaseMvpPresenterImpl
import rx.functions.Action1

/**
 * Created by win10 on 2017/12/13.
 */
class RepositoriesPresenter :BaseMvpPresenterImpl<RepositoriesContract.View>(),RepositoriesContract.Presenter{

    companion object {
        private val ORGANIZATION_NAME = "Yalantis"
        private val REPOS_TYPE = "public"
    }

    override fun loadRepositories() {
        ApiManager.loadOrganizationRepos(ORGANIZATION_NAME, REPOS_TYPE)
                .doOnError{mView?.showMessage(it.toString())}
                .subscribe(Action1{mView ?.showOrganizations(it)},
                        GeneralErrorHandler(mView,true,{throwable,errorBody,
                                                                     isNetwork -> mView?.showError(throwable.message)}))
    }
}