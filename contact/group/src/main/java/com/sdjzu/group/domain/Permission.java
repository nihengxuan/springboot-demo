package com.sdjzu.group.domain;

import lombok.Data;

@Data
public class Permission {
    private Integer id;
    private String name;
    private String path;
    private String comment;
}
