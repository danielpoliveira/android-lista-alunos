package com.example.agenda.model

import java.io.Serializable

class Aluno(
        nome: String = "",
        telefone: String = "",
        email: String = "",
) : Serializable {
    var id: Int = 0
    
    var nome: String = nome
    var telefone: String = telefone
    var email: String = email

    override fun toString(): String {
        return nome
    }

    fun hasValidId(): Boolean {
        return id > 0
    }
}
