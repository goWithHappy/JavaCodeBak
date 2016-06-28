package MysqlUtils;

import java.util.Scanner;

public class JiSuan {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in); 
		double e=in.nextDouble();
		double ans;
		ans=(90*90-e*e)/(4*90);
		System.out.println(ans);
	}
}
