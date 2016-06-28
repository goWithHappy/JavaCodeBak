package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * 测试javaCompiler来进行动态表编译
 * @author Admain
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		int flag=complieFile("E:/java/ActiveCompiler/src/test/Demo01.java");
		String result=rouFile("TestHello");
		System.out.println(flag==0?"编译成功":"编译失败");
		System.out.println("程序运行结果为："+result);
	}
	public static int complieFile(String source){
		//动态编译
		JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
		int result=compiler.run(null, null, null, source);
		return result;
	}
	//执行编译之后的结果
	public static String rouFile(String source){
		Runtime runtime=Runtime.getRuntime();
		try {
			Process process=runtime.exec("java -cp E:/java/ActiveCompiler/bin/test "+source);
			InputStream in=process.getInputStream();
			BufferedReader reader=new BufferedReader(new InputStreamReader(in));
			String info="";
			while(null!=(info=reader.readLine())){
				System.out.println(info);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
