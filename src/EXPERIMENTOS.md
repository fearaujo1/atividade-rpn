# EXPERIMENTOS

## 1) Soma de números decimais

**Execute:** `0.1 + 0.2`

**Compare o resultado obtido pelo programa com o resultado matematicamente esperado e explique o comportamento observado.**

**Resultado matemático esperado:** `0.3`

**Resultado obtido:** `0.30000000000000004`

**Análise:**
O resultado ocorre por causa da representação dos números em ponto flutuante e não porque a soma foi realizada de forma errada. Em binário, utilizando a quantidade finita de bits disponível, os números `0.1` e `0.2` não podem ser representados exatamente. Por isso, ao serem somados, o resultado apresenta uma pequena diferença em relação ao valor decimal matematicamente esperado.

---

## 2) Acúmulo de pequenas diferenças

**Execute:** `0.1 + 0.1 + 0.1`

**Compare o resultado obtido com o valor matematicamente esperado. Analise se houve diferença e explique por que pequenas imprecisões podem aparecer ou se acumular durante uma sequência de operações.**

**Resultado matemático esperado:** `0.3`

**Resultado obtido:** `0.30000000000000004`

**Análise:**
Isso acontece porque cada ocorrência de `0.1` é armazenada como uma aproximação em ponto flutuante. Dessa forma, operações sucessivas podem propagar pequenas diferenças causadas pela representação dos números.

---

## 3) Operações que deveriam resultar em zero

**Execute:** `(0.1 + 0.2) - 0.3`

**Verifique se o resultado obtido pelo programa é exatamente igual a zero. Caso exista diferença, explique sua possível origem.**

**Resultado matemático esperado:** `0`

**Resultado obtido:** `5.551115123125783E-17`

**Análise:**
Quando o programa subtrai o valor armazenado para `0.3`, as representações aproximadas não são exatamente iguais. Por isso, em vez de obter exatamente `0`, surge esse valor extremamente pequeno, que está próximo de zero.

---

## 4) Divisão e representação aproximada

**Execute:** `1.0 / 3.0`

**Verifique se o resultado obtido pelo programa é exatamente igual a zero. Caso exista diferença, explique sua possível origem.**

**Resultado matemático esperado:** `0.333333...`

**Resultado obtido:** `0.3333333333333333`

**Análise:**
O número `1/3` possui uma representação decimal infinita. Representar esse valor em uma variável `double` não é possível de forma exata, pois ela possui uma quantidade limitada de bits. Dessa maneira, o computador armazena uma aproximação do valor real.

---

## 5) Efeito da magnitude dos valores

**Execute:** `10000000000000000.0 + 1.0`

**Compare o resultado obtido pelo programa com o resultado matematicamente esperado. Analise o que acontece com a parcela `1.0` e relacione o resultado à precisão limitada da representação em ponto flutuante.**

**Resultado matemático esperado:** `10000000000000001`

**Resultado obtido:** `1.0E16`

**Análise:**
Esse experimento mostra que a precisão relativa do `double` é limitada. Consequentemente, o `double` não consegue representar a diferença de uma unidade nessa escala. Assim, a parcela `1.0` não produz uma alteração perceptível no resultado final.

---

# TABELA GERAL DOS EXPERIMENTOS

| **Experimento** | **Expressão**               | **Esperado**          | **Obtido**              | **Diferença**           |
| --------------- | --------------------------- | --------------------- | ----------------------- | ----------------------- |
| 1               | `0.1 + 0.2`                 | `0.3`                 | `0.30000000000000004`   | `4 × 10⁻¹⁷`             |
| 2               | `0.1 + 0.1 + 0.1`           | `0.3`                 | `0.30000000000000004`   | `4 × 10⁻¹⁷`             |
| 3               | `(0.1 + 0.2) - 0.3`         | `0.0`                 | `5.551115123125783E-17` | `5.551115123125783E-17` |
| 4               | `1.0 / 3.0`                 | `0.333333...`         | `0.3333333333333333`    | Aproximação             |
| 5               | `10000000000000000.0 + 1.0` | `10000000000000001.0` | `10000000000000000.0`   | `1.0`                   |

# QUESTÃO

**Os resultados diferentes do valor matematicamente esperado indicam necessariamente um erro no algoritmo? Justifique sua resposta.**

Não, resultados diferentes do valor matematicamente esperado não indicam necessariamente um erro no algoritmo. As diferenças obtidas nos experimentos estão relacionadas principalmente à representação finita dos números de ponto flutuante utilizada pelo tipo `double`.

Alguns números decimais não possuem representação binária exata e precisam ser armazenados como aproximações. Portanto, é necessário diferenciar um erro de implementação do algoritmo de uma limitação da representação numérica utilizada pelo computador.
