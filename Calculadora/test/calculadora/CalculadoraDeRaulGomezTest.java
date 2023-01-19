package calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static java.time.Duration.ofMinutes;
import static java.time.Duration.ofSeconds;

import java.util.Arrays;
import java.util.stream.Stream;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculadoraDeRaulGomezTest {
	CalculadoraDeRaulGomez calcu;

	@BeforeEach // Se ejecuta antes de cada test.
	void setUp() {
		calcu = new CalculadoraDeRaulGomez();
	}
//	@Test
//	void testAssertionsGroup() {
//		assertAll("Operaciones RaulG",
//				() -> assertEquals(30, calcu.suma(12,20),"Suma"),
//				() -> assertEquals(-9, calcu.resta(10,20),"Resta"),
//				() -> assertEquals(200, calcu.multiplica(20,10),"Multiplicacion"),
//				() -> assertEquals(2, calcu.divide(20,3),"Division")
//				);
//	}

	@Order(3)
	@Test
	void testSuma() {
		assertEquals(30, calcu.suma(12, 20), () -> "SUMA rG");
	}

	@Order(2)
	@Test
	void testResta() {
		assertEquals(-10, calcu.resta(11, 20), "RESTA rG");
	}

	@Test
	@Order(1)
	void testMultiplica() {
		assertEquals(300, calcu.multiplica(21, 13), "MULTIPLICACION rG");
	}

	@Order(4)
	@Test
	void testDivide() {
		assertEquals(2, calcu.divide(20, 10), "DIVISION rG");
	}

	@Test
	void exceptionTesting() {
		Throwable exception = assertThrows(ArithmeticException.class, () -> calcu.divide(20, 0));
		assertEquals("/ by cero", exception.getMessage());
	}
//	Modifica el código para que una operación se alargue en el tiempo e intenta controlarlo con métodos de prueba como assertTimeout()

	@Test
	void tiempoTestNoExcede1s() {
		assertTimeout(ofSeconds(5), () -> calcu.divide(200031, 123));

	}

//	@Test
//	void tiempoTestNoExcedeConResultado() {
//		Integer actualResult = assertTimeout(ofSeconds(1), () -> {
//			return 
//		});
//
//	}
	
	@Test
	void timeoutNotExceededWithResult() {
	    Integer actualResult = assertTimeoutPreemptively(ofSeconds(1), () -> {
	        return calcu.divide(23, 0);
	    });
	    assertEquals(2, calcu.divide(23, 0));
	}

//	@Test
//	void testException() {
//
//		try {
//			CalculadoraDeRaulGomez calcu = new CalculadoraDeRaulGomez(20, 0);
//			int resultado = calcu.divide();
//			assertEquals(2, resultado);
//			fail("Fallo, debería haber lanzado la excepción");
//		} catch (ArithmeticException e) {
//			// Prueba satisfactoria
//		}
//	}
//
//	 DINAMIC TEST
//	@TestFactory
//	Stream <DynamicTest> testDiferentesMultiplicaciones(){
//		MiClase tester = new MiClase();
////		Creamos los datos con los que hacer las pruebas
//		int[][] datos = new int [][] {{1,2,2},{5,3,15},{121,4,484}};
//		return ;
//		
//		
//	}
	@TestFactory
	Stream<DynamicTest> testDifferentMultiplyOperations() {
		MiClase tester = new MiClase();
		// Introducimos los datos.
		int[][] data = new int[][] { { 1, 2, 5 }, { 5, 3, 15 }, { 121, 4, 484 } };
		// Cogiendo los datos de cada vector mapeando la matriz y asignandole la funcion
		// que debe resolver.
		return Arrays.stream(data).map(entry -> { //
			// Asigna a las variabes
			int m1 = entry[0]; // Multiplicador 1
			int m2 = entry[1];// Multiplicando 2
			int expected = entry[2]; // Resultado esperado
			// Assignamos la funcion que debera resolver con los datos
			return dynamicTest(m1 + " * " + m2 + " = " + expected, () -> {
				assertEquals(expected, tester.multiply(m1, m2));
			});
		});
	}

	class MiClase {
		public int multiply(int i, int j) {
			return i * j;
		}
	}

}
