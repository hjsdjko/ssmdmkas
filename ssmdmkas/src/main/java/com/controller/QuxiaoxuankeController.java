package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.QuxiaoxuankeEntity;
import com.entity.view.QuxiaoxuankeView;

import com.service.QuxiaoxuankeService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 取消选课
 * 后端接口
 * @author 
 * @email 
 * @date 2022-03-19 09:14:45
 */
@RestController
@RequestMapping("/quxiaoxuanke")
public class QuxiaoxuankeController {
    @Autowired
    private QuxiaoxuankeService quxiaoxuankeService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QuxiaoxuankeEntity quxiaoxuanke, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			quxiaoxuanke.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			quxiaoxuanke.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<QuxiaoxuankeEntity> ew = new EntityWrapper<QuxiaoxuankeEntity>();
		PageUtils page = quxiaoxuankeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quxiaoxuanke), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QuxiaoxuankeEntity quxiaoxuanke, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			quxiaoxuanke.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			quxiaoxuanke.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<QuxiaoxuankeEntity> ew = new EntityWrapper<QuxiaoxuankeEntity>();
		PageUtils page = quxiaoxuankeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quxiaoxuanke), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QuxiaoxuankeEntity quxiaoxuanke){
       	EntityWrapper<QuxiaoxuankeEntity> ew = new EntityWrapper<QuxiaoxuankeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( quxiaoxuanke, "quxiaoxuanke")); 
        return R.ok().put("data", quxiaoxuankeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QuxiaoxuankeEntity quxiaoxuanke){
        EntityWrapper< QuxiaoxuankeEntity> ew = new EntityWrapper< QuxiaoxuankeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( quxiaoxuanke, "quxiaoxuanke")); 
		QuxiaoxuankeView quxiaoxuankeView =  quxiaoxuankeService.selectView(ew);
		return R.ok("查询取消选课成功").put("data", quxiaoxuankeView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QuxiaoxuankeEntity quxiaoxuanke = quxiaoxuankeService.selectById(id);
        return R.ok().put("data", quxiaoxuanke);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QuxiaoxuankeEntity quxiaoxuanke = quxiaoxuankeService.selectById(id);
        return R.ok().put("data", quxiaoxuanke);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QuxiaoxuankeEntity quxiaoxuanke, HttpServletRequest request){
    	quxiaoxuanke.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(quxiaoxuanke);

        quxiaoxuankeService.insert(quxiaoxuanke);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QuxiaoxuankeEntity quxiaoxuanke, HttpServletRequest request){
    	quxiaoxuanke.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(quxiaoxuanke);
    	quxiaoxuanke.setUserid((Long)request.getSession().getAttribute("userId"));

        quxiaoxuankeService.insert(quxiaoxuanke);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody QuxiaoxuankeEntity quxiaoxuanke, HttpServletRequest request){
        //ValidatorUtils.validateEntity(quxiaoxuanke);
        quxiaoxuankeService.updateById(quxiaoxuanke);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        quxiaoxuankeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<QuxiaoxuankeEntity> wrapper = new EntityWrapper<QuxiaoxuankeEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			wrapper.eq("jiaoshigonghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			wrapper.eq("xuehao", (String)request.getSession().getAttribute("username"));
		}

		int count = quxiaoxuankeService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
