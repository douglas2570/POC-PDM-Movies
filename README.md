# 🎬 Cinema App POC

> **Prova de Conceito (POC)** desenvolvida para a disciplina de Programação para Dispositivos Móveis.

Este projeto é uma aplicação Android nativa moderna que consome a API do **The Movie Database (TMDB)** para listar filmes populares e exibir seus detalhes. O foco principal do desenvolvimento foi a implementação de uma camada de rede robusta utilizando **Retrofit 2**.

---

## 📱 Funcionalidades

* **Listagem de Filmes:** Exibe uma grade (grid) com os posters dos filmes mais populares do momento.
* **Detalhes do Filme:** Ao clicar em um filme, navega para uma tela de detalhes mostrando o título, sinopse (overview), data de lançamento, nota média e imagem de capa (backdrop).
* **Interface Reativa:** UI construída 100% em **Jetpack Compose**.
* **Tratamento de Erros:** Exibição de mensagens de erro caso a requisição falhe.
* **Indicador de Carregamento:** Feedback visual enquanto os dados são baixados.

---

## 🛠 Tecnologias e Bibliotecas

O projeto segue as práticas do **Modern Android Development (MAD)**:

* **[Kotlin](https://kotlinlang.org/):** Linguagem principal.
* **[Jetpack Compose](https://developer.android.com/jetpack/compose):** Toolkit moderno para construção de UI nativa.
* **[Retrofit 2](https://square.github.io/retrofit/):** Cliente HTTP type-safe para Android (Foco do projeto).
* **[OkHttp 3](https://square.github.io/okhttp/):** Cliente HTTP subjacente, utilizado aqui para Logging Interceptor.
* **[Gson](https://github.com/google/gson):** Conversor JSON para objetos Kotlin.
* **[Coil](https://coil-kt.github.io/coil/compose/):** Carregamento de imagens assíncrono otimizado para Compose.
* **[Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) & [Flow](https://kotlinlang.org/docs/flow.html):** Para programação assíncrona e gerenciamento de estado reativo.
* **MVVM (Model-View-ViewModel):** Arquitetura utilizada para separação de responsabilidades.

---

## 🏗 Arquitetura e Retrofit

A camada de dados foi desenhada para ser limpa e eficiente. Abaixo estão os destaques da implementação do **Retrofit**:

1.  **Singleton Pattern:** O `RetrofitClient` é instanciado como um `object`, garantindo uma única instância do cliente HTTP para toda a aplicação.
2.  **Authorization Header:** O Token Bearer é injetado diretamente nos cabeçalhos via anotação `@Headers` na interface do serviço.
3.  **Logging Interceptor:** Configurado para visualizar o corpo (BODY) das requisições e respostas no Logcat, facilitando o debug.
4.  **Assincronismo:** As chamadas de API são `suspend functions`, executadas em *Coroutines* para não bloquear a Thread Principal (UI).

**Estrutura de Pastas:**
```text
com.example.cinema
├── data
│   ├── model       // Data Classes (Movie, MoviesResponse)
│   └── network     // Configuração do Retrofit e Interface da API
├── ui
│   ├── navigation  // Configuração das rotas (Home/Details)
│   ├── screens     // Telas (Composables)
│   ├── theme       // Tema e Cores
│   └── viewmodel   // Gerenciamento de estado (StateFlow)
└── MainActivity.kt // Ponto de entrada
