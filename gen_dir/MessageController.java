package com.mountain.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mountain.spring.common.PageBean;
import com.mountain.spring.entity.Message;
import com.mountain.spring.service.IMessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
	@Autowired
	private IMessageService messageService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@ApiOperation(value = "获取Message详细信息", notes = "根据url的id来获取Message详细信息")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		return new ResponseEntity<Object>(
				messageService.selectByPrimaryKey(id), HttpStatus.OK);
	}

	@ApiOperation(value = "获取Message列表", notes = "分页获取Message列表")
	@RequestMapping(value = "/page/{pageSize}/{page}", method = RequestMethod.POST)
	public ResponseEntity<Object> findByPage(@RequestBody Message message,
			@PathVariable(required = true) int page,
			@PathVariable(required = true) int pageSize) {
		Map<String, String> map = new HashMap<String, String>();
		PageBean<Message> pb = new PageBean<Message>(page, pageSize);
		try {
			map = BeanUtils.describe(message);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(messageService.selectPageByMap(map,
				pb), HttpStatus.OK);
	}

	@ApiOperation(value = "获取Message列表", notes = "根据Message对象过滤")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public ResponseEntity<Object> list(@RequestBody Message message) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			map = BeanUtils.describe(message);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(messageService.selectByMap(map),
				HttpStatus.OK);
	}

	@ApiOperation(value = "创建Message", notes = "根据Message对象创建Message")
	@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<Object> insert(@RequestBody Message message) {
		int t = messageService.insert(message);
		if (t > 0) {
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ApiOperation(value = "更新Message详细信息", notes = "根据url的id来指定更新对象，并根据传过来的Message信息来更新Message详细信息")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public ResponseEntity<Object> update(@PathVariable Long id,
			@RequestBody Message message) {
		Message bean = messageService.selectByPrimaryKey(id);
		String[] excludeArr = new String[] { "id" };
		org.springframework.beans.BeanUtils.copyProperties(bean, message,
				excludeArr);

		int t = messageService.updateByPrimaryKeySelective(bean);
		if (t > 0) {
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public ResponseEntity<Object> deleteByPrimaryKey(
			@PathVariable(required = true) Long id) {
		int t = messageService.deleteByPrimaryKey(id);
		if (t > 0) {
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
