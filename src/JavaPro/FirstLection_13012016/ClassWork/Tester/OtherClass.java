package JavaPro.FirstLection_13012016.ClassWork.Tester;

import JavaPro.FirstLection_13012016.ClassWork.Test;

public class OtherClass {

	public static String work(String... ls) {
		StringBuilder sb = new StringBuilder();
		for (String s : ls)
			sb.append(s);
		
		return sb.toString();
	}
	
	@Test(a = 2, b = 5)
	public static boolean testMethod() {
		boolean res = work("1", "22", "333").equals("122333");
		System.out.println("OtherClass: " + res);
		return res;
	}
}