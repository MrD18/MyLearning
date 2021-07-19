package com.yss.other.ApacheLang工具包;

import cn.hutool.core.lang.Assert;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.entity.StringEntity;

/**
 * @Author: dhao
 * @Date: 2021/5/31 9:51 上午
 */
public class StringEscapeUtilsDemo {

    public static void main(String[] args) {

        String sql="SELECT \n" +
                "    view_1.\"_cw_raw_time\",\n" +
                "    view_1.\"_cw_biz\",\n" +
                "    view_1.\"_cw_trace_id\",\n" +
                "    view_1.\"_cw_span_id\",\n" +
                "    view_1.\"_cw_parent_span_id\",\n" +
                "    view_1.\"_cw_message\",\n" +
                "    view_1.\"_cw_collect_time\",\n" +
                "    view_1.\"_cw_collect_id\",\n" +
                "    view_1.\"_cw_collect_type\",\n" +
                "    view_1.\"_cw_log_tag\",\n" +
                "    view_1.\"_cw_hostname\",\n" +
                "    view_1.\"_cw_log_path\",\n" +
                "    view_1.\"_cw_line_num\",\n" +
                "    view_1.\"_cw_span_start_time\",\n" +
                "    view_1.\"_cw_span_end_time\",\n" +
                "    view_1.\"_cw_span_duration\",\n" +
                "    view_1.\"_cw_service_id\",\n" +
                "    view_1.\"_cw_service_name\",\n" +
                "    view_1.\"_cw_service_type\",\n" +
                "    view_1.\"_cw_service_level\",\n" +
                "    view_1.\"_cw_service_caller_id\",\n" +
                "    view_1.\"_cw_service_caller_level\",\n" +
                "    view_1.\"_cw_interface_id\",\n" +
                "    view_1.\"_cw_interface_name\",\n" +
                "    view_1.\"_cw_method\",\n" +
                "    view_1.\"_cw_host_ip\",\n" +
                "    view_1.\"_cw_status_code\",\n" +
                "    view_1.\"_cw_status_message\",\n" +
                "    view_1.\"_cw_pod_name\",\n" +
                "    view_1.\"_cw_log_type\",\n" +
                "    view_1.\"_cw_app\",\n" +
                "    view_1.\"_cw_cluster\",\n" +
                "    view_1.\"_cw_instance_id\",\n" +
                "    view_1.\"_cw_instance_name\",\n" +
                "    view_1.\"_cw_instance_port\",\n" +
                "    view_1.\"_cw_instance_type\",\n" +
                "    view_1.\"_cw_url\",\n" +
                "    view_1.\"_cw_latency\",\n" +
                "    view_1.\"_cw_is_error\" \n" +
                "FROM \"stream\".lareina.rabbit \n" +
                "AS view_1";

        String unescapeCsvSql = StringEscapeUtils.unescapeCsv(sql);
        System.out.println("原有sql："+sql);
        System.out.println("unescapeCsvSql："+unescapeCsvSql);
    }
}
