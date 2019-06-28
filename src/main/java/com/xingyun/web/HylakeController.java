package com.xingyun.web;

import com.xingyun.core.Result;
import com.xingyun.core.ResultGenerator;
import com.xingyun.model.Hylake;
import com.xingyun.service.HylakeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/06/17.
*/
@Api(value = "湖体水文", description = "湖体水文相关操作 API", position = 100, protocols = "http")
@RestController
@RequestMapping(value = "XingYunApi/hylake")
public class HylakeController {
    @Resource
    private HylakeService hylakeService;

    @ApiOperation(
            value = "新增湖体水文信息",
            notes = "新增一条湖体水文信息",
            produces="application/json",
            consumes="application/json")
    @PostMapping
    public Result add(@RequestBody Hylake hylake) {
        hylakeService.save(hylake);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(
            value = "删除湖体水文信息",
            notes = "根据id删除一条湖体水文信息",
            produces="application/json",
            consumes="application/json")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        hylakeService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(
            value = "更新湖体水文信息",
            notes = "更新一条湖体水文信息",
            produces="application/json",
            consumes="application/json")
    @PutMapping
    public Result update(@RequestBody Hylake hylake) {
        hylakeService.update(hylake);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(
            value = "查询湖体水文信息",
            notes = "根据id查询湖体水文信息",
            produces="application/json",
            consumes="application/json")
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Hylake hylake = hylakeService.findById(id);
        return ResultGenerator.genSuccessResult(hylake);
    }

    @ApiOperation(
            value = "分页查询湖体水文信息",
            notes = "分页查询湖体水文信息",
            produces="application/json",
            consumes="application/json")
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Hylake> list = hylakeService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
