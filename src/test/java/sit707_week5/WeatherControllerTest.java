package sit707_week5;

import org.junit.*;
import java.util.*;

public class WeatherControllerTest {

    private static WeatherController wController;
    private static List<Double> temperatureList;

    // Arrange (runs once)
    @BeforeClass
    public static void setup() {
        wController = WeatherController.getInstance();

        int nHours = wController.getTotalHours();
        temperatureList = new ArrayList<>();

        for (int i = 0; i < nHours; i++) {
            temperatureList.add(wController.getTemperatureForHour(i + 1));
        }
    }

    // After (cleanup)
    @AfterClass
    public static void teardown() {
        wController.close();
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "224726304";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Anay Jayakumar";
        Assert.assertNotNull("Student name is null", studentName);
    }

    // ✅ TEST MIN
    @Test
    public void testTemperatureMin() {

        // Act
        double min = Collections.min(temperatureList);

        // Assert
        Assert.assertEquals(min, wController.getTemperatureMinFromCache(), 0.001);
    }

    // ✅ TEST MAX
    @Test
    public void testTemperatureMax() {

        // Act
        double max = Collections.max(temperatureList);

        // Assert
        Assert.assertEquals(max, wController.getTemperatureMaxFromCache(), 0.001);
    }

    // ✅ TEST AVERAGE
    @Test
    public void testTemperatureAverage() {

        // Act
        double sum = 0;
        for (double temp : temperatureList) {
            sum += temp;
        }
        double avg = sum / temperatureList.size();

        // Assert
        Assert.assertEquals(avg, wController.getTemperatureAverageFromCache(), 0.001);
    }

    
    public void testTemperaturePersist() {
        /*
         * Remove below comments ONLY for 5.3C task.
         */
//    	System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}
    	
}