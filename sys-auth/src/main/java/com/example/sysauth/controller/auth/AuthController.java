package com.example.sysauth.controller.auth;

import com.example.sysauth.bean.UcAuthority;
import com.example.sysauth.bean.dto.UcAuthorityAddDTO;
import com.example.sysauth.bean.dto.UcAuthorityListDTO;
import com.example.sysauth.result.Result;
import com.example.sysauth.tree.component.TreeComponent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "菜单管理",tags = "菜单管理API")
@RequestMapping("/auth")
public class AuthController {

    @ApiOperation("菜单数据树状接口")
    @PostMapping("/treeList")
    public Result<List<TreeComponent>> test(@RequestBody UcAuthorityListDTO authTreeDTO) {
        //查询菜单数据树状结构数据
        return Result.ok();
    }

    @ApiOperation("菜单数据List接口")
    @PostMapping("/list")
    public Result<List<UcAuthority>> list(@RequestBody UcAuthorityListDTO authTreeDTO) {
        //根据条件获取菜单数据List
        return Result.ok();
    }

    @ApiOperation("获取指定用户的菜单权限列表接口")
    @PostMapping("/listByUserId")
    public Result<List<UcAuthority>> listByUserId(@RequestBody UcAuthorityListDTO authTreeDTO) {
        //根据userId获取角色List数据
        //根据角色List数据获取拥有的菜单权限列表
        return Result.ok();
    }

    @ApiOperation("新增菜单接口")
    @PostMapping("/add")
    public Result add(@RequestBody UcAuthorityAddDTO authAddDTO) {
        //新增菜单操作
        return Result.ok();
    }

    /**
     * 启用、禁用、删除、恢复接口都可使用此接口
     * @param authUpdateDTO
     * @return
     */
    @ApiOperation(value = "修改菜单接口",notes = "启用、禁用、删除、恢复接口都可使用此接口")
    @PostMapping("/update")
    public Result update(@RequestBody UcAuthorityAddDTO authUpdateDTO) {
        //修改角色操作
        return Result.ok();
    }
}
