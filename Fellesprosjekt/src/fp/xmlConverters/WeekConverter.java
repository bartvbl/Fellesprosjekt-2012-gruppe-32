package fp.xmlConverters;

import nu.xom.Element;
import fp.components.smallCalendar.CalendarDateConstructor;
import fp.dataObjects.User;

public class WeekConverter {
	
	public static Element convertWeekYearToXML(int week, int month, int year){
		int[] dates = CalendarDateConstructor.getWeekDayDates(week, year);
		
			Element element = new Element("week");
			//2012-12-12 12:12:12
			Element fromDate = new Element("fromDate");
			fromDate.appendChild(year + "-" + month + "-" + dates[0] + " 0:0:0");
			
			Element toDate = new Element("toDate");
			toDate.appendChild(year + "-" + month + "-" + dates[dates.length - 1] + " 0:0:0");
			
			element.appendChild(fromDate);
			element.appendChild(toDate);

			return element;
	}
	
	public static void main(String[] args){
		System.out.println(convertWeekYearToXML(12, 3, 2012).toXML());
	}

}
