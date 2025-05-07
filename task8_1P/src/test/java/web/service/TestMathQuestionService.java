package web.service;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import web.service.MathQuestionService;

public class TestMathQuestionService {
	
	// --- q1Addition Tests ---
    @Test
    public void testQ1Addition_ValidInputs() {
        double result = MathQuestionService.q1Addition("3", "7");
        assertEquals(10.0, result, 0.001);
    }

    @Test
    public void testQ1Addition_NegativeNumbers() {
        double result = MathQuestionService.q1Addition("-3", "-5");
        assertEquals(-8.0, result, 0.001);
    }

    @Test
    public void testQ1Addition_Decimals() {
        double result = MathQuestionService.q1Addition("2.5", "1.5");
        assertEquals(4.0, result, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQ1Addition_InvalidInput() {
        MathQuestionService.q1Addition("abc", "4");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQ1Addition_EmptyInput() {
        MathQuestionService.q1Addition("", "2");
    }

    // --- q2Subtraction Tests ---
    @Test
    public void testQ2Subtraction_ValidInputs() {
        double result = MathQuestionService.q2Subtraction("10", "3");
        assertEquals(7.0, result, 0.001);
    }

    @Test
    public void testQ2Subtraction_NegativeNumbers() {
        double result = MathQuestionService.q2Subtraction("-5", "-3");
        assertEquals(-2.0, result, 0.001);
    }

    @Test
    public void testQ2Subtraction_Decimals() {
        double result = MathQuestionService.q2Subtraction("5.5", "2.2");
        assertEquals(3.3, result, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQ2Subtraction_InvalidInput() {
        MathQuestionService.q2Subtraction("x", "2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQ2Subtraction_EmptyInput() {
        MathQuestionService.q2Subtraction("7", "");
    }

    // --- q3Multiplication Tests ---
    @Test
    public void testQ3Multiplication_ValidInputs() {
        double result = MathQuestionService.q3Multiplication("3", "4");
        assertEquals(12.0, result, 0.001);
    }

    @Test
    public void testQ3Multiplication_NegativeNumbers() {
        double result = MathQuestionService.q3Multiplication("-2", "5");
        assertEquals(-10.0, result, 0.001);
    }

    @Test
    public void testQ3Multiplication_DecimalNumbers() {
        double result = MathQuestionService.q3Multiplication("2.5", "4");
        assertEquals(10.0, result, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQ3Multiplication_InvalidInput() {
        MathQuestionService.q3Multiplication("abc", "4");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQ3Multiplication_EmptyInput() {
        MathQuestionService.q3Multiplication("", "5");
    }
}