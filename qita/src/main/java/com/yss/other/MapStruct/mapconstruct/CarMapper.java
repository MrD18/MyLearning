package com.yss.other.MapStruct.mapconstruct;

import com.yss.other.MapStruct.Car;
import com.yss.other.MapStruct.CarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author: duhao
 * @date: 2020/12/9 15:08
 */
@Mapper
public interface CarMapper {
    CarMapper INSTANCE =   Mappers.getMapper( CarMapper.class );
  // 将car中的属性值 numberOfSeats 赋值给 seatCount
   @Mapping(source = "numberOfSeats",target = "seatCount")
   @Mapping(target = "hand",  ignore = true)
    CarDTO carToCarDto(Car car);
}


