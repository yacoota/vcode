package com.yacoota.framework.base.service;

import java.util.List;

/**
* 添加类/接口功能描述。
*
* @author WYC
*/
public interface BaseService<R, E> {

	/**
	* 添加方法功能描述。
	* 
	* @param example
	* @return
	* @author WYC
	*/
	List<R> select(E example);

	/**
	* 添加方法功能描述。
	* 
	* @param record
	* @return
	* @author WYC
	*/
	int insert(R record);

	/**
	* 添加方法功能描述。
	* 
	* @param record
	* @param example
	* @return
	* @author WYC
	*/
	int update(R record, E example);

	/**
	* 添加方法功能描述。
	* 
	* @param example
	* @return
	* @author WYC
	*/
	int delete(E example);
	
}
