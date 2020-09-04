package com.example.sysauth.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.sysauth.bean.UcRole;
import com.example.sysauth.bean.dto.UcRoleListDTO;
import com.example.sysauth.dao.UcRoleDao;
import com.example.sysauth.service.UcRoleService;
import com.example.sysauth.tree.Tree;
import com.example.sysauth.tree.builder.IComponentBuilder;
import com.example.sysauth.tree.util.TreeUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 《扩展ServiceImpl操作，由Mybatis Generator插件自动生成，多次生成，不会覆盖》
 * 
 * @author kjp
 * @date 2020-09-01
 */
@Service
public class UcRoleServiceImpl extends ServiceImpl<UcRoleDao, UcRole> implements UcRoleService {
    @Override
    public Tree treeList(UcRoleListDTO ucRoleListDTO) {
        //查询所有数据(测试，暂定查所有)
        List<UcRole> ucRoles = this.selectList(new EntityWrapper<>());
        if (ucRoles.isEmpty()){
            return null;
        }
        Tree tree = buildTree(ucRoles);
        TreeUtil.addRoot(tree, "栏目树");
        //reverse(children);
        return tree;
    }

    private Tree buildTree(List<UcRole> ptmColumns) {
        return new Tree().add(new IComponentBuilder<UcRole>() {
            @Override
            public String getId(UcRole ucRole) {
                return ucRole.getId().toString();
            }

            @Override
            public String getPid(UcRole ucRole) {
                return ucRole.getParentId().toString();
            }

            @Override
            public String getName(UcRole ucRole) {
                return ucRole.getName();
            }
        }, ptmColumns);
    }
}