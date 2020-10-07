package com.itheima.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Table(name = "tb_express")
public class Express {
    @Id
    //主键回填
    @KeySql(useGeneratedKeys = true)
    private Long id;

    private String content;
    private Timestamp date;
}
