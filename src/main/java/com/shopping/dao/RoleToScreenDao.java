package com.shopping.dao;

import java.util.Collection;

import com.shopping.to.RoleToScreenTo;

public interface RoleToScreenDao {

	public RoleToScreenTo insertRolesToScreen(RoleToScreenTo roleToScreenTo);
	public RoleToScreenTo searchByid(int id);
	public RoleToScreenTo getAll();
}
