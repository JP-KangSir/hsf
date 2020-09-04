package com.example.sysauth.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.sysauth.bean.UcRole;
import com.example.sysauth.bean.dto.UcRoleListDTO;
import com.example.sysauth.tree.Tree;

/**
 * 《扩展Service操作，由Mybatis Generator插件自动生成，多次生成，不会覆盖》
 * 
 * @author kjp
 * @date 2020-09-01
 */
public interface UcRoleService extends IService<UcRole> {

    Tree treeList(UcRoleListDTO ucRoleListDTO);
}