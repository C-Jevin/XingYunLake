package com.xingyun.web;

import com.xingyun.core.Result;
import com.xingyun.core.ResultGenerator;
import com.xingyun.model.Stationlist;
import com.xingyun.service.StationlistService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/06/17.
*/
@Api(value = "站点列表", description = "站点列表相关操作 API", position = 100, protocols = "http")
@RestController
@RequestMapping("XingYunApi/stationlist")
public class StationlistController {
    @Resource
    private StationlistService stationlistService;

    @ApiOperation(
            value = "新增站点列表信息",
            notes = "新增一条站点列表信息",
            produces="application/json",
            consumes="application/json")
    @PostMapping
    public Result add(@RequestBody Stationlist stationlist) {
        stationlistService.save(stationlist);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(
            value = "删除站点列表信息",
            notes = "根据id删除站点列表信息",
            produces="application/json",
            consumes="application/json")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        stationlistService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(
            value = "更新站点列表信息",
            notes = "更新站点列表信息",
            produces="application/json",
            consumes="application/json")
    @PutMapping
    public Result update(@RequestBody Stationlist stationlist) {
        stationlistService.update(stationlist);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(
            value = "查询站点列表信息",
            notes = "根据id查询站点列表信息",
            produces="application/json",
            consumes="application/json")
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Stationlist stationlist = stationlistService.findById(id);
        return ResultGenerator.genSuccessResult(stationlist);
    }

    @ApiOperation(
            value = "分页查询站点列表信息",
            notes = "分页查询站点列表信息",
            produces="application/json",
            consumes="application/json")
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Stationlist> list = stationlistService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(
            value = "查询站点信息",
            notes = "根据站点名称查询站点信息",
            produces="application/json",
            consumes="application/json")
    @GetMapping("list")
    public Result findByStaNameAndDate(@RequestParam(defaultValue = "",required = false,name = "staName") String staName){
        Condition condition = new Condition(Stationlist.class,false,false);
        Example.Criteria criteria = condition.createCriteria();
        if(StringUtils.isNotBlank(staName)){
            staName = "%" + staName + "%";
        }
        if(StringUtils.isNotBlank(staName)){
            criteria.andLike("staname",staName);
        }
        List<Stationlist> staList = stationlistService.findByCondition(condition);
        return  ResultGenerator.genSuccessResult(staList);
    }


}
