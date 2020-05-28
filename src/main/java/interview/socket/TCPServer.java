package interview.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: chenyawei
 * @Date: 2020-04-14  18:10
 * @Description:
 */
public class TCPServer
{
    public static void main(String[] args) throws IOException {
        //创建socket，并将socket绑定到65000端口
        ServerSocket serverSocket = new ServerSocket(65000);
        //死循环，使得socket一直等待并处理客户端发送过来的请求
        while(true){
            //监听65000端口，直到客户端返回连接信息后才返回
            Socket socket = serverSocket.accept();
            //获取客户端端请求信息后，执行相关业务逻辑
            new LengthCalculator(socket).start();
        }
    }
}
