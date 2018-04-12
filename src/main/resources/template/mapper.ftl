<?xml version="1.0" encoding="UTF-8"?>  
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.mountain.springboot.dao.${daoClassName}">
	<resultMap type="${paramDaoClassName}" id="${daoClassName}Map">
		<#list poProperties as prop>
			<result column="id" property="id" />
			private ${prop.type} ${prop.name};
		</#list>
		<result column="id" property="id" />
		<result column="appId" property="appid" />
		<result column="appSecret" property="appsecret" />
		<result column="tel" property="tel" />
		<result column="contact_person" property="contactPerson" />
		<result column="province" property="province" />
		<result column="city" property="city" />
		<result column="address" property="address" />
		<result column="remark" property="remark" />
		<result column="default_chainId" property="defaultChainid" />
		<result column="valid" property="valid" />
		<result column="Creater" property="creater" />
		<result column="CreateTime" property="createtime" />
		<result column="Updater" property="updater" />
		<result column="UpdateTime" property="updatetime" />
		<!-- 新增一下两个属性 来源于lj_sys_user表 -->
		<result column="name" property="name" />
		<result column="username" property="username" />
	</resultMap>


	<sql id="Base_Column_List">
		id,
		appId,
		appSecret,
		tel,
		contact_person,
		province,
		city,
		address,
		remark,
		default_chainId,
		valid,
		Creater,
		CreateTime,
		Updater,
		UpdateTime
	</sql>
	<sql id="query_ljAgency_where">
		<where>
			<if test="id != null and id !=''">and id = #{id}</if>
			<if test="appid != null and appid !=''">and appId = #{appid}</if>
			<if test="appsecret != null and appsecret !=''">and appSecret = #{appsecret}</if>
			<if test="tel != null and tel !=''">and tel = #{tel}</if>
			<if test="contactPerson != null and contactPerson !=''">and contact_person = #{contactPerson}</if>
			<if test="province != null and province !=''">and province = #{province}</if>
			<if test="city != null and city !=''">and city = #{city}</if>
			<if test="address != null and address !=''">and address = #{address}</if>
			<if test="remark != null and remark !=''">and remark = #{remark}</if>
			<if test="defaultChainid != null and defaultChainid !=''">and default_chainId = #{defaultChainid}</if>
			<if test="valid != null and valid !=''">and valid = #{valid}</if>
			<if test="creater != null and creater !=''">and Creater = #{creater}</if>
			<if test="createtime != null and createtime !=''">and CreateTime = #{createtime}</if>
			<if test="updater != null and updater !=''">and Updater = #{updater}</if>
			<if test="updatetime != null and updatetime !=''">and UpdateTime = #{updatetime}</if>
			<if test="keyword != null and keyword !=''">and (name like CONCAT('%', #{keyword}, '%') OR userName like CONCAT('%', #{keyword}, '%') OR tel like CONCAT('%', #{keyword}, '%'))</if>
		</where>
	</sql>

	<select id="selectByPrimaryKey" resultMap="LjAgencyMap"
		parameterType="java.lang.Long">
		SELECT
		A.*, B.userName,
		B.`name`
		FROM
		lj_agency A
		LEFT
		JOIN lj_sys_user B ON A.id = B.agencyId
		where A.id = #{id}
	</select>

	<select id="selectByMap" resultMap="LjAgencyMap" parameterType="java.util.Map">
		SELECT
		A.*, B.userName,
		B.`name`
		FROM
		lj_agency A
		LEFT JOIN lj_sys_user B
		ON A.id = B.agencyId
		<include refid="query_ljAgency_where"></include>
		<if test="start != null and pageSize != null">limit #{start},#{pageSize}</if>
	</select>

	<select id="countByMap" resultType="long" parameterType="java.util.Map">
		SELECT
		count(1)
		FROM
		lj_agency A
		LEFT
		JOIN lj_sys_user B ON A.id = B.agencyId
		<include refid="query_ljAgency_where"></include>
	</select>

	<delete id="deleteByPrimaryKey" parameterType="java.lang.Long">
		delete from
		lj_agency
		where
		id=#{id}
	</delete>

	<insert id="insert" parameterType="ljAgency">
		insert into lj_agency (
		<include refid="Base_Column_List"></include>
		)
		values(
		#{id},
		#{appid},
		#{appsecret},
		#{tel},
		#{contactPerson},
		#{province},
		#{city},
		#{address},
		#{remark},
		#{defaultChainid},
		#{valid},
		#{creater},
		#{createtime},
		#{updater},
		#{updatetime}
		)
	</insert>


	<update id="updateByPrimaryKeySelective" parameterType="ljAgency">
		update lj_agency
		<set>
			<if test="appid != null">
		  		appId = #{appid,jdbcType=VARCHAR},
			</if>
			<if test="appsecret != null">
		  		appSecret = #{appsecret,jdbcType=VARCHAR},
			</if>
			<if test="tel != null">
				tel = #{tel,jdbcType=VARCHAR},
			</if>
			<if test="contactPerson != null">
		  		contact_person = #{contactPerson,jdbcType=VARCHAR},
			</if>
			<if test="province != null">
				province = #{province,jdbcType=VARCHAR},
			</if>
			<if test="city != null">
				city = #{city,jdbcType=VARCHAR},
			</if>
			<if test="address != null">
				address = #{address,jdbcType=VARCHAR},
			</if>
			<if test="remark != null">
				remark = #{remark,jdbcType=VARCHAR},
			</if>
			<if test="defaultChainid != null">
		  		default_chainId = #{defaultChainid,jdbcType=INTEGER},
			</if>
			<if test="valid != null">
				valid = #{valid,jdbcType=VARCHAR},
			</if>
			<if test="creater != null">
		  		creater = #{creater,jdbcType=INTEGER},
			</if>
			<if test="createtime != null">
		  		createTime = #{createtime,jdbcType=TIMESTAMP},
			</if>
			<if test="updater != null">
		  		updater = #{updater,jdbcType=INTEGER},
			</if>
			<if test="updatetime != null">
		  		updateTime = #{updatetime,jdbcType=TIMESTAMP},
			</if>
		</set>
		where id = #{id,jdbcType=INTEGER}
	</update>
</mapper>  