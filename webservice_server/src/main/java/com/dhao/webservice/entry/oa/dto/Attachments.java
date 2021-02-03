package com.dhao.webservice.entry.oa.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: duhao
 * @date: 2021/1/8 19:51
 */
public class Attachments {
    private List<Attachment> attachment;

    public List<Attachment> getAttachment() {
        if (attachment==null){
            attachment= new ArrayList<>();
        }
        return  this.attachment;
    }
}
