public class VectorTest{
	public static void main(String []args){
		Student s1 = new Student("itamar");
		Student s2 = new Student("hilary");

		Vector list = new Vector();

		System.out.println(list.size());
		list.add(s1);
		System.out.println(list.size());
		list.add(s2);
		System.out.println(list.size());
		System.out.println(list);
		Student s3 = new Student("Danilo");
		System.out.println(list.hasIt(s3));

		list.add(1,s3);
		System.out.println(list);
		list.remove(2);
		System.out.println(list);

	}
}