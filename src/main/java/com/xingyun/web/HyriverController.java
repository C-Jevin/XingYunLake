package com.xingyun.web;

import com.xingyun.core.Result;
import com.xingyun.core.ResultGenerator;
import com.xingyun.model.Hyriver;
import com.xingyun.service.HyriverService;
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
@Api(value = "河流水文", description = "河流水文相关操作 API", position = 100, protocols = "http")
@RestController
@RequestMapping("XingYunApi/hyriver")
public class HyriverController {
    @Resource
    private HyriverService hyriverService;


    @ApiOperation(
            value = "新增河流水文信息",
            notes = "新增一条河流水文信息",
            produces="application/json",
            consumes="application/json")
    @PostMapping
    public Result add(@RequestBody Hyriver hyriver) {
        hyriverService.save(hyriver);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(
            value = "删除河流水文信息",
            notes = "根据id删除一条河流水文信息",
            produces="application/json",
            consumes="application/json")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        hyriverService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(
            value = "更新河流水文信息",
            notes = "更新一条河流水文信息",
            produces="application/json",
            consumes="application/json")
    @PutMapping
    public Result update(@RequestBody Hyriver hyriver) {
        hyriverService.update(hyriver);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(
            value = "查询河流水文信息",
            notes = "根据id查询河流水文信息",
            produces="application/json",
            consumes="application/json")
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Hyriver hyriver = hyriverService.findById(id);
        return ResultGenerator.genSuccessResult(hyriver);
    }

    @ApiOperation(
            value = "分页查询河流水文信息",
            notes = "分页查询河流水文信息",
            produces="application/json",
            consumes="application/json")
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Hyriver> list = hyriverService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
