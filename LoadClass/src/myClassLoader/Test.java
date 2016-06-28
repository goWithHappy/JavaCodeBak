package myClassLoader;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException {
		FileSystemClassLoader loader=new FileSystemClassLoader("d:/myjava");
		FileSystemClassLoader loader2=new FileSystemClassLoader("d:/myjava");
		Class c=loader.findClass("com.ihad.site.Demo");
		Class c2=loader.findClass("com.ihad.site.Demo");
		Class c3=loader2.findClass("com.ihad.site.Demo");
		Class c4=loader.findClass("java.lang.String");
		System.out.println(c.hashCode()); //只有同一个类加载器加载同一个类，才会被认为是同一个类,一个项目是一个类加载器
		System.out.println(c2.hashCode());
		System.out.println(c3.hashCode());
		System.out.println(c4.getClassLoader()); //引导类加载器
		System.out.println(c3.getClassLoader()); //自定义类加载器
		
	}
}
