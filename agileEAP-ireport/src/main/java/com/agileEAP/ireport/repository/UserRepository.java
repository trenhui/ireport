package com.agileEAP.ireport.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.agileEAP.ireport.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	User findByLoginName(String loginName);
}
