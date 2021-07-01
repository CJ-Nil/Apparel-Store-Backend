package com.springSecurity.dao;

import java.util.List;

import com.springSecurity.model.History;

public interface HistoryRepoCustom {
	List<History> findAllHistoryByUsername(String username);
}
