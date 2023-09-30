// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val id: Int, val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableSetOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        this.inscritos.add(usuario)
    }
}

fun main() {
    var usuarios = mutableListOf<Usuario>()
    val nomesUsuarios = listOf("Bruno Dias", "Janaina", "André", "Cleiton", "José")
    for (i in 0..4){
        usuarios.add(Usuario(i, nomesUsuarios[i]))
    }

    var conteudos = mutableListOf<ConteudoEducacional>()
    val nomesConteudos = listOf("Algoritmos", "Banco de dados", "Python", "Kotlin")
    val duracaoConteudos = listOf(30, 40, 60, 60)
    val nivelConteudos = listOf(Nivel.BASICO, Nivel.BASICO, Nivel.INTERMEDIARIO, Nivel.DIFICIL)

    for (i in 0..3){
        conteudos.add(ConteudoEducacional(nomesConteudos[i], duracaoConteudos[i], nivelConteudos[i]))
    }

    val formacao1 = Formacao("Python", listOf(conteudos[0], conteudos[1], conteudos[2]))
    val formacao2 = Formacao("Kotlin", listOf(conteudos[0], conteudos[1], conteudos[3]))

    formacao1.matricular(usuarios[0])
    formacao1.matricular(usuarios[4])
    formacao2.matricular(usuarios[0])
    formacao2.matricular(usuarios[1])
    formacao2.matricular(usuarios[2])
    formacao2.matricular(usuarios[3])


    val formacoes = listOf<Formacao>(formacao1, formacao2)
    for (formacao in formacoes){
        println("Formação: ${formacao.nome}")
        println("Conteúdos: ")
        for (conteudo in formacao.conteudos){
            println("- ${conteudo.nome} - ${conteudo.duracao} minutos - dificuldade: ${conteudo.nivel}")
        }

        println("Inscritos: ")
        for (aluno in formacao.inscritos){
            println("- ${aluno.nome}")
        }
        println("-----------------------------------")

    }
}
