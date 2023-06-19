package pe.edu.ulima.dbaccess.services

import pe.edu.ulima.dbaccess.models.beans.Pokemon
import pe.edu.ulima.models.Usuario
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserService {
    @POST("/user/validate")
    fun validate(
        user: String,
        password: String
    ): Call<Usuario>
}