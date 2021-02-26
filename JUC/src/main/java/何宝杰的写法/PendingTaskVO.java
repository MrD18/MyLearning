package 何宝杰的写法;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: duhao
 * @date: 2021/2/23 9:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PendingTaskVO {
    //标题
    private  String title;
    //连接
    private  String link;
    // 发给代办人的日期
    private  String date;
}
