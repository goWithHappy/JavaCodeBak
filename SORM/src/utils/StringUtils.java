package utils;
/**
 * ��װ���ַ��������Ĳ���
 * @author Admain
 *
 */
public class StringUtils {
	public static String firstChar2UpperCase(String src){
		return src.toUpperCase().substring(0, 1)+src.substring(1);
	} 
}
