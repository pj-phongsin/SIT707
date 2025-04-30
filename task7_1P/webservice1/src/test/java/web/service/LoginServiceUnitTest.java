package web.service;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginServiceUnitTest {

    @Test
    public void testValidLogin_dobDashFormat() {
        assertTrue(LoginService.login("pj", "pj_pass", "09-10-1996"));
    }

    @Test
    public void testValidLogin_dobISOFormat() {
        assertTrue(LoginService.login("pj", "pj_pass", "1996-10-09"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(LoginService.login("wrong", "pj_pass", "10-09-1996"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(LoginService.login("pj", "wrong", "10-09-1996"));
    }

    @Test
    public void testInvalidDOB() {
        assertFalse(LoginService.login("pj", "pj_pass", "2000-01-01"));
    }

    @Test
    public void testNullInputs() {
        assertFalse(LoginService.login(null, null, null));
    }

    @Test
    public void testEmptyStrings() {
        assertFalse(LoginService.login("", "", ""));
    }

    @Test
    public void testWhitespaceInputs() {
        assertFalse(LoginService.login("   ", "   ", "   "));
    }

    @Test
    public void testExtraSpaces() {
        assertTrue(LoginService.login(" pj ", " pj_pass ", " 09-10-1996 "));
    }
}