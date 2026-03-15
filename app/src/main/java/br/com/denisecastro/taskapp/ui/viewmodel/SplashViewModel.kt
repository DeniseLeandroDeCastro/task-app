package br.com.denisecastro.taskapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel: ViewModel() {

    private val _navigateToLogin = MutableLiveData<Unit>()
    val navigateToLogin: LiveData<Unit> get() = _navigateToLogin

    init {
        checkAuth()
    }
    private fun checkAuth() {
        viewModelScope.launch {
            delay(3000)
            _navigateToLogin.value = Unit
        }
    }
}