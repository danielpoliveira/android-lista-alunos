package com.example.agenda.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.agenda.R
import com.example.agenda.dao.AlunoDAO
import com.example.agenda.model.Aluno
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaAlunosActivity : AppCompatActivity() {
    val TITULO_APPBAR = "Lista de Alunos"

    val dao: AlunoDAO = AlunoDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_lista_alunos)
        title = TITULO_APPBAR
        
        configuraFabNovoAluno()
    }

    override fun onResume() {
        super.onResume()

        configuraLista()
    }

    private fun configuraFabNovoAluno() {
        val botaoNovoAluno: FloatingActionButton =
                findViewById(R.id.activity_lista_alunos_fab_novo_aluno)

        botaoNovoAluno.setOnClickListener {
            view -> abreFormularioAlunoActivity()
        }
    }

    private fun abreFormularioAlunoActivity() {
        val intent = Intent(
                this@ListaAlunosActivity,
                FormularioAlunoActivity::class.java
        )

        startActivity(intent)
    }

    private fun configuraLista() {
        val listaDeAlunos: ListView = findViewById(R.id.activity_lista_de_alunos_listview)

        val alunos: List<Aluno> = dao.getAll()

        listaDeAlunos.adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                alunos
        )

        listaDeAlunos.setOnItemClickListener {
            parent, view, position, id ->
                val alunoSelected: Aluno = alunos.get(position)

                val intent = Intent(
                        this@ListaAlunosActivity,
                        FormularioAlunoActivity::class.java)

                intent.putExtra("aluno", alunoSelected)

                startActivity(intent)
        }

    }

}