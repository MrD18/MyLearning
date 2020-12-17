package com.yss.other;

import com.yss.other.MapStruct.Car;
import com.yss.other.MapStruct.CarDTO;
import com.yss.other.MapStruct.CarType;
import com.yss.other.MapStruct.mapconstruct.CarMapper;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author: duhao
 * @date: 2020/12/9 15:16
 * 测试属性转换
 */
public class CarMapperTest {
    @Test
    public  void shouldMapCarToDto(){

        Car car = new Car("Morris", 5, CarType.SEDAN);
        CarDTO carDto = CarMapper.INSTANCE.carToCarDto(car);
        System.out.println(carDto.getHand());

        Assert.assertNotNull(carDto);
        Assert.assertEquals(carDto.getMake(),"Morris");
        Assert.assertEquals(carDto.getSeatCount() ,5);
        Assert.assertEquals(carDto.getType() ,"SEDAN");

    }
}
