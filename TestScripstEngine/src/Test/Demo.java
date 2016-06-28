package Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 测试脚本引擎的使用
 * @author Admain
 *
 */
public class Demo {
	public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
		//获取引擎对象
		ScriptEngineManager sem=new ScriptEngineManager(); 
		ScriptEngine engine=sem.getEngineByName("javascript");
		
		//定义变量存储引擎上下文
		engine.put("msg", "good good study,day day up");
		String str="var user={name:'tom zhao',age:18,schools:'东北石油大学'};";
		str+="println(user.name)";
		//执行脚本
		engine.eval(str);
		System.out.println(engine.get("msg"));
		//msg这个键值对既可以被java操作也可以被javascript操作
		System.out.println(engine.eval("msg='qinghau'"));
		System.out.println("############################");
		//定义函数
		engine.eval("function add(a,b){var sum=a+b;return sum}");
		//执行js函数
		Invocable jsInvoke=(Invocable) engine;
		Object result=jsInvoke.invokeFunction("add",new Object[]{13,20});
		System.out.println(result);
		
		System.out.println("##############################");
		//导入其他的java包，执行其他包中的java类
		String jsCode="importPackage(java.util);var list=Arrays.asList([\"清华大学\",\"北京大学\"])";
		engine.eval(jsCode);
		List<String> list=(List<String>)engine.get("list");
		for(String ls:list){
			System.out.println(ls);
		}
		
		//执行一个js文件
		URL url=Demo.class.getClassLoader().getResource("a.js");
		FileReader fr=new FileReader(url.getPath());
		engine.eval(fr);
		fr.close();
	}
}
