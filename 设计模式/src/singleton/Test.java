package singleton;

public class Test {
	public static void main(String[] args) {
		EnumStyle e=EnumStyle.instance;
		e.operation();
		System.out.println(e);
	}
}
