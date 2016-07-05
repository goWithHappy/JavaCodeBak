package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import beans.ColumnInfo;
import beans.JavaFieldGetSet;
import beans.TableInfo;
import core.DBManager;
import core.MysqlTypeConvertor;
import core.TableContext;
import core.TypeConvertor;

/**
 * 封装了Java文件的（源代码）常用的操作
 * @author Admain
 *
 */
public class JavaFileUtils {
	/**
	 * 根据字段生成java属性的信息如varchar username -》private String username;以及相应的set和get的源码
	 * @param column
	 * @param convertor
	 * @return java属性和set/get属性的源码
	 */
	public static JavaFieldGetSet createFiledGetSetSRC(ColumnInfo column,TypeConvertor convertor){
		JavaFieldGetSet jfgs=new JavaFieldGetSet();
		String javaFieldType=convertor.databaseType2JavaType(column.getDataType());
		jfgs.setFieldInfo("\tprivate "+javaFieldType+" "+column.getName()+";\n");
		
		//拼接一个get的字符串 public String getUsername(){return username;}
		StringBuilder getSrc=new StringBuilder();
		getSrc.append("\tpublic "+javaFieldType+" get"+StringUtils.firstChar2UpperCase(column.getName())+"(){\n");
		getSrc.append("\t\treturn "+column.getName()+";\n");
		getSrc.append("\t}\n");
		jfgs.setGetInfo(getSrc.toString());
		
		//拼接一个set的源码 public void setUsername(String userName){return userName};
		StringBuilder setSrc=new StringBuilder();
		setSrc.append("\tpublic void set"+StringUtils.firstChar2UpperCase(column.getName())+"(");
		setSrc.append(javaFieldType+" "+column.getName()+"){\n");
		setSrc.append("\t\tthis."+column.getName()+"="+column.getName()+";\n");
		setSrc.append("\t}\n");
		jfgs.setSetInfo(setSrc.toString());
		return jfgs;
	}
	/**
	 * 根据报信息生成对应的Java类
	 * @param tbaleInfo 表信息
	 * @param convert	表类型转换器
	 * @return	java类的源码
	 */
	public static String createJavaSrc(TableInfo tableInfo,TypeConvertor convert){
		StringBuilder src=new StringBuilder();
		Map<String,ColumnInfo> column=tableInfo.getColumns();
		List<JavaFieldGetSet> javaFields=new ArrayList<>();
		/**
		 * 将字段信息-->java的属性信息
		 */
		for(ColumnInfo c: column.values()){
			javaFields.add(createFiledGetSetSRC(c, convert));
		}
		//生成package的语句
		src.append("Package"+DBManager.getConf().getPaPackage()+";\n\n");
		//生成import的语句
		src.append("import java.sql.*;\n").append("java.util.*\n\n");
		//生成类声明的语句
		src.append("public class "+StringUtils.firstChar2UpperCase(tableInfo.getTname())+"{\n\n");
		//生成属性列表
		for(JavaFieldGetSet f:javaFields){
			src.append(f.getFieldInfo());
		}
		//生成get方法列表
		for(JavaFieldGetSet f:javaFields){
			src.append(f.getGetInfo());
		}
		//生成set方法列表
		for(JavaFieldGetSet f:javaFields){
			src.append(f.getSetInfo());
		}
		//生成类结束符
		src.append("}\n");
		System.out.println(src);
		return src.toString();
	}
	
	public static void main(String[] args) {
//		ColumnInfo ci=new ColumnInfo("id", "int", 0);
//		JavaFieldGetSet f=createFiledGetSetSRC(ci, new MysqlTypeConvertor());
//		System.out.println(f);
		Map<String,TableInfo> map=TableContext.tables;
		TableInfo t=map.get("emp");
		createJavaSrc(t, new MysqlTypeConvertor());
	}
}
