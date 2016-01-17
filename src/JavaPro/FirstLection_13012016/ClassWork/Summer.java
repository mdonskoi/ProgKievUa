package JavaPro.FirstLection_13012016.ClassWork;

/**
 * Created by administrator on 13.01.16.
 */
public class Summer {
    public static int sum(int... x){
        int res = 0;
        for (int i : x){
            res += i;
        }
        return res;
    }


  //  @Test
    public static  boolean testMe(){
        return (sum(1,2,3,4) == 10);
    }
}
