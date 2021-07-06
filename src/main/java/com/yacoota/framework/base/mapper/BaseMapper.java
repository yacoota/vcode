package com.yacoota.framework.base.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 添加类/接口功能描述。
*
* @author WYC
*/
public interface BaseMapper<T, E> {

	/**
	* 添加方法功能描述。
	* 
	* @param example
	* @return
	* @author WYC
	*/
	int countByExample(E example);

	/**
	* 添加方法功能描述。
	* 
	* @param example
	* @return
	* @author WYC
	*/
	int deleteByExample(E example);
	
    /**
    * 添加方法功能描述。
    * 
    * @param record
    * @return
    * @author WYC
    */
    int insert(T record);

	/**
	* 添加方法功能描述。
	* 
	* @param record
	* @return
	* @author WYC
	*/
	int insertSelective(T record);

	/**
	* 添加方法功能描述。
	*
	* @param example
	* @return
	* @author WYC
	*/
	List<T> selectByExample(E example);

    /**
     * 添加方法功能描述。
     *
     * @param example
     * @return
     * @author WYC
     */
    List<T> selectByExampleWithBLOBs(E example);

	/**
	* 添加方法功能描述。
	* 
	* @param record
	* @param example
	* @return
	* @author WYC
	*/
	int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

    /**
     * 添加方法功能描述。
     *
     * @param record
     * @param example
     * @return
     * @author WYC
     */
    int updateByExampleWithBLOBs(@Param("record") T record, @Param("example") E example);
	/**
	* 添加方法功能描述。
	*
	* @param record
	* @param example
	* @return
	* @author WYC
	*/
	int updateByExample(@Param("record") T record, @Param("example") E example);
	
}