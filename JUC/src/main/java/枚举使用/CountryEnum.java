package 枚举使用;

import lombok.*;


@Getter
public enum CountryEnum {
    ONE(1,"齐国"),TWO(2,"楚国"), THREE(3,"燕国"),
    FOUR(4,"赵国"), FIVE(5,"魏国"), SIX(6,"韩国");

    private Integer retCode;
    private  String retMessage;

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }
    public static String forEach_Enum(int index){
        CountryEnum[] enums = CountryEnum.values();
        for (CountryEnum anEnum : enums) {
            if (index==anEnum.retCode){
                return anEnum.retMessage;
            }

        }

        return null;
    }
}
