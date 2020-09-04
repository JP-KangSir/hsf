package com.example.sysauth.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.sysauth.bean.UcAuthority;
import org.apache.ibatis.annotations.Select;

/**
 * 《扩展Dao操作，由Mybatis Generator插件自动生成，多次生成，不会覆盖》
 * 
 * @author kjp
 * @date 2020-09-02
 */
public interface UcAuthorityDao extends BaseMapper<UcAuthority> {

    @Select("")
    void a();
}