package br.com.katho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// CLASSE QUE DEMONSTRA TESTE PARA EXCEPTIONS -> APENAS PARA FINS EDUCACIONAIS

/*
 *  A PARTE MAIS IMPORTANTE DESSE CÓDIGO:
 *  - DIVISÃO POR ZERO:
 *  	- SÓ RETORNA NA DIVISÃO POR ZERO -> ArithmeticException (QUANDO DIVIDE 2 NÚMEROS INTEIROS)
 *  	- SE OS NÚMEROS DIVIDOS SÃO DOUBLE -> O RETORNO SERÁ UM (INFINITY - E NÃO VAI LANÇAR A EXCEÇÃO)
 *  	
 *  - PARA TRATAR E VALIDAR UMA EXCEPTION É NECESSÁRIO FAZER UMA VALIDAÇÃO PARA VERIFICAR SE O SEGUNDO NÚMERO DA DIVISÃO É ZERO
 *  	- EX:
 *   		    public Double division(Double firstNumber, Double secondNumber) {
			    	if (secondNumber.equals(0D)) throw new ArithmeticException(); // -----> NESSE TRECHO
			        return firstNumber / secondNumber;
			    }
 */

@DisplayName("Test BDD - Math Operations in SimpleMath Class")
public class SimpleMathTest_Exception_AssertThrows {

	 
	SimpleMath math;
    
    @BeforeAll
    static void setup() {
        System.out.println("Running >>>>> @BeforeAll <<<<< method!");
        System.out.println();
    }
    
    @AfterAll
    static void cleanup() {
        System.out.println("Running >>>>> @AfterAll <<<<< method!");
        System.out.println();
    }
    
    @BeforeEach
    void beforeEachMethod() {
        math = new SimpleMath();
        System.out.println("Running @BeforeEach method!");
    }
    
    @AfterEach
    void afterEachMethod() {
        System.out.println("Running @AfterEach method!");
        System.out.println();
    }
    
    // test[System Under Test]_[Condition or State Change]_[Expected Result]    
    @Test
    @DisplayName("Test Division by Zero")
    void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException() {

        //GIVEN
    	double firstNumber = 6.2D;
    	double secondNumber = 0D;
    	
    	var expectedMessage = ("Impossible to divide by zero!");
    	
    	//WHEN & THEN
    	// Aqui captura a exception message
    	ArithmeticException actual = assertThrows(ArithmeticException.class,
    			() -> {
    				//WHEN & THEN
    				math.division(firstNumber, secondNumber);
    			}, () -> "Division by zero should throw an ArithmeticException");
    			
    	// Aqui compara os valores
    	assertEquals(expectedMessage, actual.getMessage(),
    			() -> "Unexpected exception message!");
    }
    
}	
	

	


