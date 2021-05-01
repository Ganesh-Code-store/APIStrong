package Regression;

class superkey {
	
	void BigDog(String name)
	{
		System.out.println(name+"--Parent");
	}
	
	void seth()
	{
		System.out.println("Seth rollins");
	}
}

public class child extends superkey
{
	public static void BigDog1(String name)
	{
		//super.BigDog(name);
		System.out.println(name+"--child");


	}

	
	void dean()
	{
		System.out.println("Dean ambrose");
		child.BigDog1("Roman");

	}
	
	
	public static void main(String[] args) {
		child ch=new child();
		ch.dean();

	}

}
