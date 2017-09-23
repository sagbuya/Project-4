
public class Preference{

	private int quietTime;
	private int music;
	private int reading;
	private int chatting;

	public Preference() {
		this.quietTime = 0-10;
		this.music = 0-10;
		this.reading = 0-10;
		this.chatting = 0-10;
	}
	
	public Preference(int quietTime, int music, int reading, int chatting) {
		this.quietTime = quietTime;
		this.music = music;
		this.reading = reading;
		this.chatting = chatting;
	}
	
	public void setquietTime(int quietTime){
		this.quietTime = quietTime;
	}
	public int getquietTime(){
		return this.quietTime;
	}
	
	public void setMusic(int music){
		this.music = music;
	}
	public int getMusic(){
		return this.music;
	}
	
	public void setReading(int reading){
		this.reading = reading;
	}
	public int getReading(){
		return this.reading;
	}
	
	public void setChatting(int chatting){
		this.chatting = chatting;
	}
	public int getChatting(){
		return this.chatting;
	}
	
	public int compare (Preference pref){
		int prefDiff = 0;
		prefDiff += Math.abs(this.quietTime - pref.quietTime);
		prefDiff += Math.abs(this.music - pref.music);
		prefDiff += Math.abs(this.reading - pref.reading);
		prefDiff += Math.abs(this.chatting - pref.chatting);		
	
		if (prefDiff > 40){
			prefDiff = 40;
		}
		return prefDiff;
	}
}
