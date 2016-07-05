package utils;
/**
 * 封装了字符串常见的操作
 * @author Admain
 *
 */
public class StringUtils {
	public static String firstChar2UpperCase(String src){
		return src.toUpperCase().substring(0, 1)+src.substring(1);
	} 
}
