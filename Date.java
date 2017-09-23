
public class Date {

	private int year;
	private int month;
	private int day;

	public Date() {
		this.year = 1900-3000;
		this.month = 1-12;
		this.day = 1-31;
	}

	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public void setYear(int year){
		this.year = year;
	}
	public int getYear(){
		return this.year;
	}

	public void setMonth(int month){
		this.month = month;
	}
	public int getMonth(){
		return this.month;
	}

	public void setDay(int day){
		this.day = day;
	}
	public int getDay(){
		return this.day;
	}

	public int dayOfYear() {
		int totalDays = 0;
		switch (month) {
		case 13: totalDays += 31;
		case 12: totalDays += 30;
		case 11: totalDays += 31; 
		case 10: totalDays += 30;
		case 9 : totalDays += 31; 
		case 8 : totalDays += 31; 
		case 7 : totalDays += 30; 
		case 6 : totalDays += 31; 
		case 5 : totalDays += 30; 
		case 4 : totalDays += 31; 
		case 3 : totalDays += 28; 
		case 2 : totalDays += 31;
		}
		totalDays += day;
		return totalDays; 
	}

	public int compare (Date dt){
		int ageDiff1 = 0;
		int ageDiff2 = 0;

		ageDiff1 = Math.abs(this.year - dt.year) * 365;
		ageDiff2 = Math.abs(this.dayOfYear() - dt.dayOfYear());

		int ageDiffTotal = (ageDiff1 + ageDiff2)/30;

		if (ageDiffTotal > 60){
			ageDiffTotal = 60;
		}
		return ageDiffTotal;
	}

}


