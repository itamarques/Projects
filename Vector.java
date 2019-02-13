import java.util.Arrays;


public class Vector {
	private Student[] students = new Student[10];
	private int totalStudents = 0;

	public void add(Student student){
		this.students[totalStudents] = student;
		totalStudents++;
	}

	private boolean indexValidate(int index){
		return index >= 0 && index <= totalStudents;
	}

	public void add(int index, Student student){
		// start in the last position i = totalstudents - 1;
		// i > = index;
		//O(N)
		if(!indexValidate(index)){
			throw new IllegalArgumentException("Index cant be accessed");
		}
		for(int i = totalStudents - 1; i >= index; i-- ){
			students[i+1] = students[i];
		}
		students[index] = student;
		totalStudents++;
	}

	private boolean indexBusy(int index){
		return index >=0 && index < totalStudents;
	}

	public Student get(int index){
		if(!indexBusy(index)){
			throw new IllegalArgumentException("cant access that index");
		}
		return students[index];
	}

	public void remove(int index){

		for(int i = index; i < totalStudents -1;i++){
			this.students[i] = this.students[i+1];
		}
		totalStudents--;
		this.students[totalStudents] = null;
	}

	public boolean hasIt(Student student){

		for(int i =0; i < totalStudents; i++){
			if(student.equals(students[i])) {
				return true;
			}
		}
		return false;
	}

	public int size(){
		return totalStudents;
	}

	public String toString(){
		return Arrays.toString(students);
	}
}