package com.yss.mapconstruct;

import com.yss.entity.bo.AccountBO;
import com.yss.entity.dto.AccountUserDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-12T10:45:16+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
public class GetAccountUserCopyPropMapperImpl implements GetAccountUserCopyPropMapper {

    @Override
    public AccountUserDTO accountToAccountUserDto(AccountBO source) {
        if ( source == null ) {
            return null;
        }

        AccountUserDTO accountUserDTO = new AccountUserDTO();

        accountUserDTO.setName( source.getName() );
        accountUserDTO.setId( source.getId() );

        return accountUserDTO;
    }
}
