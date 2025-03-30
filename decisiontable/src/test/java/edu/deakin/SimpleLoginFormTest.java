package edu.deakin;

import org.junit.Test;
import org.junit.Assert;

public class SimpleLoginFormTest {
	
	@Test
	public void testValidUserInvalidPass(){
		String result = SimpleLoginForm.login("testuser", "wrongpass");
		Assert.assertNotEquals(result, "succcess");
	}
	
	@Test 
	public void testInvalidUserValidPass() {
		String result = SimpleLoginForm.login("wronguser", "testpass");
		Assert.assertNotEquals(result, "success");
	}
	
	@Test
	public void testInvalidUserInvalidPass() {
		String result = SimpleLoginForm.login("wronguser", "wrongpass");
		Assert.assertNotEquals(result, "success");
	}
	
	@Test
	public void testValidUserValidPass() {
		String result = SimpleLoginForm.login("testuser", "testpass");
		Assert.assertEquals(result, "success");
	}
	
	
	// JUnit test case using ChatGPT
	
	@Test
    public void testValidLogin() {
        String result = SimpleLoginForm.login("testuser", "testpass");
        Assert.assertEquals("success", result);
    }
    
    @Test
    public void testInvalidUsername() {
        String result = SimpleLoginForm.login("wronguser", "testpass");
        Assert.assertEquals("username mismatch", result);
    }
    
    @Test
    public void testInvalidPassword() {
        String result = SimpleLoginForm.login("testuser", "wrongpass");
        Assert.assertEquals("password mismatch", result);
    }
    
    @Test
    public void testInvalidUsernameAndPassword() {
        String result = SimpleLoginForm.login("wronguser", "wrongpass");
        Assert.assertEquals("username mismatch", result);
    }

}
