package br.com.katho;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Math Operations in SimpleMath Class")
public class SimpleMathTest_DisplayNameTest {
	
	/*
		PARA NÃO FICAR COM UM NOME GIGANTE E DIFICIL DE LER VAMOS USAR A ANOTAÇÃO:
			- @DisplayName
	 */
	
	SimpleMath math;
	
	@BeforeEach
	void setup() {
		math = new SimpleMath();
	}
	
	@Test
	@DisplayName("Test 6.2 + 2 = 8.2")
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
	@DisplayName("Test Division by Zero")
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
		
	@Test
	@DisplayName("Test Mean Success - (6.2 + 2) / 2 = 4.1")
	void testMean() {
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		
		Double actual = math.mean(firstNumber, secondNumber);
		double expected = 4.1;
		
		assertEquals(expected, actual,
				() -> "(" + firstNumber + " + " + secondNumber + ")/2" + " did not produce " + expected + "!");
	}
	
	@Test
	@DisplayName("Test Square Root of 81 = 9")
	void testSquareRootWithAssertionMessage() {		
		Double number = 81D;
		Double expected = 9D;
		
		Double actual = math.squareRoot(number);
		
		assertEquals(expected, actual,
				() -> "Square Root of " + number + "did not produce" + "!");
	}
}
