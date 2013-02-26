package com.agileEAP.ireport.soap;

import java.util.List;

import javax.jws.WebService;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.agileEAP.ireport.entity.User;
import com.agileEAP.ireport.service.AccountMybatisService;
import com.agileEAP.utils.BeanValidators;
import com.agileEAP.utils.BeanMapper;
import com.agileEAP.utils.Exceptions;

/**
 * WebService服务端实现类.
 * 
 * 为演示方便，直接调用了Dao层.客户端实现见功能测试用例.
 * 
 * @author calvin
 */
//serviceName指明WSDL中<wsdl:service>与<wsdl:binding>元素的名称, endpointInterface属性指向Interface类全称.
@WebService(serviceName = "AccountService", endpointInterface = "com.agileEAP.ireport.soap.AccountSoapService", targetNamespace = WsConstants.NS)
public class AccountSoapServiceImpl implements AccountSoapService {

	private static Logger logger = LoggerFactory.getLogger(AccountSoapServiceImpl.class);

	@Autowired
	private AccountMybatisService accountMybatisService;

	@Autowired
	private Validator validator;

	/**
	 * @see AccountSoapService#getUser()
	 */
	@Override
	public GetUserResult getUser(Long id) {
		GetUserResult result = new GetUserResult();
		try {

			Validate.notNull(id, "id参数为空");

			User user = accountMybatisService.getUser(id);

			Validate.notNull(user, "用户不存在(id:" + id + ")");

			UserDTO dto = BeanMapper.map(user, UserDTO.class);
			result.setUser(dto);

			return result;

		} catch (IllegalArgumentException e) {
			return handleParameterError(result, e);
		} catch (RuntimeException e) {
			return handleGeneralError(result, e);
		}
	}

	/**
	 * @see AccountSoapService#searchUser()
	 */
	@Override
	public SearchUserResult searchUser(String loginName, String name) {
		SearchUserResult result = new SearchUserResult();
		try {
			List<User> userList = accountMybatisService.searchUser(loginName, name);

			List<UserDTO> dtoList = BeanMapper.mapList(userList, UserDTO.class);
			result.setUserList(dtoList);
			return result;
		} catch (RuntimeException e) {
			return handleGeneralError(result, e);
		}
	}

	/**
	 * @see AccountSoapService#createUser()
	 */
	@Override
	public IdResult createUser(UserDTO user) {
		IdResult result = new IdResult();
		try {
			Validate.notNull(user, "用户参数为空");

			User userEntity = BeanMapper.map(user, User.class);
			BeanValidators.validateWithException(validator, userEntity);

			accountMybatisService.saveUser(userEntity);

			return new IdResult(userEntity.getId());
		} catch (ConstraintViolationException e) {
			String message = StringUtils.join(BeanValidators.extractPropertyAndMessageAsList(e, " "), "\n");
			return handleParameterError(result, e, message);
		} catch (RuntimeException e) {
			if (Exceptions.isCausedBy(e, org.hibernate.exception.ConstraintViolationException.class)) {
				String message = "新建用户参数存在唯一性冲突(用户:" + user + ")";
				return handleParameterError(result, e, message);
			} else {
				return handleGeneralError(result, e);
			}
		}
	}

	private <T extends WSResult> T handleParameterError(T result, Exception e, String message) {
		logger.error(message, e.getMessage());
		result.setError(WSResult.PARAMETER_ERROR, message);
		return result;
	}

	private <T extends WSResult> T handleParameterError(T result, Exception e) {
		logger.error(e.getMessage());
		result.setError(WSResult.PARAMETER_ERROR, e.getMessage());
		return result;
	}

	private <T extends WSResult> T handleGeneralError(T result, Exception e) {
		logger.error(e.getMessage());
		result.setDefaultError();
		return result;
	}
}
