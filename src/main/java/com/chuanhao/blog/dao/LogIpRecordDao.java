package com.chuanhao.blog.dao;

import com.chuanhao.blog.entity.LogIpRecord;

import java.util.List;

public interface LogIpRecordDao {
    /**
     * 新增
     */
    void insert(LogIpRecord logIpRecord);

    /**
     * 更新
     */
    void update(LogIpRecord logIpRecord);

    /**
     * 查询所有
     */
    List<LogIpRecord> getAll();

    /**
     * 更具ip查询
     */
    List<LogIpRecord> getRecordByIp(String ip);

}
