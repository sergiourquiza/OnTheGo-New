package pe.edu.ulima.ui.login.viewmodels

import android.content.Context
import android.content.Intent
import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.ulima.dbaccess.activities.LoginActivity
import pe.edu.ulima.dbaccess.configs.BackendClient
import pe.edu.ulima.dbaccess.services.UserService

class LoginViewModel: ViewModel() {
    private val _usuario = MutableLiveData<String>("")
    var usuario: LiveData<String> = _usuario
    fun updateUsuario(it: String){
        _usuario.postValue(it)
    }

    private val _contrasenia = MutableLiveData<String>("")
    var contrasenia: LiveData<String> = _contrasenia
    fun updateContrasenia(it: String){
        _contrasenia.postValue(it)
    }

    private val _mensaje = MutableLiveData<String>("")
    var mensaje: LiveData<String> = _mensaje
    fun updateMensaje(it: String){
        _mensaje.postValue(it)
    }

    fun validar(context: Context){
        val apiService = BackendClient.buildService(UserService::class.java)
        val response = apiService.validate(_usuario.value!!, _contrasenia.value!!).execute()
        val id: Int? = response.body()?.id
        if(id == 0){
            updateMensaje("Error: Usuario y contraseña no válidos")
        }else{
            updateMensaje("Todo OK")
            Handler().postDelayed({
                updateMensaje("")
                val appActivity =  Intent(context, LoginActivity::class.java)
                appActivity.putExtra("user_id", id)
                context.startActivity(
                    appActivity
                )
            }, 2000)
        }
    }
}
