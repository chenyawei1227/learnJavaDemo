package interview.socket;

import java.io.IOException;
import java.net.*;

/**
 * @Author: chenyawei
 * @Date: 2020-04-14  18:10
 * @Description:
 * SOCK_DGRAM：表示无连接的数据传输方式。计算机只管传输数据，不作数据校验，
 * 如果数据在传输中损坏，或者没有到达另一台计算机，是没有办法补救的。也就是说，数据错了就错了，
 * 无法重传。因为 SOCK_DGRAM 所做的校验工作少，所以效率比 SOCK_STREAM 高。
 *
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
        //客户端发送数据给服务端
        DatagramSocket socket = new DatagramSocket();
        //要发送给服务端端的数据
        byte[] buf = "hello world".getBytes();
        //将IP地址封装成InetAddress对象
        InetAddress address = InetAddress.getByName("127.0.0.1");
        //将要发送给服务端的数据封装成DatagramPacket对象，需要填写ip地址与端口号
        DatagramPacket packet = new DatagramPacket(buf,buf.length,address,65001);
        //发送数据给服务端
        socket.send(packet);

        //客户端接受服务端发送过来的数据报
        byte[] data = new byte[100];

        //创建DatagramPacket对象用来存储服务端发送过来的数据
        DatagramPacket receivedPacket = new DatagramPacket(data,data.length);
        //将接受到的数据存储到DatagramPacket对象中
        socket.receive(receivedPacket);
        //将服务端发送过来的数据取出来并打印到控制台
        String content = new String(receivedPacket.getData(),0,receivedPacket.getLength());
        System.out.println(content);
    }
}
