package utils;

import beans.ColumnInfo;
import beans.JavaFieldGetSet;
import core.MysqlTypeConvertor;
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
	public static void main(String[] args) {
		ColumnInfo ci=new ColumnInfo("id", "int", 0);
		JavaFieldGetSet f=createFiledGetSetSRC(ci, new MysqlTypeConvertor());
		System.out.println(f);
	}
}
