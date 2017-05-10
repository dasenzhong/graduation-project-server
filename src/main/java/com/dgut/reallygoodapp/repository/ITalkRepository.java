package com.dgut.reallygoodapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dgut.reallygoodapp.entity.Talk;

@Repository
public interface ITalkRepository extends PagingAndSortingRepository<Talk, Integer> {

	@Query("from Talk t where t.userId = ?1 order by t.createDate DESC")
	List<Talk> findTalkByUserId(Integer userId);
	
	@Query("from Talk t where t.userAccount = ?1 order by t.createDate DESC")
	List<Talk> findTalkByUserAccount(String userAccount);
	
}
