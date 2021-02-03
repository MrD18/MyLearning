package com.dhao.webservice.entry.oa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: duhao
 * @date: 2021/1/8 19:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attachments {
    private List<Attachment> Attachment;

    public List<Attachment> getAttachment() {
        if (Attachment==null){
            Attachment= new ArrayList<>();
        }
        return  this.Attachment;
    }
}
