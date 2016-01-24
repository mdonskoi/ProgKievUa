package JavaPro.Lection_3_20012016.HomeWork.HTTPServer;

/**
 * Created by administrator on 23.01.16.
 */
public class CacheChecker {
    public byte[] data;
    private long timeStamp;
    private long lifeTime;


    public CacheChecker(byte[] data, long lifeTime) {
        this.data = data;
        this.lifeTime = lifeTime;
        this.timeStamp = System.currentTimeMillis();
    }

    public boolean isTimeToKill() {
        System.out.println("Cache lifetime " + (System.currentTimeMillis() - timeStamp));
        return (System.currentTimeMillis() - timeStamp) >= lifeTime;
    }
}
