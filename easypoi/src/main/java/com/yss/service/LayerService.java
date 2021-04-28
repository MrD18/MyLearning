package com.yss.service;

import com.yss.dto.Layer;
import com.yss.dto.Layer2;

import java.util.List;

/**
 * @author: duhao
 * @date: 2021/4/27 16:33
 */
public interface LayerService {
    int InsertLayer(Layer layer);

    List<Layer> getList();

    void InsertLayer2(Layer2 layer2);
  // 解析完后会是一个list
    void saveAll(List<Layer2> layer2List);

    List<Layer2> getList2();
}
