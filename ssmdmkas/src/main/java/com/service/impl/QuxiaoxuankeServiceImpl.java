package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.QuxiaoxuankeDao;
import com.entity.QuxiaoxuankeEntity;
import com.service.QuxiaoxuankeService;
import com.entity.vo.QuxiaoxuankeVO;
import com.entity.view.QuxiaoxuankeView;

@Service("quxiaoxuankeService")
public class QuxiaoxuankeServiceImpl extends ServiceImpl<QuxiaoxuankeDao, QuxiaoxuankeEntity> implements QuxiaoxuankeService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QuxiaoxuankeEntity> page = this.selectPage(
                new Query<QuxiaoxuankeEntity>(params).getPage(),
                new EntityWrapper<QuxiaoxuankeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QuxiaoxuankeEntity> wrapper) {
		  Page<QuxiaoxuankeView> page =new Query<QuxiaoxuankeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QuxiaoxuankeVO> selectListVO(Wrapper<QuxiaoxuankeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QuxiaoxuankeVO selectVO(Wrapper<QuxiaoxuankeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QuxiaoxuankeView> selectListView(Wrapper<QuxiaoxuankeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QuxiaoxuankeView selectView(Wrapper<QuxiaoxuankeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
