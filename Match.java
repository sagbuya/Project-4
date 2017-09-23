import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.print.attribute.standard.NumberUpSupported;

public class Match {

	public static void main(String[] args) {

		Student students[] = new Student[100];

		String file = "src/Students.txt";
		int numStudents = 0;
		Scanner readFile;
		try {
			readFile = new Scanner(new FileReader(file));
			while(readFile.hasNext()){

				String line = readFile.nextLine();
				Scanner lineScanner = new Scanner (line);
				lineScanner.useDelimiter("\t");

				String name = lineScanner.next();
				char gender = lineScanner.next().charAt(0);

				String date = lineScanner.next();
				Scanner lineScannerDate = new Scanner (date);
				lineScannerDate.useDelimiter("-");
				int month = lineScannerDate.nextInt();
				int day = lineScannerDate.nextInt();
				int year = lineScannerDate.nextInt();
				Date birthDay = new Date(year, month, day);

				int quietTime = lineScanner.nextInt();
				int music = lineScanner.nextInt();
				int reading = lineScanner.nextInt();
				int chatting = lineScanner.nextInt();
				Preference pref = new Preference(quietTime, music, reading, chatting);

				Student st = new Student(name, gender, birthDay, pref, false);
				students[numStudents] = st;
				numStudents++;	
			}
			readFile.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int currentScore;
		int maxScore = 0;
		int maxStudentIndex = 0;
		int bestMatchStudent = 0;
		for(int i = 0; i < numStudents; i++) {
			if(!students[i].getmatched()) {
				for(int j = 0; j < numStudents; j++) {
					currentScore = students[i].compare(students[j]);
					
					if(i != j) {		
						if(!students[j].getmatched()) {// student not matched already
							currentScore = students[i].compare(students[j]);
							if (currentScore > maxScore){
								maxScore = currentScore;
								maxStudentIndex = j;
							}
						}
					}			
				}
				if(maxScore == 0) {
					System.out.println(students[i].getname() + " has no matches.");
				}
				else {
					students[i].setmatched(true);
					students[maxStudentIndex].setmatched(true);
					System.out.println(students[i].getname() + " matches with " + students[maxStudentIndex].getname()  + " with the score " + maxScore);
				}
				maxScore = 0;
			}
		}
	}
}
