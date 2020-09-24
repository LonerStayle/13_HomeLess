package com.example.a13_homeless.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.a13_homeless.api.api.GithubApiClient
import com.example.a13_homeless.api.dataholder.User
import com.example.a13_homeless.api.dataholder.UserOverView
import com.example.a13_homeless.api.dataholder.UserRepo
import com.example.a13_homeless.api.repository.GithubRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserViewModel (private val githubRepository: GithubRepository) :ViewModel() {

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
            val userList = githubRepository.getUserList()
            _userList.postValue(userList)
        }
    }
    fun getOverView(name:String?){
        CoroutineScope(Dispatchers.Main).launch {
            val overView = githubRepository.getUserOverView(name)
            _userOverView.postValue(overView)
        }
    }

    fun getRepoList(name:String?){
        CoroutineScope(Dispatchers.Main).launch {
     val repoList =  githubRepository.getRepoList(name)
            _repoList.postValue(repoList)
        }
    }

    fun getStarred(name:String?){
        CoroutineScope(Dispatchers.Main).launch {
           val starred =  githubRepository.getStarred(name)
            _starredList.postValue(starred)
        }
    }
    fun userValueToDetail(user:User?) {
            _userData.postValue(user)
    }

}