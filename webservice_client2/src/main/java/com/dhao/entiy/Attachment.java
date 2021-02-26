package com.dhao.entiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: duhao
 * @date: 2021/1/8 19:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attachment {

    private  String fileType;
    private  String downloadLink;

}
