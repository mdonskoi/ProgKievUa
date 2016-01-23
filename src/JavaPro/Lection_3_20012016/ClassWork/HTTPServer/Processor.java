package JavaPro.Lection_3_20012016.ClassWork.HTTPServer;

import java.util.List;

public interface Processor {
    byte[] process(byte[] data, List<String> headers);
}