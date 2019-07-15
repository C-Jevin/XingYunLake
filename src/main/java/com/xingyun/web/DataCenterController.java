package com.xingyun.web;

import com.xingyun.core.Result;
import com.xingyun.core.ResultGenerator;
import com.xingyun.model.*;
import com.xingyun.service.*;
import com.xingyun.util.AverageDateUtil;
import com.xingyun.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api(value = "数据中心", description = "数据中心相关操作 API", position = 100, protocols = "http")
@RestController
@RequestMapping("XingYunApi/dataCenter")
public class DataCenterController {

    @Resource
    private StationlistService stationlistService;
    @Resource
    private HylakeService hylakeService;
    @Resource
    private HyriverService hyriverService;
    @Resource
    private MeteorService meteorService;
    @Resource
    private RainService rainService;
    @Resource
    private WqlakeService wqlakeService;
    @Resource
    private WqriverService wqriverService;

    @ApiOperation(
            value = "计算站点数据平均值信息",
            notes = "根据站点id和时间计算站点数据平均值",
            produces="application/json",
            consumes="application/json")
    @PostMapping("/averDate")
    public Result averDataBy(@RequestBody @ApiParam(name="查询条件",value="传入json格式",required=true)SearchCond searchCond){
        Date sDate = null;
        Date eDate = null;
        List<String> dateList = null;

        try {
            if(searchCond.getSiteId().size()==0){
                throw new NullPointerException("站点ID不能为空！");
            }
            if(searchCond.getCondition().equals("")){
                throw new NullPointerException("计算条件不能为空！");
            }
            String cond = searchCond.getCondition();

            //根据ids查询stationList获取对应的表名
            Condition condition = new Condition(Stationlist.class,false,false);
            Example.Criteria criteria = condition.createCriteria();
            criteria.andIn("staid",searchCond.getSiteId());
            List<Stationlist> staList = stationlistService.findByCondition(condition);
            //判空
            if(!searchCond.getStartTime().equals("") && !searchCond.getEndTime().equals("")){
                sDate = DateUtil.getDateFromStr(searchCond.getStartTime(), "yyyy-MM-dd");
                eDate = DateUtil.getDateFromStr(searchCond.getEndTime(), "yyyy-MM-dd");
                //判断时间大小以及 其他条件判空
                if(eDate.before(sDate)){
                    throw new Exception("开始时间不能小于结束时间！");
                }else {
                    dateList = AverageDateUtil.splitDate(searchCond);
                    System.err.println("时间范围：" + dateList.toString());
                }
            }

            //根据表名、dt时间范围、staid查询对应的平均值
            Condition condition2 ;
            List<Object> resList = new ArrayList<>();
            for (Stationlist stl : staList) {
                String tbName = stl.getDatatable();
                String siteId = stl.getStaid();
                System.err.println("=========="+stl.toString());
                if (tbName.equals("hylake")){
                    condition2 = new Condition(Hylake.class);
                    Example.Criteria criteria2 = condition2.createCriteria();
                    criteria2.andEqualTo("staid",siteId);
                    if(searchCond.getStartTime().equals("")||searchCond.getEndTime().equals("")) {
                        criteria2.andBetween("dt", stl.getStartdt(), stl.getEnddt());
                        SearchCond sc = new SearchCond();
                        sc.setCondition(cond);
                        System.err.println("表时间："+stl.getStartdt()+"----"+stl.getEnddt());
                        sc.setStartTime(DateUtil.getStrFromDate(stl.getStartdt(),"yyyy-MM-dd"));
                        sc.setEndTime(DateUtil.getStrFromDate(stl.getEnddt(),"yyyy-MM-dd"));
                        System.err.println("转化后："+sc.getStartTime()+"----"+sc.getEndTime());
                        dateList = AverageDateUtil.splitDate(sc);
                        System.err.println("时间范围：" + dateList.toString());
                    } else{
                        criteria2.andBetween("dt",searchCond.getStartTime(),searchCond.getEndTime());
                    }
                    //criteria2.andIn("dt",dateList);
                    List<Hylake> hylakeList = hylakeService.findByCondition(condition2);
                    List<Hylake> resHyLake = hylakeService.averDate(hylakeList,dateList, cond);
                    resList.add(resHyLake);
                }else if (tbName.equals("hyriver")){
                    condition2 = new Condition(Hyriver.class);
                    Example.Criteria criteria2 = condition2.createCriteria();
                    criteria2.andEqualTo("staid",siteId);
                    if(searchCond.getStartTime().equals("")||searchCond.getEndTime().equals("")) {
                        criteria2.andBetween("dt", stl.getStartdt(), stl.getEnddt());
                        SearchCond sc = new SearchCond();
                        sc.setCondition(cond);
                        sc.setStartTime(DateUtil.getStrFromDate(stl.getStartdt(),"yyyy-MM-dd"));
                        sc.setEndTime(DateUtil.getStrFromDate(stl.getEnddt(),"yyyy-MM-dd"));
                        dateList = AverageDateUtil.splitDate(sc);

                    } else{
                        criteria2.andBetween("dt",searchCond.getStartTime(),searchCond.getEndTime());
                    }
                    List<Hyriver> hyriverList = hyriverService.findByCondition(condition2);
                    List<Hyriver> resHyRiver = hyriverService.averDate(hyriverList,dateList, cond);
                    resList.add(resHyRiver);
                }else if (tbName.equals("meteor")){
                    condition2 = new Condition(Meteor.class);
                    Example.Criteria criteria2 = condition2.createCriteria();
                    criteria2.andEqualTo("staid",siteId);
                    if(searchCond.getStartTime().equals("")||searchCond.getEndTime().equals("")) {
                        criteria2.andBetween("dt", stl.getStartdt(), stl.getEnddt());
                        SearchCond sc = new SearchCond();
                        sc.setCondition(cond);
                        sc.setStartTime(DateUtil.getStrFromDate(stl.getStartdt(),"yyyy-MM-dd"));
                        sc.setEndTime(DateUtil.getStrFromDate(stl.getEnddt(),"yyyy-MM-dd"));
                        dateList = AverageDateUtil.splitDate(sc);
                    } else{
                        criteria2.andBetween("dt",searchCond.getStartTime(),searchCond.getEndTime());
                    }
                    List<Meteor> meteorList = meteorService.findByCondition(condition2);
                    List<Meteor> resMeteor = meteorService.averDate(meteorList,dateList, cond);
                    resList.add(resMeteor);
                }else if (tbName.equals("rain")){
                    condition2 = new Condition(Rain.class);
                    Example.Criteria criteria2 = condition2.createCriteria();
                    criteria2.andEqualTo("staid",siteId);
                    if(searchCond.getStartTime().equals("")||searchCond.getEndTime().equals("")) {
                        criteria2.andBetween("dt", stl.getStartdt(), stl.getEnddt());
                        SearchCond sc = new SearchCond();
                        sc.setCondition(cond);
                        sc.setStartTime(DateUtil.getStrFromDate(stl.getStartdt(),"yyyy-MM-dd"));
                        sc.setEndTime(DateUtil.getStrFromDate(stl.getEnddt(),"yyyy-MM-dd"));
                        dateList = AverageDateUtil.splitDate(sc);
                    } else{
                        criteria2.andBetween("dt",searchCond.getStartTime(),searchCond.getEndTime());
                    }
                    List<Rain> rainList = rainService.findByCondition(condition2);
                    List<Rain> resRain = rainService.averDate(rainList,dateList, cond);
                    resList.add(resRain);
                }else if (tbName.equals("wqlake")){
                    condition2 = new Condition(Wqlake.class);
                    Example.Criteria criteria2 = condition2.createCriteria();
                    criteria2.andEqualTo("staid",siteId);
                    if(searchCond.getStartTime().equals("")||searchCond.getEndTime().equals("")) {
                        System.err.println("表时间="+stl.getStartdt()+stl.getEnddt());
                        criteria2.andBetween("dt", stl.getStartdt(), stl.getEnddt());
                        SearchCond sc = new SearchCond();
                        sc.setCondition(cond);
                        sc.setStartTime(DateUtil.getStrFromDate(stl.getStartdt(),"yyyy-MM-dd"));
                        sc.setEndTime(DateUtil.getStrFromDate(stl.getEnddt(),"yyyy-MM-dd"));
                        dateList = AverageDateUtil.splitDate(sc);
                    } else{
                        criteria2.andBetween("dt",searchCond.getStartTime(),searchCond.getEndTime());
                    }
                    List<Wqlake> wqlakeList = wqlakeService.findByCondition(condition2);
                    List<Wqlake> resWqlake = wqlakeService.averDate(wqlakeList,dateList, cond);
                    resList.add(resWqlake);
                }else if (tbName.equals("wqriver")){
                    condition2 = new Condition(Wqriver.class);
                    Example.Criteria criteria2 = condition2.createCriteria();
                    criteria2.andEqualTo("staid",siteId);
                    if(searchCond.getStartTime().equals("")||searchCond.getEndTime().equals("")) {
                        criteria2.andBetween("dt", stl.getStartdt(), stl.getEnddt());
                        SearchCond sc = new SearchCond();
                        sc.setCondition(cond);
                        sc.setStartTime(DateUtil.getStrFromDate(stl.getStartdt(),"yyyy-MM-dd"));
                        sc.setEndTime(DateUtil.getStrFromDate(stl.getEnddt(),"yyyy-MM-dd"));
                        dateList = AverageDateUtil.splitDate(sc);
                    } else{
                        criteria2.andBetween("dt",searchCond.getStartTime(),searchCond.getEndTime());
                    }
                    List<Wqriver> wqriverList = wqriverService.findByCondition(condition2);
                    List<Wqriver> resWqriver = wqriverService.averDate(wqriverList,dateList, cond);
                    resList.add(resWqriver);
                }

            }
            return ResultGenerator.genSuccessResult(resList);
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @ApiOperation(
            value = "查询降雨信息(rain)",
            notes = "根据雨量范围查询",
            produces="application/json",
            consumes="application/json")
    @GetMapping("/prepOfRain")
    public Result prepOfRain(@RequestParam(required = true,defaultValue = "xy")String rainType){
        List<Rain> rainList = rainService.findByPrepAndDt(rainType);
        return ResultGenerator.genSuccessResult(rainList);
    }

    @ApiOperation(
            value = "查询降雨信息(meteor)",
            notes = "根据雨量范围查询",
            produces="application/json",
            consumes="application/json")
    @GetMapping("/prepOfMeteor")
    public Result prepOfMeteor(@RequestParam(required = true,defaultValue = "xy")String rainType){
        List<Meteor> meteorList = meteorService.findByPrepAndDt(rainType);
        return ResultGenerator.genSuccessResult(meteorList);
    }

    @ApiOperation(
            value = "查询入湖河流水质信息",
            notes = "根据条件查询",
            produces="application/json",
            consumes="application/json")
    @GetMapping("/wqOfRiver")
    public Result wqOfRiver(@RequestParam(required = true,defaultValue = "DOX")String cond ,
                            @RequestParam(required = true,defaultValue = "1")int type ){
        List<Wqriver> resList = wqriverService.findByCond(cond,type);
        return ResultGenerator.genSuccessResult(resList);
    }

    @ApiOperation(
            value = "查询湖体水质信息",
            notes = "根据条件查询",
            produces="application/json",
            consumes="application/json")
    @GetMapping("/wqOfLake")
    public Result wqOfLake(@RequestParam(required = true,defaultValue = "DOX")String cond ,
                           @RequestParam(required = true,defaultValue = "1")int type){
        List<Wqlake> resList = wqlakeService.findByCond(cond,type);
        return ResultGenerator.genSuccessResult(resList);
    }

    @ApiOperation(
            value = "查询水文信息",
            notes = "根据条件查询",
            produces="application/json",
            consumes="application/json")
    @GetMapping("/hydrology")
    public Result hyOfLakeAndRiver(){

        return null;
    }
}
