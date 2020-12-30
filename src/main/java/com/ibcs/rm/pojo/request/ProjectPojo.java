package com.ibcs.rm.pojo.request;

import lombok.Data;

@Data
public class ProjectPojo {
 public long projectId;
 private String name;
 private String description;
 private String fileUrl;
}
