// Lab11 Start  abbas, stanley


// Matt Solberg and Dylan Finazzo


// Lab11 Start Jack Fergus & Sarah McDonald

// Lab11 Start  Names Here Please Soon-Young Shimizu Wayne

// Lab11 Start  Emily Fitts & Ooga Na
// Lab11 Start  Kaitlyn Haase & Cameron Chandler


public class DateObject {
	// 1 o'oclock section
	private int day;
	private int month;
	private int year;
	private String calendar;
	
	private static String[] names = {"No Month Zero","January","February","March",
			"April","May","June","July","August","September","October",
			"November","December"};
			
			
	public static int monthToInt(String name) {
		for (int i=1; i<13; i++) {
			if (name.equals(names[i]))
				return i;
		}
		return -1;
	}
		
	public void setDay(String m, int d, int y) {
		
		day = d;
		year = y;
		month = monthToInt(m);
		calendar = "Gregorian";
	}
	
public void setDay(String m, int d, int y, String cal) {
		
    day=d;
    year=y;
    month= monthToInt(m);
    calendar= cal;


	}
		
	public void bump() {
		day = day + 1;
	}
		
	
	public String printRep() {
		return names[month]+"/"+day+"/"+year;
	}
	
	// calculate the days in the month  Use isLeap
	public int daysInMonth() {
	    int daysinmonth=0;
	    if(isLeap()==false){
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
		    daysinmonth = 31;
		    return daysinmonth;}
		if(month==4||month==6||month==9||month==12){
		    daysinmonth = 30;
		    return daysinmonth;}
		if(month==2){
		    daysinmonth=28;
		    return daysinmonth;
		}
	    }

	    if(isLeap()==true){
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
		    daysinmonth = 31;
		    return daysinmonth;}
		if(month==4||month==6||month==9||month==12){
		    daysinmonth = 30;
		    return daysinmonth;}
		if(month==2){
		    daysinmonth=29;
		    return daysinmonth;
		}
	    }
	    return 0;	    
	}
	
	// call one of isLeapGregorian and isLeap Julian
	public boolean isLeap() {
	    if(calendar.equals("Gregorian"))
		    return isLeapGregorian();
	    if(calendar.equals("Julian"))
		       return isLeapJulian();

     else return false;
	}
	
	// leap year if divisible by 400, or if divisible by 4 and not 100
	public boolean isLeapGregorian(int year) {
	    if( year%400==0 || (year%4==0 && !(year%100==0)))
		return true;
	    else return false;
	}
	
	// leap year if divisible by 4
	public boolean isLeapJulian(int year) {
	    if ( year%4==0)
		return true;
	    else return false;
	}
	
	public boolean sameDate(DateObject other) {
		if (day == other.day && year == other.year && month == other.month)
			return true;
		else
			return false;
	}
	
	// return true if December 31
	public boolean isLastDayInYear() {
		return false;
	}

	// return a new Date with the same fields as this one
	public DateObject generateCopy() {

	    DateObject new1 = new DateObject();	
	    new1.setDay(this.getMonth(), this.getDay(), this.getYear(), calendar); 
	    return new1;
	}
	
	// return a new Date with the same fields as this one's tomorrow
	public DateObject generateTomorrow() {
	    DateObject new1 = generateCopy();
	    new1.makeTomorrow();
	    return new1;
	}
	
	//return the year
	public int getYear() {
		return year;
	}
	// return the day
	public int getDay() {
		return day;
		
	}
	
	// return the month
	public String getMonth() {
		
		
	    return names[month];	
	}
	
	// finish this - check for the end of a month use daysinmonth
	public void makeTomorrow() {
	
		
		if (isLastDayInYear()) {
			day = 1;
			month = 1;
			year = year+1;
		}
		else {
			bump();
			if (daysInMonth(month)<day){
				month++;
				day = 1;
			}
		}
	
	
	}

	// move forward n days (use makeTomorrow
	public void makeTomorrow(int n){
	    for (int i=0;i<n;i++){
		makeTomorrow();
	    }

	}







	// return true if this is after other
	public boolean after(DateObject other) {
	    if(year > other.getYear()){
		return true;
		    }
	    else if(year == other.getYear() && month > monthToInt(other.getMonth())){
		return true;
		    }					   

	    else if(year==other.getYear() && month==monthToInt(other.getMonth()) && day > other.getDay()){
		return true;
		    }
	    
	    else{
		return false;
	}
	}
	
	// return true if this is before other 
	public boolean before(DateObject other) {
	
	    if(other.getYear() > year){
		return true;
		    }
	    else if(year == other.getYear() && month < monthToInt(other.getMonth())){
		return true;
		    }					   

	    else if(year==other.getYear() && month==monthToInt(other.getMonth()) && day < other.getDay()){
		return true;
		    }
	    
	    else{
		return false;
	}
	}
}