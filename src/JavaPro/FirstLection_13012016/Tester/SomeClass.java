package JavaPro.FirstLection_13012016.Tester;

public class SomeClass {
	public static long job(long...ls) {
		long res = 0;
		for (long l : ls)
			res += l;
		
		return res;
	}
	
	@Test(a = 2, b = 5)
	public static boolean selfTest() {
		boolean res = job(1, 2, 3, 4) == 10;
		System.out.println("SomeClass: " + res);
		return res;
	}
}
