package org.yunhyerim.api.user.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import org.yunhyerim.api.user.domain.UserVO;

@Repository
public class UserRepositoryImpl extends QuerydslRepositorySupport implements UserCustomRepository{
	//private final JPAQueryFactory qf;
	public UserRepositoryImpl() {
		super(UserVO.class);
		//this.qf = qf;
	}
}
