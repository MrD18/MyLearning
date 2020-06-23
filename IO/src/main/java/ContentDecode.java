import java.io.UnsupportedEncodingException;

/**字节-->字符 解码
 * 字符-->字节 编码
 * @author: duhao
 * @date: 2020/6/23 21:53
 */
public class ContentDecode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg="姓名生命使命";
        //编码
        byte[] datas = msg.getBytes();// 默认使用工程的字符集
        // 解码  字符串(byte[] bytes,int ofset,int length,String charsetName)
        msg  = new String(datas,0,datas.length);
        System.out.println(msg);

        //乱码
        //1) 字节数不够
        msg  = new String(datas,0,datas.length-1);
        System.out.println(msg);//  姓名生命使�
        //字符集不统一
        msg  = new String(datas,0,datas.length,"GBK"); // 之前默认是utf-8, 现在制指定的是GBK
        System.out.println(msg);// 濮撳悕鐢熷懡浣垮懡   出现乱码情况


    }
}
