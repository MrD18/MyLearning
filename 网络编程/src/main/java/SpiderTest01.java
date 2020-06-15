import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 网络爬虫的原理
 * 1.获取URL
 * 2. 下载
 * 3. 分析
 * 4. 清洗数据
 * 5. 存储
 */
public class SpiderTest01 {
    public static void main(String[] args) throws Exception {
//        //获取URL
//        URL url = new URL("https://www.jd.com");
//
//        // 下载资源
//        InputStream is = url.openStream();
//         //获取字符流
//        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
//         String msg= null;
//         while ((msg=br.readLine())!=null){
//             System.out.println(msg);
//         }
//         br.close();
//         //分析
//         // 处理

        /**
         * 有可能不让发起
         */
        URL url = new URL("https://www.dianping.com");
        // 下载资源
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
          //模拟浏览器访问
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent"," Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36");
        //获取字符流
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
         String msg= null;
         while ((msg=br.readLine())!=null){
             System.out.println(msg);
         }
         br.close();
         //分析
         // 处理

    }
}
