package 何宝杰的写法;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: duhao
 * @date: 2021/2/23 9:46
 */
@Data
@Builder
public class PSPendingTaskBO {
    private  String id;
    //标题
    private String description;
    //发给代办人的日期
    private LocalDateTime recieveTime;
    //sourceEntity
    private  String sourceEntity;
    // sourceId
    private Integer sourceId;
}
