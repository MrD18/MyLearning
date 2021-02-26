package 何宝杰的写法;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: duhao
 * @date: 2021/2/23 9:52
 */
@Slf4j
public class Demo {
    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        List<PSPendingTaskBO> taskBOList = new ArrayList<>();
        // 挡板数据
        PSPendingTaskBO taskBO = PSPendingTaskBO.builder()
                                       .id("11000412")
                                       .description("关于测试何宝杰的写法...")
                                       .recieveTime( localDateTime)
                                       .sourceEntity("Wf_Examp...")
                                        .sourceId(10002375)
                                        .build();
        // 添加到这个集合中
              taskBOList.add(null);
        // 前端需要展示的VOList
        List<PendingTaskVO> finalTaskList = new ArrayList<>();
        // 判断获取的集合是否为空
        Optional.ofNullable(taskBOList).orElseGet(
                ()->{
                    log.error("代办列表为空");
                    return new ArrayList<>();
                }).forEach(task->{
                    //使用λ 获取参数
            String taskId = task.getId();
            Integer sourceId = task.getSourceId();
            String sourceEntity = task.getSourceEntity();
            // 可以将这些参数用于其他
            // xxxService.getxxx(taskId,sourceId,sourceEntity)
              PendingTaskVO taskVO =  PendingTaskVO.builder()
                         .title(task.getDescription())
                         .date(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS")))
                         .link("http://xxxxxx")
                          .build();
            finalTaskList.add(taskVO);
        });
        System.out.println(taskBOList);
        System.out.println(finalTaskList);

    }
}
