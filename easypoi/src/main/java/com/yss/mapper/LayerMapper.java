package com.yss.mapper;

import com.yss.dto.Layer;
import com.yss.dto.Layer2;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: duhao
 * @date: 2021/4/27 16:35
 */
@Mapper
public interface LayerMapper {
    int insert(Layer layer);

    List<Layer> getList();

    void insert2(Layer2 layer2);

    List<Layer2> getList2();
}
