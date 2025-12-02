package com.example.esdemo.dto;

import com.example.esdemo.entity.OperationLogES;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
public class OperationLogDTO {

    @Data
    @EqualsAndHashCode(callSuper = true)
    //@Schema(description = "操作日志查询条件")
    public static class QueryOperationLog extends PageRequest {
        //@Schema(description = "用户ID")
        private Long userId;

        //@Schema(description = "操作描述模糊查询")
        private String operation;

        //@Schema(description = "请求URL模糊查询")
        private String requestUrl;

        //@Schema(description = "是否成功：0-失败，1-成功")
        private Integer success;

        //@Schema(description = "IP地址")
        private String ip;

        //@Schema(description = "开始时间(yyyy-MM-dd HH:mm:ss)", example = "2023-01-01 00:00:00")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date startTime;

        //@Schema(description = "结束时间(yyyy-MM-dd HH:mm:ss)", example = "2023-12-31 23:59:59")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date endTime;
    }

    @Data
    //@Schema(description = "操作日志返回结果")
    public static class ResponseOperationLog {
        //@Schema(description = "日志ID", example = "65a8f5e3d5b1a23e8c7b4321")
        private String id;

        //@Schema(description = "用户ID", example = "1234567890")
        private Long userId;

        //@Schema(description = "操作描述")
        private String operation;

        //@Schema(description = "请求URL")
        private String requestUrl;

        //@Schema(description = "请求参数")
        private String params;

        //@Schema(description = "返回结果")
        private String result;

        //@Schema(description = "是否成功：0_失败，1_成功")
        private Integer success;

        //@Schema(description = "错误信息")
        private String errorMsg;

        //@Schema(description = "执行耗时(ms)")
        private Long executionTime;

        //@Schema(description = "请求IP")
        private String ip;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
        //@Schema(description = "创建时间（北京时间）")
        private String createTime;

        public ResponseOperationLog(OperationLogES es) {
            this.id = es.getId();
            this.userId = es.getUserId();
            this.operation = es.getOperation();
            this.requestUrl = es.getRequestUrl();
            this.params = es.getParams();
            this.result = es.getResult();
            this.success = es.getSuccess();
            this.errorMsg = es.getErrorMsg();
            this.executionTime = es.getExecutionTime();
            this.ip = es.getIp();
            this.createTime = es.getCreateTimeBeijing();
        }
    }
}