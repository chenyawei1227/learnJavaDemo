package interview.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: chenyawei
 * @Date: 2020-04-14  18:09
 * @Description:
 * SOCK_STREAM：表示面向连接的数据传输方式。数据可以准确无误地到达另一台计算机，
 * 如果损坏或丢失，可以重新发送，但效率相对较慢。常见的 http 协议就使用 SOCK_STREAM 传输数据，
 * 因为要确保数据的正确性，否则网页不能正常解析。

 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //创建socket,并指定连接的是本机的端口号为65000的服务器socket
        Socket socket = new Socket("127.0.0.1",65000);
        //获取输出流
        OutputStream os = socket.getOutputStream();
        //获取输入流
        InputStream is = socket.getInputStream();
        //将要传递给server的字符串参数转换成byte数组，并将数组写入到输出流中
        os.write(new String("hello world").getBytes());
        int ch = 0;
        byte[] buff = new byte[1024];
        //buff主要用来读取输入的内容，存成byte数组，ch主要用来读取数组的长度
        ch = is.read(buff);
        //将接收流的byte数组转换字符串，这里是从服务端回发回来的字符串参数的长度
        String content = new String(buff,0,ch);
        System.out.println(content);
        //不要忘记关闭输入输出流以及socket
        is.close();
        os.close();
        socket.close();
    }
}
