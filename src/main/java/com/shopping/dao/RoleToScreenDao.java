package com.shopping.dao;

import java.util.Collection;

import com.shopping.to.RoleTo;
import com.shopping.to.RoleToScreenTo;

public interface RoleToScreenDao {

	public RoleToScreenTo insertRolesToScreen(RoleToScreenTo roleToScreenTo);
	public RoleToScreenTo searchByid(int id);
	public Collection<RoleToScreenTo> getAll();
	public RoleToScreenTo update(int id, RoleToScreenTo roleToScreenTo);
}
