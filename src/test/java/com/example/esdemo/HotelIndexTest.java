package com.example.esdemo;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Map;

import static com.example.esdemo.constants.HotelConstants.MAPPING_TEMPLATE;

@SpringBootTest
public class HotelIndexTest {
    private RestHighLevelClient client;
    @Value("${spring.elasticsearch.uris}")
    private String elasticsearchUrl;

    @BeforeEach
    void setUp() {
        this.client = new RestHighLevelClient(RestClient.builder(
                HttpHost.create(elasticsearchUrl)
        ));
    }
    @AfterEach
    void tearDown() throws IOException {
        this.client.close();
    }
    @Test
    void createHotelIndex() throws IOException{
        // 1.创建Request对象
        CreateIndexRequest request = new CreateIndexRequest("hotel");
        // 2.准备请求的参数：DSL语句
        request.source(MAPPING_TEMPLATE, XContentType.JSON);
        // 3.发送请求
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    @Test
    void testSimpleMapping() throws IOException {

    }
}
