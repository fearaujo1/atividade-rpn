# Calculadora de Expressões Matemáticas — Infixa para RPN

## 1. Descrição do projeto

Este projeto consiste no desenvolvimento de uma aplicação em Java capaz de receber expressões matemáticas na notação infixa, convertê-las para a Notação Polonesa Reversa (RPN) e calcular o resultado utilizando estruturas de pilha.

A aplicação trabalha com números inteiros e decimais e permite a utilização dos operadores:

* `+` — adição
* `-` — subtração
* `*` — multiplicação
* `/` — divisão

Também são considerados parênteses para definir a ordem das operações.

O resultado dos cálculos é realizado utilizando o tipo `double`.

---

## 2. Objetivos

O projeto tem como objetivos:

* Receber expressões matemáticas na notação infixa;
* Identificar números, operadores e parênteses;
* Converter a expressão infixa para RPN;
* Utilizar uma estrutura de pilha durante a conversão;
* Avaliar a expressão RPN utilizando uma pilha;
* Trabalhar com números inteiros e decimais;
* Respeitar a precedência dos operadores;
* Tratar situações de erro, como divisão por zero e parênteses desbalanceados;
* Apresentar a expressão original, a expressão RPN e o resultado.

---

## 3. Tecnologias utilizadas

* Java 17
* Maven
* JUnit 5
* Git
* GitHub
* IntelliJ IDEA

---

## 4. Notação Infixa

A notação infixa é a forma tradicional de escrever expressões matemáticas.

Nessa representação, o operador fica entre os operandos.

Exemplo:

```text
2 + 3
```

Outro exemplo:

```text
2 + 3 * 4
```

Nesse caso, a multiplicação possui prioridade sobre a adição.

Portanto:

```text
2 + (3 * 4)
```

O resultado é:

```text
14
```

---

## 5. Notação Polonesa Reversa (RPN)

Na Notação Polonesa Reversa, os operadores são colocados depois dos operandos.

Por exemplo:

```text
2 + 3
```

é representado como:

```text
2 3 +
```

A expressão:

```text
2 + 3 * 4
```

é convertida para:

```text
2 3 4 * +
```

A principal vantagem da RPN nesse projeto é que a ordem das operações fica explícita, permitindo que a expressão seja avaliada utilizando uma estrutura de pilha.

---

## 6. Estrutura de Pilha

A pilha utilizada no projeto segue o princípio LIFO:

**Last In, First Out**

Isso significa que o último elemento inserido é o primeiro a ser removido.

A classe `Pilha` possui operações como:

```text
push()
pop()
peek()
isEmpty()
size()
```

### push()

Adiciona um elemento ao topo da pilha.

### pop()

Remove e retorna o elemento que está no topo.

### peek()

Consulta o elemento que está no topo sem removê-lo.

### isEmpty()

Verifica se a pilha está vazia.

### size()

Retorna a quantidade de elementos armazenados.

---

## 7. Conversão de Infixa para RPN

A conversão utiliza uma pilha para armazenar temporariamente os operadores.

O algoritmo percorre a expressão e aplica as seguintes regras:

### Números

Quando um número é encontrado, ele é enviado diretamente para a saída da expressão RPN.

### Operadores

Quando um operador é encontrado, ele pode ser colocado na pilha. Antes disso, são verificadas a precedência e a associação com os operadores que já estão na pilha.

### Parêntese esquerdo

O caractere `(` é colocado na pilha.

### Parêntese direito

Quando o caractere `)` é encontrado, os operadores são retirados da pilha até encontrar o `(` correspondente.

O parêntese não é colocado na expressão RPN.

### Final da expressão

Depois que todos os elementos foram processados, os operadores restantes são retirados da pilha e adicionados à saída.

---

## 8. Precedência dos operadores

Os operadores possuem diferentes níveis de precedência.

| Operador | Precedência |
| -------- | ----------: |
| `*`      |           2 |
| `/`      |           2 |
| `+`      |           1 |
| `-`      |           1 |

Assim, multiplicações e divisões são realizadas antes de adições e subtrações.

Por exemplo:

```text
2 + 3 * 4
```

é convertida para:

```text
2 3 4 * +
```

---

## 9. Avaliação da expressão RPN

Depois da conversão, a expressão RPN é avaliada utilizando uma pilha de valores `Double`.

