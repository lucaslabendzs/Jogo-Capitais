package com.example.capitais

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val perguntas = arrayOf(
        "Qual é a capital do Paraná?",
        "Qual é a capital de São Paulo?",
        "Qual é a capital de Santa Catarina?",
        "Qual é a capital do Rio Grande do Sul?",
        "Qual é a capital do Rio de Janeiro?",
        "Qual é a capital de Minas Gerais?",
        "Qual é a capital do Espírito Santo?",
        "Qual é a capital da Bahia?",
        "Qual é a capital de Pernambuco?",
        "Qual é a capital do Ceará?",
        "Qual é a capital do Maranhão?",
        "Qual é a capital do Pará?",
        "Qual é a capital do Amazonas?",
        "Qual é a capital de Goiás?",
        "Qual é a capital de Mato Grosso?",
        "Qual é a capital de Mato Grosso do Sul?",
        "Qual é a capital de Rondônia?",
        "Qual é a capital do Acre?",
        "Qual é a capital de Alagoas?",
        "Qual é a capital da Paraíba?"
    )

    private val respostas = arrayOf(
        "Curitiba",
        "São Paulo",
        "Florianópolis",
        "Porto Alegre",
        "Rio de Janeiro",
        "Belo Horizonte",
        "Vitória",
        "Salvador",
        "Recife",
        "Fortaleza",
        "São Luís",
        "Belém",
        "Manaus",
        "Goiânia",
        "Cuiabá",
        "Campo Grande",
        "Porto Velho",
        "Rio Branco",
        "Maceió",
        "João Pessoa"
    )

    private var sortedNumber: Int = 0
    private var contador: Int = 0
    private var pontuacao: Int = 0

    private val quantidadeDePerguntas: Int = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        val botao = findViewById<Button>(R.id.buttonResp)

        // Carrega a primeira pergunta
        carregarPergunta()

        botao.setOnClickListener {

            val radioGroup = findViewById<RadioGroup>(R.id.rG)

            val opcao = response(radioGroup)

            // Verifica se o usuário selecionou alguma alternativa
            if (opcao == "") {

                Toast.makeText(
                    this,
                    "Selecione uma alternativa!",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            // Verifica a resposta
            if (opcao == respostas[sortedNumber]) {

                Toast.makeText(
                    this,
                    "Você acertou!!!",
                    Toast.LENGTH_SHORT
                ).show()

                pontuacao++

            } else {

                Toast.makeText(
                    this,
                    "Você errou!!!",
                    Toast.LENGTH_SHORT
                ).show()
            }

            // Conta a pergunta respondida
            contador++

            // Verifica se ainda existem perguntas
            if (contador < quantidadeDePerguntas) {

                carregarPergunta()

            } else {

                Toast.makeText(
                    this,
                    "Fim do quiz! Pontuação: $pontuacao/$quantidadeDePerguntas",
                    Toast.LENGTH_LONG
                ).show()

                botao.isEnabled = false
            }
        }
    }

    private fun carregarPergunta() {

        // Sorteia a pergunta
        sortedNumber = (0..19).random()

        // Resposta correta
        val alternativa1 = respostas[sortedNumber]

        // Sorteia uma alternativa diferente da correta
        var numero2 = (0..19).random()

        while (numero2 == sortedNumber) {
            numero2 = (0..19).random()
        }

        val alternativa2 = respostas[numero2]

        // Sorteia outra alternativa diferente
        var numero3 = (0..19).random()

        while (
            numero3 == sortedNumber ||
            numero3 == numero2
        ) {
            numero3 = (0..19).random()
        }

        val alternativa3 = respostas[numero3]

        // Sorteia outra alternativa diferente
        var numero4 = (0..19).random()

        while (
            numero4 == sortedNumber ||
            numero4 == numero2 ||
            numero4 == numero3
        ) {
            numero4 = (0..19).random()
        }

        val alternativa4 = respostas[numero4]

        // Mostra a pergunta
        val input = findViewById<TextView>(R.id.textView)

        input.text = perguntas[sortedNumber]

        // Pega os RadioButtons
        val r1 = findViewById<RadioButton>(R.id.rB1)
        val r2 = findViewById<RadioButton>(R.id.rB2)
        val r3 = findViewById<RadioButton>(R.id.rB3)
        val r4 = findViewById<RadioButton>(R.id.rB4)

        // Sorteia a posição da resposta correta
        val posicaoCorreta = (0..3).random()

        if (posicaoCorreta == 0) {

            r1.text = alternativa1
            r2.text = alternativa2
            r3.text = alternativa3
            r4.text = alternativa4

        } else if (posicaoCorreta == 1) {

            r1.text = alternativa2
            r2.text = alternativa1
            r3.text = alternativa3
            r4.text = alternativa4

        } else if (posicaoCorreta == 2) {

            r1.text = alternativa3
            r2.text = alternativa2
            r3.text = alternativa1
            r4.text = alternativa4

        } else {

            r1.text = alternativa4
            r2.text = alternativa2
            r3.text = alternativa3
            r4.text = alternativa1
        }

        // Limpa a seleção anterior
        val radioGroup = findViewById<RadioGroup>(R.id.rG)

        radioGroup.clearCheck()
    }

    private fun response(radioGroup: RadioGroup): String {

        val idSelecionado = radioGroup.checkedRadioButtonId

        // Nenhum RadioButton selecionado
        if (idSelecionado == -1) {
            return ""
        }

        val radioSelecionado =
            findViewById<RadioButton>(idSelecionado)

        return radioSelecionado.text.toString()
    }
}