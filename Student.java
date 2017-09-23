
public class Student {

	private String name;
	private char gender;
	private Date birthDay;
	private Preference pref;
	private Boolean matched;

	public Student(String name, char gender, Date birthDay, Preference pref, Boolean matched) {
		this.name = name;
		this.gender = gender;
		this.birthDay = birthDay;
		this.pref = pref;
		this.matched = matched;
	}

	public void setname(String name){
		this.name = name;
	}
	public String getname(){
		return this.name;
	}

	public void setgender(char gender){
		this.gender = gender;
	}
	public char getgender(){
		return this.gender;
	}

	public void setbirthDay(Date birthDay){
		this.birthDay = birthDay;
	}
	public Date getbirthDay(){
		return this.birthDay;
	}

	public void setpref(Preference pref){
		this.pref = pref;
	}
	public Preference getpref(){
		return this.pref;
	}

	public void checkmatched(Student name){
		if(this.pref == name.pref) {
			this.setmatched(true);
			name.setmatched(true);
		}
		else{
			this.setmatched(false);
			name.setmatched(false);
		}
	}
	public void setmatched(Boolean matched){
		this.matched = matched;
	}

	public Boolean getmatched(){
		return this.matched;
	}

	public int compare (Student st){
		int ageDiffTotal = this.birthDay.compare(st.getbirthDay());
		int prefDiff = this.pref.compare(st.getpref());
		int score;

		if(this.gender != st.getgender()){			
			return 0;	
		}
		else{
			score = (40 - prefDiff) + (60 - ageDiffTotal);
		}
		return score;
	}
}
