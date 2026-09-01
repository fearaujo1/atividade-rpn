
import org.example.CalculadoraRPN;
import org.example.ConversorRPN;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraRPNTest {

    private final ConversorRPN conversor = new ConversorRPN();
    private final CalculadoraRPN calculadora = new CalculadoraRPN();

    @Test
    void deveCalcularExpressaoComNumerosInteiros() {

        String expressao = "2 + 3";

        String rpn = conversor.converter(expressao);
        double resultado = calculadora.calcular(rpn);

        assertEquals("2 3 +", rpn);
        assertEquals(5.0, resultado);
    }

    @Test
    void deveCalcularExpressaoComNumerosDecimais() {

        String expressao = "10.5 + 2.5";

        String rpn = conversor.converter(expressao);
        double resultado = calculadora.calcular(rpn);

        assertEquals("10.5 2.5 +", rpn);
        assertEquals(13.0, resultado);
    }

    @Test
    void deveRespeitarPrecedenciaDosOperadores() {

        String expressao = "2 + 3 * 4";

        String rpn = conversor.converter(expressao);
        double resultado = calculadora.calcular(rpn);

        assertEquals("2 3 4 * +", rpn);
        assertEquals(14.0, resultado);
    }

    @Test
    void deveRespeitarParenteses() {

        String expressao = "(2 + 3) * 4";

        String rpn = conversor.converter(expressao);
        double resultado = calculadora.calcular(rpn);

        assertEquals("2 3 + 4 *", rpn);
        assertEquals(20.0, resultado);
    }

    @Test
    void deveCalcularExpressaoComplexaComDecimais() {

        String expressao = "(10.5 + 2.5) * 2 - 3";

        String rpn = conversor.converter(expressao);
        double resultado = calculadora.calcular(rpn);

        assertEquals("10.5 2.5 + 2 * 3 -", rpn);
        assertEquals(23.0, resultado);
    }
}