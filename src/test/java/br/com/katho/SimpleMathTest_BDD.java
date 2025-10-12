package br.com.katho;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test BDD - Math Operations in SimpleMath Class")
public class SimpleMathTest_BDD {

	// 2. Use @BeforeEach para garantir que uma NOVA instância
    //    seja criada antes de CADA teste.
	SimpleMath math;
	
	@BeforeEach
	void setup() {
		math = new SimpleMath();
	}
	
	// TEST SUM - com BDD ou Triple AAA
	@Test
	@DisplayName("Test 6.2 + 2 = 8.2")
	void testSum_When_SixDotTwoIsAddedByTwo_ShouldReturnEightDotTwo() {
		
	// GIVEN / ARRANGE
		//SimpleMath math = new SimpleMath();
		double firstNumber = 6.2D;
		double secondNumber = 2;
		double expected = 8.2D;
		
	// WHEN / ACT
		Double actual = math.sum(firstNumber, secondNumber);
		
	// THEN / ASSERT
		assertEquals(expected, actual,
				() -> firstNumber + " + " + secondNumber
				+ " did not produce " + expected + "!");
	}
	
	@Test
	@DisplayName("Display Name")
	void testeABCD_When_XYZ_Should() { // Teste criado pelo template do Eclipse Snippets
		// GIVEN - ARRANGE
		// WHEN  - ACT
		// THEN  - ASSERT
	}
}	
	

	


