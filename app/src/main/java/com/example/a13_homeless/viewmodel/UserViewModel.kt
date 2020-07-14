package com.example.a13_homeless.viewmodel
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.a13_homeless.api.GithubApiClient
import com.example.a13_homeless.api.dataholder.User
import com.example.a13_homeless.api.dataholder.UserOverView
import com.example.a13_homeless.api.dataholder.UserRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserViewModel :ViewModel() {

    private val _userList = MutableLiveData<List<User>>()
    val userList :LiveData<List<User>>
    get() = _userList

    private val _userOverView = MutableLiveData<UserOverView>()
    val userOverView:LiveData<UserOverView>
    get() = _userOverView

    private val _repoList = MutableLiveData<List<UserRepo>>()
    val repoList :LiveData<List<UserRepo>>
        get() = _repoList

    private val _starredList = MutableLiveData<List<UserRepo>>()
    val starredList :LiveData<List<UserRepo>>
        get() = _starredList

    private val _userData = MutableLiveData<User>()
    val userData:LiveData<User>
        get() = _userData


    fun getUserList(){
        CoroutineScope(Dispatchers.IO).launch {
            val userList = GithubApiClient.api.getUserList()
            _userList.postValue(userList)
        }
    }
    fun getOverView(Name:String){
        CoroutineScope(Dispatchers.IO).launch {
            val overView = GithubApiClient.api.getUserOverView(Name)
            _userOverView.postValue(overView)
        }
    }

    fun getRepoList(Name:String){
        CoroutineScope(Dispatchers.IO).launch {
     val repoList =  GithubApiClient.api.getRepoList(Name)
            _repoList.postValue(repoList)
        }
    }

    fun getStarred(Name:String){
        CoroutineScope(Dispatchers.IO).launch {
           val starred =  GithubApiClient.api.getStarred(Name)
            _starredList.postValue(starred)
        }
    }
    fun userValueToDetail(user:User?) {
        CoroutineScope(Dispatchers.IO).launch {
            _userData.postValue(user)
        }
    }

}