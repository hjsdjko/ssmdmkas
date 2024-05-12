package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QuxiaoxuankeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QuxiaoxuankeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QuxiaoxuankeView;


/**
 * 取消选课
 *
 * @author 
 * @email 
 * @date 2022-03-19 09:14:45
 */
public interface QuxiaoxuankeService extends IService<QuxiaoxuankeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QuxiaoxuankeVO> selectListVO(Wrapper<QuxiaoxuankeEntity> wrapper);
   	
   	QuxiaoxuankeVO selectVO(@Param("ew") Wrapper<QuxiaoxuankeEntity> wrapper);
   	
   	List<QuxiaoxuankeView> selectListView(Wrapper<QuxiaoxuankeEntity> wrapper);
   	
   	QuxiaoxuankeView selectView(@Param("ew") Wrapper<QuxiaoxuankeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QuxiaoxuankeEntity> wrapper);
   	

}

