package com.example.agenda.dao

import com.example.agenda.model.Aluno
import java.util.*

class AlunoDAO {
    companion object {
        private val alunos: MutableList<Aluno> = ArrayList()
        private var countId = 0
    }

    fun save(aluno: Aluno) {
        aluno.id = countId++
        alunos.add(aluno)
    }

    fun edit(aluno: Aluno) {

        var found: Aluno? = null

        for (a in alunos) {
            if (a.id == aluno.id) {
                found = a
            }
        }

        if (found != null) {
            val position: Int = alunos.indexOf(found)
            alunos.set(position, aluno)
        }
    }

    fun getAll(): List<Aluno> {
        return ArrayList(alunos)
    }
}
