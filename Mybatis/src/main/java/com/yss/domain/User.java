package com.yss.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * int,char,double,byte...
 * 建议:包装类型
 * @author: duhao
 * @date: 2020/12/10 9:59
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User {
      private Integer id;
   // private  Integer OBJID;
    private String username;
    private Integer age;

}