As regras são:

1. Quando um número é encontrado, ele é colocado na pilha.
2. Quando um operador é encontrado, os dois últimos valores da pilha são removidos.
3. A operação correspondente é realizada.
4. O resultado é colocado novamente na pilha.
5. Ao final, deve existir apenas um valor na pilha, que representa o resultado da expressão.

### Exemplo

Para:

```text
2 3 4 * +
```

A execução ocorre da seguinte maneira:

```text
2
```

Pilha:

```text
[2]
```

Depois:

```text
3
```

Pilha:

```text
[2, 3]
```

Depois:

```text
4
```

Pilha:

```text
[2, 3, 4]
```

Ao encontrar `*`:

```text
3 * 4 = 12
```

Pilha:

```text
[2, 12]
```

Ao encontrar `+`:

```text
2 + 12 = 14
```

Pilha final:

```text
[14]
```

Resultado:

```text
14.0
```

---

## 10. Tratamento de erros

A aplicação possui tratamento para algumas situações inválidas.

### Divisão por zero

A expressão:

```text
10 / 0
```

gera um erro informando que não é possível dividir por zero.

### Parênteses desbalanceados

A expressão:

```text
(2 + 3
```

é identificada como inválida porque existe um parêntese de abertura sem seu correspondente fechamento.

### Elementos inválidos

Caracteres que não fazem parte dos números, operadores ou parênteses aceitos também são rejeitados.

---

## 11. Exemplos de teste

### Exemplo 1

Expressão:

```text
2 + 3
```

RPN:

```text
2 3 +
```

Resultado:

```text
5.0
```

### Exemplo 2

Expressão:

```text
10.5 + 2.5
```

RPN:

```text
10.5 2.5 +
```

Resultado:

```text
13.0
```

### Exemplo 3

Expressão:

```text
2 + 3 * 4
```

RPN:

```text
2 3 4 * +
```

Resultado:

```text
14.0
```

### Exemplo 4

Expressão:

```text
(2 + 3) * 4
```

RPN:

```text
2 3 + 4 *
```

Resultado:

```text
20.0
```

### Exemplo 5

Expressão:

```text
(10.5 + 2.5) * 2 - 3
```

RPN:

```text
10.5 2.5 + 2 * 3 -
```

Resultado:

```text
23.0
```

---

## 12. Estrutura do projeto

```text
calculadora-rpn/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── br/
│   │           └── com/
│   │               └── rpn/
│   │                   ├── Main.java
│   │                   ├── Pilha.java
│   │                   ├── ConversorRPN.java
│   │                   └── CalculadoraRPN.java
│   │
│   └── test/
│       └── java/
│           └── br/
│               └── com/
│                   └── rpn/
│                       └── CalculadoraRPNTest.java
│
├── pom.xml
├── .gitignore
└── README.md
```

### `Pilha.java`

Implementa a estrutura de pilha utilizada pela aplicação.

### `ConversorRPN.java`

É responsável por converter a expressão infixa para a Notação Polonesa Reversa.

### `CalculadoraRPN.java`

É responsável por avaliar a expressão RPN e calcular seu resultado.

### `Main.java`

Responsável pela interação com o usuário e pela integração entre o conversor e a calculadora.

### `CalculadoraRPNTest.java`

Contém os testes automatizados das principais funcionalidades da aplicação.

---

## 13. Execução

Para executar o projeto, é necessário possuir Java 17 e Maven instalados.

O programa pode ser executado pela IDE ou utilizando o Maven.

Para executar os testes:

```bash
mvn test
```

Para executar a aplicação pela IDE, execute a classe:

```text
Main.java
```

Depois informe uma expressão matemática.

Exemplo:

```text
10.5+(2*3)
```

Saída esperada:

```text
Expressão original: 10.5+(2*3)
Expressão RPN: 10.5 2 3 * +
Resultado: 16.5
```

---

## 14. Conclusão

O projeto demonstra a utilização de estruturas de dados, principalmente a estrutura de pilha, para solucionar o problema de conversão e avaliação de expressões matemáticas.

A utilização da pilha permite implementar tanto o processo de conversão da notação infixa para RPN quanto o processo de avaliação da expressão convertida.

O desenvolvimento também contempla números inteiros e decimais, operadores aritméticos, parênteses, precedência dos operadores e tratamento de situações de erro.
