package com.huc.boot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/3 15:33
 * @Description:
 */
@ConfigurationProperties(prefix = "web")
@Component
@PropertySource("classpath:/config/my.properties")
public class MyWebConfig {


    private String name;

    private String version;

    private String author;

    private String title;

    private String nick_path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNick_path() {
        return nick_path;
    }

    public void setNick_path(String nick_path) {
        this.nick_path = nick_path;
    }
}
