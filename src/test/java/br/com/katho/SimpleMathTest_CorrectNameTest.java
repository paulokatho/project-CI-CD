package br.com.katho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleMathTest_CorrectNameTest {
	
	/*
	 - PARA NOMEAR TESTES SE USA UMA CONVENÇÃO
	   ---> test[System Under Test]_[Condition or State Change]_[Expected Result]
	 
	 - Essa convenção transforma o nome do teste em uma frase: "testar [O QUE] sob [QUE CONDIÇÃO] deve produzir [QUAL RESULTADO]".

	 - Isso cria uma documentação legível que explica o propósito e o comportamento esperado do seu código.
	 */
	
	SimpleMath math;
	
	@BeforeEach
	void setup() {
		math = new SimpleMath();
	}
	
	@Test 
	void testSum_When_SixDotTwoIsAddedByTwo_ShouldReturnEightDotTwo() {// name: test[System Under Test]_[Condition or State Change]_[Expected Result]
		Double firstNumber = 6.2;
		Double secondNumber = 2D;
		
		Double actual = math.sum(firstNumber, secondNumber);
		Double expected = 8.2D;
		
		assertEquals(expected, actual,
				() -> firstNumber + " + " + secondNumber +
				" did not produce " + expected + "!");
	}
	
	@Test
	void testDivision_When_FirstNumberIdDividedByZero_ShouldThrowArithmeticException() {// name: test[System Under Test]_[Condition or State Change]_[Expected Result]
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

}
