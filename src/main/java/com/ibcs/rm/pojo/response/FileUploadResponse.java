package com.ibcs.rm.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class FileUploadResponse {

    private String name;

    private String type;

    private String imageUrl;
}
