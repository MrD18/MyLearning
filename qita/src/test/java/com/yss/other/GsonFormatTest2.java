package com.yss.other;

import java.util.List;

/**
 * @author: duhao
 * @date: 2020/8/13 10:40
 */
public class GsonFormatTest2 {
    /**
     * count : 49416
     * code : 0
     * msg : null
     * data : [{"date":"2017-09-20","uv":41,"datatype":"mon","shopid":0,"id":5,"aid":289714}]
     */

    private int count;
    private int code;
    private Object msg;
    private List<DataBean> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * date : 2017-09-20
         * uv : 41
         * datatype : mon
         * shopid : 0
         * id : 5
         * aid : 289714
         */

        private String date;
        private int uv;
        private String datatype;
        private int shopid;
        private int id;
        private int aid;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getUv() {
            return uv;
        }

        public void setUv(int uv) {
            this.uv = uv;
        }

        public String getDatatype() {
            return datatype;
        }

        public void setDatatype(String datatype) {
            this.datatype = datatype;
        }

        public int getShopid() {
            return shopid;
        }

        public void setShopid(int shopid) {
            this.shopid = shopid;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAid() {
            return aid;
        }

        public void setAid(int aid) {
            this.aid = aid;
        }
    }
}
