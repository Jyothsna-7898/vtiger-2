package genericlibraries;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/*This class contains reusable methods related to java operations
 * @author Track Qspiders
 */

public class JavaUtility {
	

	public int generateRandomNum(int limit)
	{
		/*This method is used to generate and return the random number within specified limit
		 * @parameter limit
		 * return limit
		 */
		Random random=new Random();
		return random.nextInt(limit);
	}
	
	public String getCurrentTime()
	{
		/*this method returns current time
		 * @return
		 */
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_sss");
		return sdf.format(date);
	}
	
	public int convertMonthToInt(String month)
	{
		/*This method is used to convert String type month to integer
		 * @parameter month
		 * @return
		 */
		return DateTimeFormatter
				.ofPattern("MMMM")
				.withLocale(Locale.ENGLISH)
				.parse(month)
				.get(ChronoField.MONTH_OF_YEAR);
	}
}
