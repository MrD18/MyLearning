package com.yss.other.MapStruct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: duhao
 * @date: 2020/12/9 15:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    private String make;
    private int seatCount;
    private String type;
    private String hand;

}
