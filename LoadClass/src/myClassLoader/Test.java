package myClassLoader;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException {
		FileSystemClassLoader loader=new FileSystemClassLoader("d:/myjava");
		FileSystemClassLoader loader2=new FileSystemClassLoader("d:/myjava");
		Class c=loader.findClass("com.ihad.site.Demo");
		Class c2=loader.findClass("com.ihad.site.Demo");
		Class c3=loader2.findClass("com.ihad.site.Demo");
		Class c4=loader.findClass("java.lang.String");
		System.out.println(c.hashCode()); //ֻ��ͬһ�������������ͬһ���࣬�Żᱻ��Ϊ��ͬһ����,һ����Ŀ��һ���������
		System.out.println(c2.hashCode());
		System.out.println(c3.hashCode());
		System.out.println(c4.getClassLoader()); //�����������
		System.out.println(c3.getClassLoader()); //�Զ����������
		
	}
}
