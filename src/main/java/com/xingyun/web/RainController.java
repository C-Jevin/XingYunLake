package com.xingyun.web;

import com.xingyun.core.Result;
import com.xingyun.core.ResultGenerator;
import com.xingyun.model.Rain;
import com.xingyun.service.RainService;
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
@Api(value = "降雨", description = "降雨相关操作 API", position = 100, protocols = "http")
@RestController
@RequestMapping("XingYunApi/rain")
public class RainController {
    @Resource
    private RainService rainService;

    @ApiOperation(
            value = "新增降雨信息",
            notes = "新增一条降雨信息",
            produces="application/json",
            consumes="application/json")
    @PostMapping
    public Result add(@RequestBody Rain rain) {
        rainService.save(rain);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(
            value = "删除降雨信息",
            notes = "根据id删除降雨信息",
            produces="application/json",
            consumes="application/json")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        rainService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(
            value = "更新降雨信息",
            notes = "更新降雨信息",
            produces="application/json",
            consumes="application/json")
    @PutMapping
    public Result update(@RequestBody Rain rain) {
        rainService.update(rain);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(
            value = "查询降雨信息",
            notes = "根据id查询降雨信息",
            produces="application/json",
            consumes="application/json")
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Rain rain = rainService.findById(id);
        return ResultGenerator.genSuccessResult(rain);
    }

    @ApiOperation(
            value = "分页查询降雨信息",
            notes = "分页查询降雨信息",
            produces="application/json",
            consumes="application/json")
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Rain> list = rainService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


}
