package com.example.tarea4;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Tarea4ApplicationTests {

	private tarea4 Test = new tarea4();

	@Test
	void contextLoads() {
		Test.setArrays(
				new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
				new Integer[]{1,2,3,4,5},
				new Integer[]{4, 6, 3, 2});
		assertEquals(55, Test.totalDebit());
		assertEquals(15, Test.totalCredit());
		assertEquals(40, Test.saldo());
		assertEquals(5.5, Test.avgDebit());
		assertEquals(10, Test.maxDebit());
		assertEquals(15, Test.totalTransactions());
		assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0, 0, 0]", Arrays.toString(Test.printDebit()));
		assertEquals("[1, 2, 3, 4, 5, 0, 0, 0, 0, 0]", Arrays.toString(Test.printCredit()));
		assertEquals("", Test.eliminate());
		assertEquals(40, Test.totalDebit());
		assertEquals(6, Test.totalCredit());
		assertEquals(34, Test.saldo());
		assertEquals(6.666666666666667, Test.avgDebit());
		assertEquals(10, Test.maxDebit());
		assertEquals(8, Test.totalTransactions());

	}

}
