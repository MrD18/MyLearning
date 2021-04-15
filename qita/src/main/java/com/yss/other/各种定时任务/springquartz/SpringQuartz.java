package com.yss.other.各种定时任务.springquartz;

/**多线程
 * 1.quartz是OpenSymphony开源组织在Job scheduling领域的开源项目，是由java开发的一个开源的任务日程管理系统
 * 2.quartz能做什么？
 *    作业调度：调用各种框架的作业脚本，例如shell,hive等。
 *    定时任务：在某一预定的时刻，执行你想要执行的任务。
 *3.quartz包含的主要接口如下：
 *   Scheduler 代表调度容器，一个调度容器中可以注册多个JobDetail和Trigger。
 *   Job 代表工作，即要执行的具体内容。
 *   JobDetail 代表具体的可执行的调度程序，Job是这个可执行程调度程序所要执行的内容。
 *   JobBuilder 用于定义或构建JobDetail实例。
 *   Trigger 代表调度触发器，决定什么时候去调。
 *   TriggerBuilder 用于定义或构建触发器。
 *   JobStore 用于存储作业和任务调度期间的状态。
 *4.优缺点
 * 优点: 默认是多线程异步执行，单个任务时，在上一个调度未完成时，下一个调度时间到时，会另起一个线程开始新的调度，
 *      多个任务之间互不影响。支持复杂的cron表达式，它能被集群实例化，支持分布式部署。
 * 缺点: 相对于spring task实现定时任务成本更高，需要手动配置QuartzJobBean、JobDetail和Trigger等。
 *      需要引入了第三方的quartz包，有一定的学习成本。不支持并行调度，不支持失败处理策略和动态分片的策略等。
 * @author: duhao
 * @date: 2021/4/14 10:37
 */
// 这个类没用, 只是记录,执行的方法在QuartzTestJob
public class SpringQuartz {
}
