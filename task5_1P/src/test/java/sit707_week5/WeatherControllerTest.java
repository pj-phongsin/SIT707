package sit707_week5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WeatherControllerTest {
	
	private WeatherController wController;
	private int nHours;
	
	@Before
	public void setUp() {
		// Arrange: Initialize WeatherController before each test
	    wController = WeatherController.getInstance();
	    nHours = wController.getTotalHours();
	}
	
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
	public void testTemperatureMin() {
		System.out.println("+++ testTemperatureMin +++");
		
		// Initialise controller
		//WeatherController wController = WeatherController.getInstance();
		
		// Retrieve all the hours temperatures recorded as for today
		//int nHours = wController.getTotalHours();
		double minTemperature = 1000;
		for (int i=0; i<nHours; i++) {
			// Hour range: 1 to nHours
			double temperatureVal = wController.getTemperatureForHour(i+1); 
			if (minTemperature > temperatureVal) {
				minTemperature = temperatureVal;
			}
		}
		
		// Should be equal to the min value that is cached in the controller.
		Assert.assertTrue(wController.getTemperatureMinFromCache() == minTemperature);
		
		// Shutdown controller
		//wController.close();		
	}
	
	@Test
	public void testTemperatureMax() {
		System.out.println("+++ testTemperatureMax +++");
		
		// Initialise controller
		//WeatherController wController = WeatherController.getInstance();
		
		// Retrieve all the hours temperatures recorded as for today
		//int nHours = wController.getTotalHours();
		double maxTemperature = -1;
		for (int i=0; i<nHours; i++) {
			// Hour range: 1 to nHours
			double temperatureVal = wController.getTemperatureForHour(i+1); 
			if (maxTemperature < temperatureVal) {
				maxTemperature = temperatureVal;
			}
		}
		
		// Should be equal to the min value that is cached in the controller.
		Assert.assertTrue(wController.getTemperatureMaxFromCache() == maxTemperature);
		
		// Shutdown controller
		//wController.close();
	}

	@Test
	public void testTemperatureAverage() {
		System.out.println("+++ testTemperatureAverage +++");
		
		// Initialise controller
		//WeatherController wController = WeatherController.getInstance();
		
		// Retrieve all the hours temperatures recorded as for today
		//int nHours = wController.getTotalHours();
		double sumTemp = 0;
		for (int i=0; i<nHours; i++) {
			// Hour range: 1 to nHours
			double temperatureVal = wController.getTemperatureForHour(i+1); 
			sumTemp += temperatureVal;
		}
		double averageTemp = sumTemp / nHours;
		
		// Should be equal to the min value that is cached in the controller.
		Assert.assertTrue(wController.getTemperatureAverageFromCache() == averageTemp);
		
		// Shutdown controller
		//wController.close();
	}
	
}
