package com.dhao.webservice.entry.oa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: duhao
 * @date: 2021/1/8 19:48
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Attachment {

    private  String fileType;
    private  String downloadLink;

}
