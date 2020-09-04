
package com.example.sysauth.enums;

import com.baomidou.mybatisplus.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum TimeUnitEnum implements IEnum {
  YEAR(0, "年"),
  MONTH(1, "月"),
  DAY(2, "日"),
  HOUR(3, "时"),
  MINUTE(4, "分"),
  SECOND(5, "秒");

  private Integer code;
  private String desc;

  @JsonValue
  public Integer getValue() {
    return this.code;
  }
}
