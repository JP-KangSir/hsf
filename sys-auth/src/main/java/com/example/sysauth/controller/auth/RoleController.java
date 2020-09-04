package com.example.sysauth.controller.auth;

import com.example.sysauth.bean.UcRole;
import com.example.sysauth.bean.dto.UcRoleAddDTO;
import com.example.sysauth.bean.dto.UcRoleListDTO;
import com.example.sysauth.result.Result;
import com.example.sysauth.service.UcRoleService;
import com.example.sysauth.tree.Tree;
import com.example.sysauth.tree.component.TreeComponent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@Api(value = "角色管理",tags = "角色管理API")
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private UcRoleService ucRoleService;

    @ApiOperation("角色树状结构接口")
    @PostMapping("/treeList")
    public Result<List<TreeComponent>> treeList(@RequestBody UcRoleListDTO ucRoleListDTO) {
        Tree tree = ucRoleService.treeList(ucRoleListDTO);
        if(Objects.isNull(tree)){
            return Result.error("未查询到数据结果");
        }
        List<TreeComponent> children = tree.getChildren();
        return Result.ok(children);
    }
    @ApiOperation("角色数据List结构接口")
    @PostMapping("/list")
    public Result<List<UcRole>> list(@RequestBody UcRoleListDTO ucRoleListDTO) {
        //根据用户id获取用户拥有的角色列表
        return Result.ok();
    }


    @ApiOperation("新增角色接口")
    @PostMapping("/add")
    public Result add(@RequestBody UcRoleAddDTO ucRoleAddDTO) {
        //新增角色操作
        //根据传入的权限id，与增角色与权限的绑定数据
        return Result.ok();
    }

    /**
     * 启用、禁用、删除、恢复接口都可使用此接口
     * @param ucRoleAddDTO
     * @return
     */
    @ApiOperation(value = "修改角色接口",notes = "启用、禁用、删除、恢复接口都可使用此接口")
    @PostMapping("/update")
    public Result update(@RequestBody UcRoleAddDTO ucRoleAddDTO) {
        //修改角色操作
        //根据传入的角色id先删除之前的权限与角色绑定数据
        //插入新的角色与权限绑定数据
        return Result.ok();
    }
}
