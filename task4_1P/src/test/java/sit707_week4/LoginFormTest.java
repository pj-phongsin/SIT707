package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "224588035";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Phongsin";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testFailEmptyUsernameEmptyPasswordDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	/*
	 * Write more test functions below.
	 */
	@Test
	public void testFailEmptyUsernameWrongPasswordDontCareValCode()
	{
		LoginStatus status = LoginForm.login("", "wrongPass");
        Assert.assertFalse(status.isLoginSuccess());
	}
	
	@Test
    public void testFailEmptyUsernameCorrectPasswordDontCareValCode() {
        LoginStatus status = LoginForm.login("", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        
    }

    @Test
    public void testWrongUsernameEmptyPasswordDontCareValCode() {
        LoginStatus status = LoginForm.login("wrongUser", "");
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testWrongUsernameWrongPasswordDontCareValCode() {
        LoginStatus status = LoginForm.login("wrongUser", "wrongPass");
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testWrongUsernameCorrectPasswordDontCareValCode() {
        LoginStatus status = LoginForm.login("wrongUser", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testCorrectUsernameEmptyPasswordDontCareValCode() {
        LoginStatus status = LoginForm.login("ahsan", "");
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testCorrectUsernameWrongPasswordDontCareValCode() {
        LoginStatus status = LoginForm.login("ahsan", "wrongPass");
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testCorrectUsernameCorrectPasswordEmptyValCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertEquals("123456", status.getErrorMsg()); 
    }

    @Test
    public void testCorrectUsernameCorrectPasswordWrongValCode() {
    	LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertFalse(LoginForm.validateCode("WrongCode"));
    }


    @Test
    public void testCorrectUsernameCorrectPasswordCorrectValCode() {
    	LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(LoginForm.validateCode("123456"));
    }
}
