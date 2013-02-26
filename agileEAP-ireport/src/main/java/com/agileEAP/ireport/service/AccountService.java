package com.agileEAP.ireport.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.agileEAP.ireport.entity.*;
import com.agileEAP.ireport.repository.*;
import com.agileEAP.ireport.service.ShiroDbRealm.ShiroUser;
import com.agileEAP.utils.*;

/**
 * 鐢ㄦ埛绠＄悊绫�
 * 
 * @author calvin
 */
// Spring Service Bean鐨勬爣璇�
@Component
@Transactional(readOnly = true)
public class AccountService {

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;

	private static Logger logger = LoggerFactory.getLogger(AccountService.class);
	
	private UserRepository userRepository;
	private DateProvider dateProvider = DateProvider.DEFAULT;

	public List<User> getAllUser() {
		return (List<User>) userRepository.findAll();
	}

	public User getUser(Long id) {
		return userRepository.findOne(id);
	}

	public User findUserByLoginName(String loginName) {
		return userRepository.findByLoginName(loginName);
	}

	@Transactional(readOnly = false)
	public void registerUser(User user) {
		entryptPassword(user);
		user.setRoles("user");
		user.setRegisterDate(dateProvider.getDate());

		userRepository.save(user);
	}

	@Transactional(readOnly = false)
	public void updateUser(User user) {
		if (StringUtils.isNotBlank(user.getPlainPassword())) {
			entryptPassword(user);
		}
		userRepository.save(user);
	}

	@Transactional(readOnly = false)
	public void deleteUser(Long id) {
		if (isSupervisor(id)) {
			logger.warn("鎿嶄綔鍛榹}灏濊瘯鍒犻櫎瓒呯骇绠＄悊鍛樼敤鎴", getCurrentUserName());
			throw new ServiceException("涓嶈兘鍒犻櫎瓒呯骇绠＄悊鍛樼敤鎴�");
		}
		userRepository.delete(id);
	}

	/**
	 * 鍒ゆ柇鏄惁瓒呯骇绠＄悊鍛�
	 */
	private boolean isSupervisor(Long id) {
		return id == 1;
	}

	/**
	 * 鍙栧嚭Shiro涓殑褰撳墠鐢ㄦ埛LoginName.
	 */
	private String getCurrentUserName() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.loginName;
	}

	/**
	 * 璁惧畾瀹夊叏鐨勫瘑鐮侊紝鐢熸垚闅忔満鐨剆alt骞剁粡杩�024娆�sha-1 hash
	 */
	private void entryptPassword(User user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}

	@Autowired
	public void setUserDao(UserRepository userDao) {
		this.userRepository = userDao;
	}

	public void setDateProvider(DateProvider dateProvider) {
		this.dateProvider = dateProvider;
	}
}
