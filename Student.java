// Estrutura de dados
// vamos aprender isso juntos
/*
Armazenamento sequencial
(Sequencial storage)
Storage one student before another; Just like a line. We will be using Array?

Inserir aluno depende tamanho da lista
quanto maior mais tempo leva.




*/

public class Student {

	private String name;

	public Student(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
	public boolean equals(Object obj){
		//if(obj == null) return false;
		Student other = (Student) obj;
		return other.getName().equals(this.name);
	}

	@Override
	public String toString(){
		return name;
	}
	
}