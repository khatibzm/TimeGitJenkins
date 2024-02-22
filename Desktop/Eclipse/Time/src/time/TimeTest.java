/**
 * 
 */
package time;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * 
 */
class TimeTest {

	/**
	 * Test method for {@link time.Time#getTotalSeconds(java.lang.String)}.
	 */
	@Test
	void testGetTotalSecondsGood() {
	
		int result = Time.getTotalSeconds("05:05:05:00");
		assertTrue("The seconds were calculated properly", result == 18305);
	}

	@Test
	void testGetTotalSecondsBad() {
            
    assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getTotalSeconds("10:00");}) ;
	
	}

	@Test
	void testGetTotalSecondsBoundary() {
		
		int result = Time.getTotalSeconds("23:59:59:00");
		//System.out.println(result);
		assertTrue("The seconds were calculated properly", result == 86399);
	}


	
	/**
	 * Test method for {@link time.Time#getSeconds(java.lang.String)}.
	 */
	
	@ParameterizedTest
	@ValueSource(strings = {"02:30:23:00","02:59:23:00","02:10:23:00"})
	void testGetSeconds(String candidate) {
		int seconds = Time.getSeconds(candidate);
		assertTrue("The seconds were calculated properly",
				seconds == 23);
	}
	
	@Test
	void testGetSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class , () -> {Time.getSeconds("10:00");});
	}

	/**
	 * Test method for {@link time.Time#getTotalMinutes(java.lang.String)}.
	 */
	
	@ParameterizedTest
	@ValueSource(strings = {"12:30:00:00","21:30:59:00","13:30:06:00"})
	void testGetTotalMinutes(String candidate) {
		int mins = Time.getTotalMinutes(candidate);
		assertTrue("The minutes were calculated properly",
				mins == 30);
	}

	
	@Test
	void testGetTotalMinutesBad() {
            
    assertThrows(NumberFormatException.class, ()-> {Time.getTotalMinutes("00:0:50:00");}) ;

	}

	/**
	 * Test method for {@link time.Time#getTotalHours(java.lang.String)}.
	 */
	
	@ParameterizedTest
	@ValueSource(strings = {"02:30:00:00","02:59:59:00","02:10:06:00"})
	void testGetTotalHours(String candidate) {
		int hours = Time.getTotalHours(candidate);
		assertTrue("The hours were calculated properly",
				hours == 2);
	}
	
	@Test
	void testGetTotalHoursBad() {
            
    assertThrows(NumberFormatException.class, ()-> {Time.getTotalHours("0:60:50:00");}) ;

	}
	
	@Test
	void testGetMillisecondsGood() {
		int result = Time.getMilliseconds("12:05:05:06");
		assertTrue("The milliseconds were calculated properly", result == 6);
	}
	
	@Test
	void testGetMillisecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class, () -> {Time.getMilliseconds("10:05:06:6");}) ;
		
	}
	
	@Test
	void testGetMillisecondsBoundary() {
		int result = Time.getMilliseconds("12:05:05:59");
		assertTrue("The milliseconds were calculated properly", result == 59);
	}
	
	

}
