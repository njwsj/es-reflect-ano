package com.example.esdemo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


/**
 * 操作日志ES实体类
 */
@Data
@Document(indexName = "#{@environment.getProperty('app.es.indices.operation-logs')}")
@JsonIgnoreProperties(ignoreUnknown = true)
public class OperationLogES {
    @Id
    //@Field(name = "_id", type = FieldType.Keyword)
    private String id;

    @Field(type = FieldType.Long)
    private Long userId;

    @Field(type = FieldType.Text)
    private String operation;

    @Field(type = FieldType.Text)
    private String requestUrl;

    @Field(type = FieldType.Text)
    private String params;

    @Field(type = FieldType.Text)
    private String result;

    @Field(type = FieldType.Integer)
    private Integer success;

    @Field(type = FieldType.Text)
    private String errorMsg;

    @Field(type = FieldType.Long)
    private Long executionTime;

    @Field(type = FieldType.Keyword)
    private String ip;

    @Field(type = FieldType.Date)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Date createTime;

    // 添加一个get方法，返回北京时间（用于前端显示）
    @JsonIgnore // 避免被Jackson序列化
    public String getCreateTimeBeijing() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return sdf.format(this.createTime);
    }
}
