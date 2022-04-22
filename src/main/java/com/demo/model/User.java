package com.demo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("t_user")
public class User extends Model<User> {
    /**
     *
     */
    private static final long serialVersionUID = 2L;
    private Long userId;
    private String userName;
    private Integer age;
}
