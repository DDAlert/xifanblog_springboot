package com.chuanhao.blog.entity;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 访问人Ip信息
 */
@Data
public class LogIpRecord implements Serializable {
    private static final long serialVersionUID = 1615958857427733990L;
    private Integer ipRecordId;
    //ip地址
    private String ip;
    //用户 无用户为 visitor
    private String userName;
    //最后一次访问时间
    private Date createTime;
    //访问次数
    private Integer logCount;
}
