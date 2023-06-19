package pe.edu.ulima.ui.login.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.regex.Matcher
import java.util.regex.Pattern

class CreateUserViewModel : ViewModel() {

    private val _usuario = MutableLiveData<String>("")
    var usuario: LiveData<String> = _usuario
    fun updateUsuario(it: String) {
        _usuario.postValue(it)
    }

    private val _contrasenia = MutableLiveData<String>("")
    var contrasenia: LiveData<String> = _contrasenia
    fun updateContrasenia(it: String) {
        _contrasenia.postValue(it)
    }

    private val _correo = MutableLiveData<String>("")
    var correo: LiveData<String> = _correo
    fun updateCorreo(it: String) {
        _correo.postValue(it)
    }

    private val _mensaje = MutableLiveData<String>("")
    var mensaje: LiveData<String> = _mensaje
    fun updateMensaje(it: String) {
        _mensaje.postValue(it)
    }

    fun reset() {
        val pattern: Pattern = Pattern.compile(".+@.+\\.[a-z]+")

        val email = correo.value
        val matcherEmail: Matcher = pattern.matcher(email)
        val matchFoundEmail: Boolean = matcherEmail.matches()

        if (matchFoundEmail) {
            updateMensaje("Usuario Registrado Correctamente")
        } else {
            updateMensaje("Error")
        }
    }
}