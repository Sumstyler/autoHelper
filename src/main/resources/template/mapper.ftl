<?xml version="1.0" encoding="UTF-8"?>  
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.mountain.dao.${daoClassName}">
	<resultMap type="${paramPoClassName}" id="${poClassName}Map">
		<#list poProperties as prop>
			<result property="${prop.name}" column="${prop.columnName}" />
		</#list>
	</resultMap>

	<sql id="Base_Column_List">
		<#list poProperties as prop>
			${prop.columnName}<#if prop_has_next>,</#if> 
		</#list>
	</sql>
	
	<sql id="query_${paramPoClassName}_where">
		<where>
			<#list poProperties as prop>
				<if test="${prop.name} != null and ${prop.name} !=''">and ${prop.columnName} = ${r'#{'}${prop.name}${r'}'}</if>
			</#list>
		</where>
	</sql>

	<select id="selectByPrimaryKey" resultMap="${daoClassName}Map"
		parameterType="java.lang.Long">
		SELECT
		<include refid="Base_Column_List"></include>
		FROM
		${tableName}
		where id = ${r'#{id}'}
	</select>

	<select id="selectByMap" resultMap="${daoClassName}Map" parameterType="java.util.Map">
		SELECT
		<include refid="Base_Column_List"></include>
		FROM
		${tableName}
		<include refid="query_${paramPoClassName}_where"></include>
		<if test="start != null and pageSize != null">limit ${r'#{start}'},${r'#{pageSize}'}</if>
	</select>

	<select id="countByMap" resultType="long" parameterType="java.util.Map">
		SELECT
		count(0)
		FROM
		${tableName}
		<include refid="query_${paramPoClassName}_where"></include>
	</select>

	<delete id="deleteByPrimaryKey" parameterType="java.lang.Long">
		delete from
		${tableName}
		where
		id = ${r'#{id}'}
	</delete>

	<insert id="insert" parameterType="${paramPoClassName}">
		insert into ${tableName} (
		<include refid="Base_Column_List"></include>
		)
		values(
		<#list poProperties as prop>
			${r'#{'}${prop.name}${r'}'}<#if prop_has_next>,</#if> 
		</#list>
		)
	</insert>


	<update id="updateByPrimaryKeySelective" parameterType="${paramPoClassName}">
		update ${tableName}
		<set>
			<#list poProperties as prop>
				<#if prop_index != 0>
					<if test="${prop.name} != null">
				  		${prop.columnName} = ${r'#{'}${prop.name}${r'}'},
					</if>
				</#if>
			</#list>
		</set>
		where id = ${r'#{id}'}
	</update>
</mapper>  