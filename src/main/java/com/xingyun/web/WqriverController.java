package com.xingyun.web;

import com.xingyun.core.Result;
import com.xingyun.core.ResultGenerator;
import com.xingyun.model.Wqriver;
import com.xingyun.service.WqriverService;
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
@Api(value = "河流水质", description = "河流水质相关操作 API", position = 100, protocols = "http")
@RestController
@RequestMapping("XingYunApi/wqriver")
public class WqriverController {
    @Resource
    private WqriverService wqriverService;

    @ApiOperation(
            value = "新增河流水质信息",
            notes = "新增一条河流水质信息",
            produces="application/json",
            consumes="application/json")
    @PostMapping
    public Result add(@RequestBody Wqriver wqriver) {
        wqriverService.save(wqriver);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(
            value = "删除河流水质信息",
            notes = "根据id删除河流水质信息",
            produces="application/json",
            consumes="application/json")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        wqriverService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(
            value = "更新河流水质信息",
            notes = "更新河流水质信息",
            produces="application/json",
            consumes="application/json")
    @PutMapping
    public Result update(@RequestBody Wqriver wqriver) {
        wqriverService.update(wqriver);
        return ResultGenerator.genSuccessResult();
    }
    
    @ApiOperation(
            value = "查询河流水质信息",
            notes = "根据id查询河流水质信息",
            produces="application/json",
            consumes="application/json")
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Wqriver wqriver = wqriverService.findById(id);
        return ResultGenerator.genSuccessResult(wqriver);
    }

    @ApiOperation(
            value = "分页查询河流水质信息",
            notes = "分页查询河流水质信息",
            produces="application/json",
            consumes="application/json")
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Wqriver> list = wqriverService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
