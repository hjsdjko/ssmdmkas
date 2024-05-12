package com.dao;

import com.entity.QuxiaoxuankeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QuxiaoxuankeVO;
import com.entity.view.QuxiaoxuankeView;


/**
 * 取消选课
 * 
 * @author 
 * @email 
 * @date 2022-03-19 09:14:45
 */
public interface QuxiaoxuankeDao extends BaseMapper<QuxiaoxuankeEntity> {
	
	List<QuxiaoxuankeVO> selectListVO(@Param("ew") Wrapper<QuxiaoxuankeEntity> wrapper);
	
	QuxiaoxuankeVO selectVO(@Param("ew") Wrapper<QuxiaoxuankeEntity> wrapper);
	
	List<QuxiaoxuankeView> selectListView(@Param("ew") Wrapper<QuxiaoxuankeEntity> wrapper);

	List<QuxiaoxuankeView> selectListView(Pagination page,@Param("ew") Wrapper<QuxiaoxuankeEntity> wrapper);
	
	QuxiaoxuankeView selectView(@Param("ew") Wrapper<QuxiaoxuankeEntity> wrapper);
	

}
