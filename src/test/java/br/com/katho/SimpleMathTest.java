package br.com.katho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleMathTest {

	// 2. Use @BeforeEach para garantir que uma NOVA instância
    //    seja criada antes de CADA teste.
	SimpleMath math;
	
	@BeforeEach
	void setup() {
		math = new SimpleMath();
	}
	
	// TEST SUM
	@Test
	void testSumSuccess() {
		
		Double total = math.sum(2.5D, 8.5D);
		Double expected = 2.5D + 8.5D;
		
		assertEquals(expected, total);
	}
	
	@Test
	void testSumFail() { // Esse teste não é fail de fato, é só para questão didática
		
		Double total = math.sum(2.5D, 8.5D);
		Double expected = 3D + 8.5D;
		
		assertNotEquals(expected, total);
	}
	
	@Test
	void testSumSuccessWithManyAssertions() {
		
		Double total = math.sum(2.5D, 8.5D);
		Double expected = 2.5D + 8.5D;
		
		assertEquals(expected, total);
		assertNotEquals(10.5, total);
		assertNotNull(total);
	}
	
	@SuppressWarnings("unused")
	@Test //Conhecendo o Assertion Message -> Quando der erro a mensagem será exibida
	void testSumAssertionMessageFail() {
		// Geralmente essa mensagem é colocada nos testes normais, caso eles falhem!
		// Ou seja, quando o seu metodo falhar caso alguém mexa em algo indevido, vai dar erro e a mensagem será disparada para ajudar a encontrar a falha
		
		@SuppressWarnings("unused")
		Double total = math.sum(2.5D, 8.5D);
		
		@SuppressWarnings("unused")
		Double expected = 3D + 8.5D;
		//Com Assertion Message é possível inserir uma mensagem amigavel para encontrar rapidamente o erro no Console View
		//assertEquals(expected, total, "testSumAssertionMessageFail() - test did not provide the expected result. ");
	}
	
	@Test // Utiliazando Lazy Assert Messages -> ele é um Lambda para não executar o Assertion Message
	void testSumAssertionMessageFailWithLambdaFunction() {
		
		double firstNumber = 2.5D;
		double secondNumber = 8.5D;

		Double total = math.sum(2.5D, secondNumber);
		Double expected = firstNumber + secondNumber;
		//Double expected2 = 20D;
		
		assertEquals(expected, total
				, () -> "testSumAssertionMessageFail() -> " // Esse cara só é executado se alguem estragar o método sum() e der erro. Isso ajuda na performance
				+ total + " + " + "did not produce " + expected + "!");
		
	}
	// END TEST SUN
	
	// TEST SUBTRACTION	
	@Test
	void testSubtractionSuccess() {
	Double total = math.subtraction(10D, 2D);
	Double expected = 10D - 2D;
	Double expectedNotEquals = 10D - 5D;
	
	assertEquals(expected, total);
	assertNotEquals(expectedNotEquals, total);
	assertNotNull(total);	
	}
	
	@Test // Testa Exception para NullPointerException
	void shouldThrowNullPointerExceptionInSubtraction() {
	    NullPointerSubtraction nps = new NullPointerSubtraction();
	    Double valorNulo = null;
	    Double valorValido = 10D;

	    assertThrows(NullPointerException.class, () -> {
	        // Força a NullPointerException passando um valor nulo
	        nps.subtractionNullPointer(valorValido, valorNulo);
	    });
	}
	
	class NullPointerSubtraction {
		public Double subtractionNullPointer(Double val1, Double val2) {
						
			return val1 - val2;
		}
	}	
	// FIM TESTE SUBTRACTION
	
	// TESTE MULTIPLICATION
	@Test
	void testMultiplicationSuccess() {
		Double total = math.multiplication(10D,  2D);
		Double expected = 10D * 2D;
		Double expectedNotEquals = 10D - 5D;
		
		assertEquals(expected, total);
		assertNotNull(total);
		assertNotEquals(expectedNotEquals, total);
	}	
	// FIM TESTE MULTIPLICATION
	
	// TESTE DIVISION
	@Test
	void testDivisionSuccess() {
		Double total = math.division(10D,  2D);
		Double expected = 10D / 2D;
		Double expectedNotEquals = 20D / 2D;
		
		assertEquals(expected, total);
		assertNotNull(total);
		assertNotEquals(expectedNotEquals, total);
	}	
	
	@Test
	void testShouldThrowExceptionWhenDividingByZero() {
		Calculator calc = new Calculator();
		ArithmeticException exception = assertThrows(
				ArithmeticException.class,
				() -> {
					double num1 = 10D;
					double num2 = 0D;
					calc.divisionZero(num1, num2);
				}
				);		
		
		String exceptionMessage = "Não pode dividir por zero!";
		
		assertEquals(exceptionMessage, exception.getMessage());
	}
		// O método que lança a exceção
		class Calculator {
			public Double divisionZero(Double num1, Double num2) {
				if (num2 == 0) {
					throw new ArithmeticException("Não pode dividir por zero!");
				}				
				
				return num1 / num2;
			}
		}	
	// FIM TESTE DIVISION
		
	// FIM TESTE MEAN
	@Test
	void testMeanSuccess() {
		Double total = math.mean(10D, 2D);
		Double expected = 6D;
		Double expectedNotEqual = 5D;
		
		assertEquals(expected, total);
		assertNotNull(total);
		assertNotEquals(expectedNotEqual, total);
	}		
	
	// FIM TESTE SQUARE
	@Test
	void testSquareRootSucsess() {
		Double total = math.squareRoot(4D);
		Double expected = 2D;
		Double expectedNotEqual = 5D;
		
		assertEquals(expected, total);
		assertNotNull(total);
		assertNotEquals(expectedNotEqual, total);
	}
	
	@Test
	void testSquareRootWithAssertionMessage() {		
		Double number = 81D;
		Double expected = 9D;
		
		Double actual = math.squareRoot(number);
		
		assertEquals(expected, actual,
				() -> "Square Root of " + number + "did not produce" + "!");
	}
	// FIM TESTE SQUARE
}	
	

	


