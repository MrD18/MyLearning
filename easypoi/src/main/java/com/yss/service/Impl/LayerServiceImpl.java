package com.yss.service.Impl;

import com.yss.dto.Layer;
import com.yss.dto.Layer2;
import com.yss.mapper.LayerMapper;
import com.yss.service.LayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: duhao
 * @date: 2021/4/27 16:34
 */
@Service
@Transactional
public class LayerServiceImpl implements LayerService {

   @Autowired
    private LayerMapper layerMapper;
    @Override
    public int InsertLayer(Layer layer) {
        return layerMapper.insert(layer);
    }


    @Override
    public void InsertLayer2(Layer2 layer2) {
        layerMapper.insert2(layer2);
    }

    @Override
    public void saveAll(List<Layer2> layer2List) {
         layer2List.forEach(layer2 -> {
             layer2.setLayerId(null);// 注意这块, 解析后的id会有数字, 置位null 让数据库自增
             layerMapper.insert2(layer2);
         });
    }


    @Override
    public List<Layer> getList() {

        return   layerMapper.getList();
    }
    @Override
    public List<Layer2> getList2() {
        return   layerMapper.getList2();
    }
}
