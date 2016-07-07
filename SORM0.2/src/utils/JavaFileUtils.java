package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
 * ��װ��Java�ļ��ģ�Դ���룩���õĲ���
 * @author Admain
 *
 */
public class JavaFileUtils {
	/**
	 * �����ֶ�����java���Ե���Ϣ��varchar username -��private String username;�Լ���Ӧ��set��get��Դ��
	 * @param column
	 * @param convertor
	 * @return java���Ժ�set/get���Ե�Դ��
	 */
	public static JavaFieldGetSet createFiledGetSetSRC(ColumnInfo column,TypeConvertor convertor){
		JavaFieldGetSet jfgs=new JavaFieldGetSet();
		String javaFieldType=convertor.databaseType2JavaType(column.getDataType());
		jfgs.setFieldInfo("\tprivate "+javaFieldType+" "+column.getName()+";\n");
		
		//ƴ��һ��get���ַ��� public String getUsername(){return username;}
		StringBuilder getSrc=new StringBuilder();
		getSrc.append("\tpublic "+javaFieldType+" get"+StringUtils.firstChar2UpperCase(column.getName())+"(){\n");
		getSrc.append("\t\treturn "+column.getName()+";\n");
		getSrc.append("\t}\n");
		jfgs.setGetInfo(getSrc.toString());
		
		//ƴ��һ��set��Դ�� public void setUsername(String userName){return userName};
		StringBuilder setSrc=new StringBuilder();
		setSrc.append("\tpublic void set"+StringUtils.firstChar2UpperCase(column.getName())+"(");
		setSrc.append(javaFieldType+" "+column.getName()+"){\n");
		setSrc.append("\t\tthis."+column.getName()+"="+column.getName()+";\n");
		setSrc.append("\t}\n");
		jfgs.setSetInfo(setSrc.toString());
		return jfgs;
	}
	/**
	 * ���ݱ���Ϣ���ɶ�Ӧ��Java��
	 * @param tbaleInfo ����Ϣ
	 * @param convert	������ת����
	 * @return	java���Դ��
	 */
	public static String createJavaSrc(TableInfo tableInfo,TypeConvertor convert){
		StringBuilder src=new StringBuilder();
		Map<String,ColumnInfo> column=tableInfo.getColumns();
		List<JavaFieldGetSet> javaFields=new ArrayList<>();
		/**
		 * ���ֶ���Ϣ-->java��������Ϣ
		 */
		for(ColumnInfo c: column.values()){
			javaFields.add(createFiledGetSetSRC(c, convert));
		}
		//����package�����
		src.append("package "+DBManager.getConf().getPaPackage()+";\n\n");
		//����import�����
		src.append("import java.sql.*;\n").append("import java.util.*;\n\n");
		//���������������
		src.append("public class "+StringUtils.firstChar2UpperCase(tableInfo.getTname())+"{\n\n");
		//���������б�
		for(JavaFieldGetSet f:javaFields){
			src.append(f.getFieldInfo());
		}
		//����get�����б�
		for(JavaFieldGetSet f:javaFields){
			src.append(f.getGetInfo());
		}
		//����set�����б�
		for(JavaFieldGetSet f:javaFields){
			src.append(f.getSetInfo());
		}
		//�����������
		src.append("}\n");
		return src.toString();
	}
	
	public static void createJavaaPOFile(TableInfo tableInfo,TypeConvertor convert){
		String src=createJavaSrc(tableInfo, convert);
		String srcPath=DBManager.getConf().getSrcPath();
		String poPaclage=DBManager.getConf().getPaPackage().replaceAll("\\.", "/");
		/**
		 * �õ������ļ�·���ĵ�File����
		 */
		File f=new File(srcPath+poPaclage);
		if(!f.exists()){ //���ָ��·��������������û����д���
			f.mkdirs();
		}
		BufferedWriter bw=null;
		try {
			bw=new BufferedWriter(new FileWriter(f.getAbsolutePath()+"/"+StringUtils.firstChar2UpperCase(tableInfo.getTname())+".java"));
			bw.write(src);
			bw.flush();
			/**
			 * ������־�Ĵ�ӡ
			 */
			System.out.println("���ɱ�"+tableInfo.getTname()+"��Ӧ��java�ࣺ"+StringUtils.firstChar2UpperCase(tableInfo.getTname())+".java");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} 
	public static void main(String[] args) {
//		ColumnInfo ci=new ColumnInfo("id", "int", 0);
//		JavaFieldGetSet f=createFiledGetSetSRC(ci, new MysqlTypeConvertor());
//		System.out.println(f);
//		Map<String,TableInfo> map=TableContext.tables;
//		TableInfo t=map.get("emp");
//		createJavaaPOFile(t, new MysqlTypeConvertor());
		/**
		 * ѭ���������еı�
		 */
		Map<String,TableInfo> map=TableContext.tables;
		for(TableInfo tableInfo:map.values()){
			createJavaaPOFile(tableInfo, new MysqlTypeConvertor());
		}
	}
}