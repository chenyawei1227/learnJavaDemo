package interview.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: chenyawei
 * @Date: 2020-04-14  18:16
 * @Description:
 */
public class LengthCalculator extends Thread {
    //以socket为成员变量
    private Socket socket;

    public LengthCalculator(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try {
            //获取socket端输出流
            OutputStream os = socket.getOutputStream();
            //获取socket端输入流
            InputStream is = socket.getInputStream();
            int ch = 0;
            byte[] buff = new byte[1024];
            //buff主要用来读取输入端内容，存成byte数组，ch主要用来获取读取数组的长度
            ch = is.read(buff);
            //将接收流的byte数组转换成字符串，这里获取的主要内容是客户端发送过来的字符串
            String content = new String(buff,0,ch);
            System.out.println(content);
            //往输出流里写入获得的字符串的长度，回发给客户端
            os.write(String.valueOf(content.length()).getBytes());
            //关闭流及socket
            is.close();
            os.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
