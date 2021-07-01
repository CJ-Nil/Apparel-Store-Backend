package com.springSecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springSecurity.model.History;


public interface HistoryRepo extends JpaRepository<History,String>,HistoryRepoCustom {

}
