package fp.xmlConverters;


import fp.dataObjects.CalendarDate;
import nu.xom.Attribute;
import nu.xom.Element;

public class CalendarDateConverter {
	public static Element convertCalendarDateToXML(CalendarDate date) {
		Element calendarDateElement = new Element("calendarDate");
		
		Attribute dayAttribute = new Attribute("day", ""+date.dayInWeek);
		Attribute weekAttribute = new Attribute("week", ""+date.week);
		Attribute yearAttribute = new Attribute("year", ""+date.year);
		
		calendarDateElement.addAttribute(dayAttribute);
		calendarDateElement.addAttribute(weekAttribute);
		calendarDateElement.addAttribute(yearAttribute);
		
		return calendarDateElement;
	}
	
	public static CalendarDate convertXMLToCalendarDate(Element dataElement) {
		int dayValue = Integer.parseInt(dataElement.getAttribute("day").getValue());
		int weekValue = Integer.parseInt(dataElement.getAttribute("week").getValue());
		int yearValue = Integer.parseInt(dataElement.getAttribute("year").getValue());
		
		return new CalendarDate(dayValue, weekValue, yearValue);
	}
}
