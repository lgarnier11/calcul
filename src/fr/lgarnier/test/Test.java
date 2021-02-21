package fr.lgarnier.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import fr.lgarnier.calcul.Calcul;

/**
 * 
 * @author lgarnier
 *
 */
class Test {

	@org.junit.jupiter.api.Test
	void test1() {
		assertEquals(3, new Calcul().run(2));
	}
	
	@org.junit.jupiter.api.Test
	void test2() {
		assertEquals(1111, new Calcul().run(902));
	}
	
	@org.junit.jupiter.api.Test
	void test3() {
		assertEquals(4111, new Calcul().run(3025));
	}
	
	@org.junit.jupiter.api.Test
	void test4() {
		assertEquals(700000, new Calcul().run(654321));
	}
	@org.junit.jupiter.api.Test
	void test5() {
		assertThrows(ArithmeticException.class,() -> new Calcul().run(123456789));
	}
}
