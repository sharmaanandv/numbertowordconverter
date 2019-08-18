package com.converter;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.converter.impl.NumberToWordsConverter;

@RunWith(SpringRunner.class)
public class ConverterApplicationTests {

	NumberToWordsConverter numberToWordsConverter;

	@Before
	public void contextLoads() {
		numberToWordsConverter = new NumberToWordsConverter();
	}

	@Test
	public void test105() {
		System.out.println(numberToWordsConverter.convert(105));
		assertTrue(numberToWordsConverter.convert(105).equals("one hundred and five"));
	}

	@Test
	public void testMinus100() {
		assertTrue(numberToWordsConverter.convert(-100).equals("minus one hundred"));
	}

	@Test
	public void test5945781() {
		assertTrue(numberToWordsConverter.convert(5945781)
				.equals("five million nine hundred and forty five thousand seven hundred and eighty one"));
	}

	@Test
	public void test56945781() {
		assertTrue(numberToWordsConverter.convert(56945781)
				.equals("fifty six million nine hundred and forty five thousand seven hundred and eighty one"));
	}

	@Test
	public void test999999999() {
		assertTrue(numberToWordsConverter.convert(999999999).equals(
				"nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine"));
	}
	
	@Test
	public void testHigherNumber() {
		assertTrue(numberToWordsConverter.convert(1999999999).equals(
				"Number is too high"));
	}

	@Test(expected = ArithmeticException.class)
	public void testInfinity() {
		assertTrue(numberToWordsConverter.convert(1 / 0).equals("infinity"));
	}

}
