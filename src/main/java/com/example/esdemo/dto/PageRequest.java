package com.example.esdemo.dto;

import lombok.Data;

@Data
public class PageRequest {
    //@Schema(description = "当前页", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long current = 1L;

    //@Schema(description = "每页数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Long pageSize = 10L;
}
