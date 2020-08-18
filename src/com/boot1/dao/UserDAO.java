package com.boot1.dao;

import java.util.Map;

public interface UserDAO {
	Map<String,Object> userDAOLogin(Map<String,String> user);
}
