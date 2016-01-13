package JavaOOP.SocketChat;
import java.io.*;
import java.util.Date;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    public Date date = new Date();
    public String from;
    public String to;
    public boolean isFile;
    public transient String text;
    public transient String path;
    InputStream is;
    OutputStream os;
    byte[] buf;

    @Override
    public String toString() {
        return new StringBuilder()
                .append("[")
                .append(date.toString())
                .append(", From: ")
                .append(from)
                .append(", To: ")
                .append(to)
                .append("] ")
                .append(text)
                .toString();
    }

    public void writeToStream(OutputStream out)
            throws IOException
    {
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bs);
        try {
            os.writeObject(this);

            if ( ! isFile) {
                os.writeUTF(text);
            } else {
                // write file content
                //////////////////////////////////////////////////
                int n;
                while ((n = is.read(buf)) > 0)
                    os.write(buf, 0, n);
                os.flush();
                os.close();
                is.close();

            }
            //////////////////////////////////////////////////////
        } finally {
            os.flush();
            os.close();
        }

        byte[] packet = bs.toByteArray();

        DataOutputStream ds = new DataOutputStream(out);
        ds.writeInt(packet.length);
        ds.write(packet);
        ds.flush();
    }

    public static Message readFromStream(InputStream in)
            throws IOException, ClassNotFoundException
    {
        if (in.available() <= 0)
            return null;

        DataInputStream ds = new DataInputStream(in);
        int len = ds.readInt();
        byte[] packet = new byte[len];
        ds.read(packet);

        ByteArrayInputStream bs = new ByteArrayInputStream(packet);
        ObjectInputStream os = new ObjectInputStream(bs);
        try {
            Message msg = (Message) os.readObject();
            if ( ! msg.isFile) {
                msg.text = (String) os.readUTF();
            } else {
                // write file content
                //////////////////////////////////////////////////////////
                try {

                    String path = msg.text;
                    InputStream is = new FileInputStream(path);
                    byte[] buf = new byte[4*1024];
                    int n;
                    while ((n = is.read(buf)) > 0)
                        is.read(buf);



                }catch (IOException e){
                    System.out.println(e.getCause().toString());
                }
                ///////////////////////////////////////////////////////////
                byte msgFile = os.readByte();
            }

            return msg;
        } finally {
            os.close();
        }
    }
}