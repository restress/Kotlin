package com.restress.kotlin.api

import com.restress.kotlin.model.Repository
import com.restress.kotlin.model.RepositoryDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

/**
 * Created by win10 on 2017/12/12.
 */
//依赖注入ApiSetting，Retrofit,观察者模式
interface GithubService {

    @GET(ApiSettings.ORGANIZATION_REPOS)
    fun getOrganizationRepos(@Path(ApiSettings.PATH_ORGANIZATION) organizationName: String,
                             @Query(ApiSettings.PARAM_REPOS_TYPE) reposType: String): Observable<MutableList<Repository>>

    @GET(ApiSettings.REPOSITORY)
    fun getRepository(@Path(ApiSettings.PATH_OWNER) owner:String,
                      @Path(ApiSettings.PATH_REPO) name:String):Observable<RepositoryDetail>
}