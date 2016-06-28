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
 * ���Խű������ʹ��
 * @author Admain
 *
 */
public class Demo {
	public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
		//��ȡ�������
		ScriptEngineManager sem=new ScriptEngineManager(); 
		ScriptEngine engine=sem.getEngineByName("javascript");
		
		//��������洢����������
		engine.put("msg", "good good study,day day up");
		String str="var user={name:'tom zhao',age:18,schools:'����ʯ�ʹ�ѧ'};";
		str+="println(user.name)";
		//ִ�нű�
		engine.eval(str);
		System.out.println(engine.get("msg"));
		//msg�����ֵ�Լȿ��Ա�java����Ҳ���Ա�javascript����
		System.out.println(engine.eval("msg='qinghau'"));
		System.out.println("############################");
		//���庯��
		engine.eval("function add(a,b){var sum=a+b;return sum}");
		//ִ��js����
		Invocable jsInvoke=(Invocable) engine;
		Object result=jsInvoke.invokeFunction("add",new Object[]{13,20});
		System.out.println(result);
		
		System.out.println("##############################");
		//����������java����ִ���������е�java��
		String jsCode="importPackage(java.util);var list=Arrays.asList([\"�廪��ѧ\",\"������ѧ\"])";
		engine.eval(jsCode);
		List<String> list=(List<String>)engine.get("list");
		for(String ls:list){
			System.out.println(ls);
		}
		
		//ִ��һ��js�ļ�
		URL url=Demo.class.getClassLoader().getResource("a.js");
		FileReader fr=new FileReader(url.getPath());
		engine.eval(fr);
		fr.close();
	}
}
