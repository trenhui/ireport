package com.agileEAP.ireport.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.agileEAP.ireport.entity.User;
import com.agileEAP.ireport.service.AccountMybatisService;
import com.agileEAP.utils.BeanMapper;

@Path("/user")
public class AccountJaxRsService {

	private static Logger logger = LoggerFactory.getLogger(AccountJaxRsService.class);

	@Autowired
	private AccountMybatisService accountService;

	@GET
	@Path("/{id}.xml")
	@Produces(MediaType.APPLICATION_XML)
	public UserDTO getAsXml(@PathParam("id") Long id) {
		User user = accountService.getUser(id);
		if (user == null) {
			String message = "用户不存在(id:" + id + ")";
			throw buildException(Status.NOT_FOUND, message);
		}
		return bindDTO(user);
	}

	@GET
	@Path("/{id}.json")
	@Produces(MediaType.APPLICATION_JSON)
	public UserDTO getAsJson(@PathParam("id") Long id) {
		User user = accountService.getUser(id);
		if (user == null) {
			String message = "用户不存在(id:" + id + ")";
			throw buildException(Status.NOT_FOUND, message);
		}
		return bindDTO(user);
	}

	private UserDTO bindDTO(User user) {
		UserDTO dto = BeanMapper.map(user, UserDTO.class);
		return dto;
	}

	private WebApplicationException buildException(Status status, String message) {
		return new WebApplicationException(Response.status(status).entity(message).type(MediaType.TEXT_PLAIN).build());
	}
}
