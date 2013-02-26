package classes;

public class Processo {

	static int v1=2;
	int v2=13;
	
	void troca(){
		v1=v2;
	}
	
	public static void main(String[] args) 
	{	
		Processo a =new Processo();
		Processo b =new Processo();
		a.v2=0;
		System.out.print(a.v1);
		System.out.print(a.v2);
		a.troca();
		System.out.print(b.v2);	
	}

}
