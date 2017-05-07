package com.dgut.reallygoodapp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dgut.reallygoodapp.entity.Admin;


@Repository
public interface IAdminRepository extends PagingAndSortingRepository<Admin, Integer> {

}