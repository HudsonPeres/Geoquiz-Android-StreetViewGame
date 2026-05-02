# Geoquiz - Android Street view API

Um jogo estilo "Geoguessr" desenvolvido nativamente para Android. O aplicativo coloca o jogador em um local aleatório famoso ao redor do mundo através do Google Street View, e o objetivo é adivinhar em qual país você está observando as imagens em 360 graus.

## 🎮 Regras do Jogo
- O jogador é posicionado em um local aleatório no Street View.
- São apresentadas 4 opções de países para adivinhar.
- **Vitória:** O jogador deve acertar **10 países** para ganhar o jogo.
- **Derrota:** Um único erro resulta no fim de jogo imediato.

## 🛠️ Tecnologias Utilizadas
- **Linguagem:** Kotlin
- **Interface Gráfica:** Jetpack Compose (Material 3)
- **Navegação:** Navigation Compose
- **Gerenciamento de Estado:** ViewModel e StateFlow
- **Mapa/API:** Google Maps SDK for Android (`maps-compose` e Street View)
- **Segurança da Chave da API:** Secrets Gradle Plugin

## 🚀 Como Rodar o Projeto

### 1. Pré-requisitos
- [Android Studio](https://developer.android.com/studio) instalado no seu computador.
- Uma conta no Google Cloud Console com faturamento ativado.

### 2. Configurando a Chave da API (Maps SDK)
Para que as imagens do Street View carreguem, você precisa de uma chave de API do Google Cloud:

1. Acesse o [Google Cloud Console](https://console.cloud.google.com/).
2. Crie ou selecione um projeto.
3. Vá em **APIs e Serviços > Biblioteca** e ative a **Maps SDK for Android**.
4. Vá em **Credenciais** e gere uma **Chave de API**.
5. No seu computador, abra a pasta raiz do projeto e localize (ou crie) o arquivo `local.properties`.
6. Adicione a sua chave neste arquivo da seguinte forma:
   ```properties
   MAPS_API_KEY=AIzaSySuaChaveAqui...
   ```
   *(Atenção: O arquivo `local.properties` é ignorado pelo Git por padrão para que sua chave não vaze publicamente).*

---
*Desenvolvido como um projeto final da UC00609 Desenvolver de aplicações móveis (plataforma Android).*
