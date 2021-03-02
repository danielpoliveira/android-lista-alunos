package com.example.agenda.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.agenda.R
import com.example.agenda.dao.AlunoDAO
import com.example.agenda.model.Aluno

class FormularioAlunoActivity : AppCompatActivity() {
    val TITULO_APPBAR = "Novo Aluno"

    private lateinit var campoNome: EditText
    private lateinit var campoTelefone: EditText
    private lateinit var campoEmail: EditText

    private val dao = AlunoDAO()

    private lateinit var aluno: Aluno

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_formulario_aluno)
        title = TITULO_APPBAR
        inicializacaoCampos()
        configuraBotaoSalvar()

        if (intent.hasExtra("aluno")) {
            aluno = intent.getSerializableExtra("aluno") as Aluno

            campoNome.setText(aluno.nome)
            campoTelefone.setText(aluno.telefone)
            campoEmail.setText(aluno.email)
        } else {
            aluno = Aluno()
        }
    }

    private fun inicializacaoCampos() {
        campoNome = findViewById(R.id.activity_formulario_aluno_nome)
        campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone)
        campoEmail = findViewById(R.id.activity_formulario_aluno_email)
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar: Button = findViewById(R.id.activity_formulario_aluno_botao_salvar)
        botaoSalvar.setOnClickListener {

            preencheAluno()

            if (aluno.hasValidId()) {
                dao.edit(aluno)
            } else {
                dao.save(aluno)
            }

            finish()
        }
    }

    private fun preencheAluno() {
        aluno.nome = campoNome.text.toString()
        aluno.telefone = campoTelefone.text.toString()
        aluno.email = campoEmail.text.toString()
    }

}