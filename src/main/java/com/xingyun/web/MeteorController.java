package com.xingyun.web;

import com.xingyun.core.Result;
import com.xingyun.core.ResultGenerator;
import com.xingyun.model.Meteor;
import com.xingyun.service.MeteorService;
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
@Api(value = "气象", description = "气象相关操作 API", position = 100, protocols = "http")
@RestController
@RequestMapping("XingYunApi/meteor")
public class MeteorController {
    @Resource
    private MeteorService meteorService;

    @ApiOperation(
            value = "新增气象信息",
            notes = "新增一条气象信息",
            produces="application/json",
            consumes="application/json")
    @PostMapping
    public Result add(@RequestBody Meteor meteor) {
        meteorService.save(meteor);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(
            value = "删除气象信息",
            notes = "根据id删除气象信息",
            produces="application/json",
            consumes="application/json")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        meteorService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(
            value = "更新气象信息",
            notes = "更新气象信息",
            produces="application/json",
            consumes="application/json")
    @PutMapping
    public Result update(@RequestBody Meteor meteor) {
        meteorService.update(meteor);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(
            value = "查询气象信息",
            notes = "根据id查询气象信息",
            produces="application/json",
            consumes="application/json")
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Meteor meteor = meteorService.findById(id);
        return ResultGenerator.genSuccessResult(meteor);
    }

    @ApiOperation(
            value = "分页查询气象信息",
            notes = "分页查询气象信息",
            produces="application/json",
            consumes="application/json")
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Meteor> list = meteorService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
