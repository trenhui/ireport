package com.agileEAP.ireport.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.agileEAP.utils.JsonConvert;
import com.agileEAP.ireport.entity.User;
import com.agileEAP.ireport.repository.UserMybatisRepository;
import com.google.common.collect.Maps;

/**
 * 更高效的AccountService实现，基于MyBatis + Memcached的方案，以JSON格式存储Memcached中的内容。
 * 
 * @author calvin
 */
@Component
@Transactional(readOnly = true)
public class AccountMybatisService {

	@Autowired
	private UserMybatisRepository userMybatisRepository;

/*	@Autowired
	private SpyMemcachedClient memcachedClient;
*/
//	private final JsonConvert jsonConvert = JsonConvert.nonDefaultMapper();

	/**
	 * 先访问Memcached, 使用JSON字符串存放对象以节约空间.
	 */
	public User getUser(Long id) {
		//String key = MemcachedObjectType.USER.getPrefix() + id;

		User user = null;
		//String jsonString = memcachedClient.get(key);

/*		if (jsonString == null) {
			user = userDao.get(id);
			if (user != null) {
				jsonString = JsonConvert.toJson(user);
				memcachedClient.set(key, MemcachedObjectType.USER.getExpiredTime(), jsonString);
			}
		} else {
			user = jsonConvert.fromJson(jsonString, User.class);
		}*/
		
		user = userMybatisRepository.get(id);
		return user;
	}

	public List<User> searchUser(String loginName, String name) {
		Map<String, Object> parameters = Maps.newHashMap();
		parameters.put("loginName", loginName);
		parameters.put("name", name);
		return userMybatisRepository.search(parameters);
	}

	@Transactional
	public void saveUser(User user) {
		userMybatisRepository.save(user);
	}

	@Transactional
	public void deleteUser(Long id) {
		userMybatisRepository.delete(id);
	}
}
