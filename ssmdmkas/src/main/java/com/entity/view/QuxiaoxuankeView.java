package com.entity.view;

import com.entity.QuxiaoxuankeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 取消选课
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-03-19 09:14:45
 */
@TableName("quxiaoxuanke")
public class QuxiaoxuankeView  extends QuxiaoxuankeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public QuxiaoxuankeView(){
	}
 
 	public QuxiaoxuankeView(QuxiaoxuankeEntity quxiaoxuankeEntity){
 	try {
			BeanUtils.copyProperties(this, quxiaoxuankeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
