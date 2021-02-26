package com.yss.mapconstruct;

import com.yss.entity.bo.AccountBO;
import com.yss.entity.dto.AccountUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author: duhao
 * @date: 2020/12/11 14:25
 */
@Mapper
public interface GetAccountUserCopyPropMapper {
    GetAccountUserCopyPropMapper INSTANCE  =  Mappers.getMapper(GetAccountUserCopyPropMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
          //  @Mapping(target = "username", expression = ""),
       //     @Mapping(target = "age", expression = ""),
    })
    AccountUserDTO accountToAccountUserDto(AccountBO source);
}
