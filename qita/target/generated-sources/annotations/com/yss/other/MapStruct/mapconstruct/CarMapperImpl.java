package com.yss.other.MapStruct.mapconstruct;

import com.yss.other.MapStruct.Car;
import com.yss.other.MapStruct.CarDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-16T14:15:31+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_141 (Oracle Corporation)"
)
public class CarMapperImpl implements CarMapper {

    @Override
    public CarDTO carToCarDto(Car car) {
        if ( car == null ) {
            return null;
        }

        CarDTO carDTO = new CarDTO();

        carDTO.setSeatCount( car.getNumberOfSeats() );
        carDTO.setMake( car.getMake() );
        if ( car.getType() != null ) {
            carDTO.setType( car.getType().name() );
        }

        return carDTO;
    }
}
