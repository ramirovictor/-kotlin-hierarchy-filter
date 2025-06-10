# Kotlin Hierarchy Filter

Este projeto resolve o desafio técnico de filtragem de uma estrutura de hierarquia em profundidade utilizando Kotlin.

## Descrição da Solução

A função `filter()` filtra nós de uma hierarquia baseada em um predicado, garantindo que **apenas nós com todos os seus ancestrais aceitos também sejam incluídos**. A lógica percorre a lista em ordem de DFS e usa uma pilha para controlar os ancestrais aceitos.

## Ferramentas e Stack

- Kotlin 1.9.22
- Gradle
- JDK 17
- JUnit 5
- IntelliJ IDEA (recomendado para execução)

## Como executar os testes

Via terminal:

```bash
./gradlew test
```
Ou diretamente pelo IntelliJ, clicando em cada teste na classe FilterTest.

## Casos de teste cobertos
- Filtro com múltiplas árvores
- Nenhum nó aceito
- Todos os nós aceitos
- Rejeição de ancestral propagando para filhos
- Validação do caso base proposto


