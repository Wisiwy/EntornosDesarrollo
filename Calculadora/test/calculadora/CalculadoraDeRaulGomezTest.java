package calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;

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
		assertEquals(-10, calcu.resta(11, 20),"RESTA rG");
	}

	@Test
	@Order(1)
	void testMultiplica() {
		assertEquals(300, calcu.multiplica(21, 13), "MULTIPLICACION rG");
	}

	@Order(4)
	@Test
	void testDivide() {
		assertEquals(2, calcu.divide(20, 3), "DIVISION rG");
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
}
