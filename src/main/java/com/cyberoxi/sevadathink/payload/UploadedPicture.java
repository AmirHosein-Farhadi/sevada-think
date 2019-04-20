package com.cyberoxi.sevadathink.payload;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
@Setter
@Getter
public class UploadedPicture {

    private String uploadDir;
}
