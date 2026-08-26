# Jogo das Capitais

Um aplicativo Android interativo focado no aprendizado e teste de conhecimentos sobre capitais. 

## 🛠 Tecnologias Utilizadas

Este projeto foi desenvolvido utilizando as seguintes tecnologias e ferramentas:
* **Plataforma:** Android
* **Linguagem:** Kotlin
* **Interface de Usuário:** XML Layouts (`activity_main.xml`)
* **Build System:** Gradle (Kotlin DSL)

## 📂 Estrutura do Projeto

O aplicativo segue a arquitetura de diretórios padrão do Android:

* **`app/src/main/java/com/example/capitais/`**: Contém a lógica principal do aplicativo, incluindo a `MainActivity.kt`.
* **`app/src/main/res/`**: Diretório de recursos estáticos.
  * **`layout/`**: Define as telas do jogo (`activity_main.xml`).
  * **`mipmap/`**: Ícones do aplicativo para diferentes resoluções de tela.
  * **`values/`**: Definições de temas, cores e strings (`colors.xml`, `strings.xml`, `themes.xml`).
* **`build.gradle.kts`**: Arquivos de configuração de dependências e compilação do Gradle.

## 🚀 Como Executar o Projeto

1. Clone este repositório em sua máquina local.
2. Abra o projeto no **Android Studio**.
3. Aguarde o Gradle sincronizar todas as dependências (`gradlew`).
4. Conecte um dispositivo Android físico ou inicie um Emulador (AVD).
5. Clique no botão **Run** (Shift + F10) para compilar e instalar o app.

## 🧪 Testes

A estrutura de testes já está configurada no projeto:
* **Testes Unitários:** Localizados em `app/src/test/java/com/example/capitais/ExampleUnitTest.kt`.
* **Testes Instrumentados:** Localizados em `app/src/androidTest/java/com/example/capitais/ExampleInstrumentedTest.kt`.
