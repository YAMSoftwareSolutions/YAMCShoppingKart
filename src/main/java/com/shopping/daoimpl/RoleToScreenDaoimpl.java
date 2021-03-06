package com.shopping.daoimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.shopping.dao.RoleToScreenDao;
import com.shopping.daofactory.ShoppingCartFactory;
import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.RoleOrm;
import com.shopping.orm.RoleToScreenOrm;
import com.shopping.orm.UserOrm;
import com.shopping.to.RoleTo;
import com.shopping.to.RoleToScreenTo;
import com.shopping.to.UsersTo;

public class RoleToScreenDaoimpl implements RoleToScreenDao {

	public RoleToScreenTo insertRolesToScreen(RoleToScreenTo roleToScreenTo) {
		
		Session session = null;
		Transaction tx = null;
		try {
			System.out.println("----------------------------");
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println("/////////////////////////////");
			RoleToScreenOrm roleToScreenOrm = new RoleToScreenOrm();
			System.out.println(roleToScreenTo.getRoleId());
			roleToScreenOrm.setRoleId(roleToScreenTo.getRoleId());
			roleToScreenOrm.setBrands_create(roleToScreenTo.getBrands_create());
			roleToScreenOrm.setBrands_delete(roleToScreenTo.getBrands_delete());
			roleToScreenOrm.setBrands_update(roleToScreenTo.getBrands_update());
			roleToScreenOrm.setBrands_view(roleToScreenTo.getBrands_view());
			
			roleToScreenOrm.setCategories_create(roleToScreenTo.getCategories_create());
			roleToScreenOrm.setCategories_delete(roleToScreenTo.getCategories_delete());
			roleToScreenOrm.setCategories_update(roleToScreenTo.getCategories_update());
			roleToScreenOrm.setCategories_view(roleToScreenTo.getCategories_view());
			
			roleToScreenOrm.setDiscounts_create(roleToScreenTo.getDiscounts_create());
			roleToScreenOrm.setDiscounts_delete(roleToScreenTo.getDiscounts_delete());
			roleToScreenOrm.setDiscounts_update(roleToScreenTo.getDiscounts_update());
			roleToScreenOrm.setDiscounts_view(roleToScreenTo.getDiscounts_view());
			
			roleToScreenOrm.setUnits_create(roleToScreenTo.getUnits_create());
			roleToScreenOrm.setUnits_delete(roleToScreenTo.getUnits_delete());
			roleToScreenOrm.setUnits_update(roleToScreenTo.getUnits_update());
			roleToScreenOrm.setUnits_view(roleToScreenTo.getUnits_view());
			
			roleToScreenOrm.setProduct_create(roleToScreenTo.getProduct_create());
			roleToScreenOrm.setProduct_delete(roleToScreenTo.getProduct_delete());
			roleToScreenOrm.setProduct_update(roleToScreenTo.getProduct_update());
			roleToScreenOrm.setProduct_view(roleToScreenTo.getProduct_view());
			
			roleToScreenOrm.setUsers_create(roleToScreenTo.getUsers_create());
			roleToScreenOrm.setUsers_delete(roleToScreenTo.getUsers_delete());
			roleToScreenOrm.setUsers_update(roleToScreenTo.getUsers_update());
			roleToScreenOrm.setUsers_view(roleToScreenTo.getUsers_view());
			
			roleToScreenOrm.setUserroles_create(roleToScreenTo.getUserroles_create());
			roleToScreenOrm.setUserroles_delete(roleToScreenTo.getUserroles_delete());
			roleToScreenOrm.setUserroles_update(roleToScreenTo.getUserroles_update());
			roleToScreenOrm.setUserroles_view(roleToScreenTo.getUserroles_view());
			
			roleToScreenOrm.setWeight_create(roleToScreenTo.getWeight_create());
			roleToScreenOrm.setWeight_delete(roleToScreenTo.getWeight_delete());
			roleToScreenOrm.setWeight_update(roleToScreenTo.getWeight_update());
			roleToScreenOrm.setWeight_view(roleToScreenTo.getWeight_view());
				
			tx = session.beginTransaction();
			session.save(roleToScreenOrm);
			tx.commit();
			roleToScreenTo = this.searchByid(roleToScreenOrm.getId());
			
		} catch (Exception e) {
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx =null;
		}
		
		return roleToScreenTo;
		
	}

	public RoleToScreenTo searchByid(int id) {
		// TODO Auto-generated method stub
		
		Session session = null;
		RoleToScreenTo roleToScreenTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			RoleToScreenOrm roleToScreenOrm=(RoleToScreenOrm) session.createCriteria(RoleToScreenOrm.class).add(Restrictions.eq("roleId", id)).uniqueResult();
			
			//Set the Data to the To Object
			roleToScreenTo=new RoleToScreenTo();
			roleToScreenTo.setId(roleToScreenOrm.getId());
			roleToScreenTo.setRoleId(roleToScreenOrm.getRoleId());
			roleToScreenTo.setBrands_create(roleToScreenOrm.getBrands_create());
			roleToScreenTo.setBrands_delete(roleToScreenOrm.getBrands_delete());
			roleToScreenTo.setBrands_update(roleToScreenOrm.getBrands_update());
			roleToScreenTo.setBrands_view(roleToScreenOrm.getBrands_view());
			
			roleToScreenTo.setCategories_create(roleToScreenOrm.getCategories_create());
			roleToScreenTo.setCategories_delete(roleToScreenOrm.getCategories_delete());
			roleToScreenTo.setCategories_update(roleToScreenOrm.getCategories_update());
			roleToScreenTo.setCategories_view(roleToScreenOrm.getCategories_view());
			
			roleToScreenTo.setDiscounts_create(roleToScreenOrm.getDiscounts_create());
			roleToScreenTo.setDiscounts_delete(roleToScreenOrm.getDiscounts_delete());
			roleToScreenTo.setDiscounts_update(roleToScreenOrm.getDiscounts_update());
			roleToScreenTo.setDiscounts_view(roleToScreenOrm.getDiscounts_view());
			
			roleToScreenTo.setProduct_create(roleToScreenOrm.getProduct_create());
			roleToScreenTo.setProduct_delete(roleToScreenOrm.getProduct_delete());
			roleToScreenTo.setProduct_update(roleToScreenOrm.getProduct_update());
			roleToScreenTo.setProduct_view(roleToScreenOrm.getProduct_view());
			
			roleToScreenTo.setUnits_create(roleToScreenOrm.getUnits_create());
			roleToScreenTo.setUnits_delete(roleToScreenOrm.getUnits_delete());
			roleToScreenTo.setUnits_update(roleToScreenOrm.getUnits_update());
			roleToScreenTo.setUnits_view(roleToScreenOrm.getUnits_view());
			
			roleToScreenTo.setUserroles_create(roleToScreenOrm.getUserroles_create());
			roleToScreenTo.setUserroles_delete(roleToScreenOrm.getUserroles_delete());
			roleToScreenTo.setUserroles_update(roleToScreenOrm.getUserroles_update());
			roleToScreenTo.setUserroles_view(roleToScreenOrm.getUserroles_view());
			
			roleToScreenTo.setUsers_create(roleToScreenOrm.getUsers_create());
			roleToScreenTo.setUsers_delete(roleToScreenOrm.getUsers_delete());
			roleToScreenTo.setUsers_update(roleToScreenOrm.getUsers_update());
			roleToScreenTo.setUsers_view(roleToScreenOrm.getUsers_view());
			
			roleToScreenTo.setWeight_create(roleToScreenOrm.getWeight_create());
			roleToScreenTo.setWeight_delete(roleToScreenOrm.getWeight_delete());
			roleToScreenTo.setWeight_update(roleToScreenOrm.getWeight_update());
			roleToScreenTo.setWeight_view(roleToScreenOrm.getWeight_view());
			
			

		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		
		return roleToScreenTo;
	}

	public Collection<RoleToScreenTo> getAll() {
		
		Session session = null;
		ArrayList<RoleToScreenTo> lstRolesTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			@SuppressWarnings("unchecked")
			ArrayList<RoleToScreenOrm> lstRolesToScreenOrm = (ArrayList<RoleToScreenOrm>) session.createCriteria(RoleToScreenOrm.class).list();
						
			RoleToScreenTo roleToScreenTo = null;
			lstRolesTo = new ArrayList<RoleToScreenTo>();
			
			for(RoleToScreenOrm roleToscreenOrm : lstRolesToScreenOrm )
			{
				roleToScreenTo=new RoleToScreenTo();
				System.out.println("id"+roleToscreenOrm.getId());
				roleToScreenTo.setId(roleToscreenOrm.getId());
				roleToScreenTo.setRoleId(roleToscreenOrm.getRoleId());
				
				roleToScreenTo.setCategories_create(roleToscreenOrm.getCategories_create());
				roleToScreenTo.setCategories_view(roleToscreenOrm.getCategories_view());
				roleToScreenTo.setCategories_delete(roleToscreenOrm.getCategories_delete());
				roleToScreenTo.setCategories_update(roleToscreenOrm.getCategories_update());
				
				
				roleToScreenTo.setBrands_create(roleToscreenOrm.getBrands_create());
				roleToScreenTo.setBrands_view(roleToscreenOrm.getBrands_view());
				roleToScreenTo.setBrands_delete(roleToscreenOrm.getBrands_delete());
				roleToScreenTo.setBrands_update(roleToscreenOrm.getBrands_update());
				
				roleToScreenTo.setDiscounts_create(roleToscreenOrm.getDiscounts_create());
				roleToScreenTo.setDiscounts_view(roleToscreenOrm.getDiscounts_view());
				roleToScreenTo.setDiscounts_delete(roleToscreenOrm.getDiscounts_delete());
				roleToScreenTo.setDiscounts_update(roleToscreenOrm.getDiscounts_update());
				
				roleToScreenTo.setProduct_create(roleToscreenOrm.getProduct_create());
				roleToScreenTo.setProduct_view(roleToscreenOrm.getProduct_view());
				roleToScreenTo.setProduct_delete(roleToscreenOrm.getProduct_delete());
				roleToScreenTo.setProduct_update(roleToscreenOrm.getProduct_update());
				
				roleToScreenTo.setUnits_create(roleToscreenOrm.getUnits_create());
				roleToScreenTo.setUnits_view(roleToscreenOrm.getUnits_view());
				roleToScreenTo.setUnits_delete(roleToscreenOrm.getUnits_delete());
				roleToScreenTo.setUnits_update(roleToscreenOrm.getUnits_update());
				
				roleToScreenTo.setWeight_create(roleToscreenOrm.getWeight_create());
				roleToScreenTo.setWeight_view(roleToscreenOrm.getWeight_view());
				roleToScreenTo.setWeight_delete(roleToscreenOrm.getWeight_delete());
				roleToScreenTo.setWeight_update(roleToscreenOrm.getWeight_update());
				
				roleToScreenTo.setUsers_create(roleToscreenOrm.getUsers_create());
				roleToScreenTo.setUsers_view(roleToscreenOrm.getUsers_view());
				roleToScreenTo.setUsers_delete(roleToscreenOrm.getUsers_delete());
				roleToScreenTo.setUsers_update(roleToscreenOrm.getUsers_update());
				
				lstRolesTo.add(roleToScreenTo);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception caught"+e.toString());
		}
		finally{
			session.clear();
			session.close();
		}
		return lstRolesTo;
		
	}

	
	public RoleToScreenTo update(int id, RoleToScreenTo roleToScreenTo) {
		
		Session session = null;
		Transaction tx = null;
		RoleToScreenTo sendRoleToScreenTo = null;
		
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			
			//Update the ORM
			RoleToScreenOrm roleToScreenOrm = (RoleToScreenOrm)session.load(RoleToScreenOrm.class, new Integer(id));
			roleToScreenOrm.setRoleId(roleToScreenTo.getRoleId());
			
			roleToScreenOrm.setBrands_create(roleToScreenTo.getBrands_create());
			roleToScreenOrm.setBrands_delete(roleToScreenTo.getBrands_delete());
			roleToScreenOrm.setBrands_update(roleToScreenTo.getBrands_update());
			roleToScreenOrm.setBrands_view(roleToScreenTo.getBrands_view());
			
			roleToScreenOrm.setCategories_create(roleToScreenTo.getCategories_create());
			roleToScreenOrm.setCategories_delete(roleToScreenTo.getCategories_delete());
			roleToScreenOrm.setCategories_update(roleToScreenTo.getCategories_update());
			roleToScreenOrm.setCategories_view(roleToScreenTo.getCategories_view());
			
			roleToScreenOrm.setDiscounts_create(roleToScreenTo.getDiscounts_create());
			roleToScreenOrm.setDiscounts_delete(roleToScreenTo.getDiscounts_delete());
			roleToScreenOrm.setDiscounts_update(roleToScreenTo.getDiscounts_update());
			roleToScreenOrm.setDiscounts_view(roleToScreenTo.getDiscounts_view());
			
			roleToScreenOrm.setUnits_create(roleToScreenTo.getUnits_create());
			roleToScreenOrm.setUnits_delete(roleToScreenTo.getUnits_delete());
			roleToScreenOrm.setUnits_update(roleToScreenTo.getUnits_update());
			roleToScreenOrm.setUnits_view(roleToScreenTo.getUnits_view());
			
			roleToScreenOrm.setProduct_create(roleToScreenTo.getProduct_create());
			roleToScreenOrm.setProduct_delete(roleToScreenTo.getProduct_delete());
			roleToScreenOrm.setProduct_update(roleToScreenTo.getProduct_update());
			roleToScreenOrm.setProduct_view(roleToScreenTo.getProduct_view());
			
			roleToScreenOrm.setUsers_create(roleToScreenTo.getUsers_create());
			roleToScreenOrm.setUsers_delete(roleToScreenTo.getUsers_delete());
			roleToScreenOrm.setUsers_update(roleToScreenTo.getUsers_update());
			roleToScreenOrm.setUsers_view(roleToScreenTo.getUsers_view());
			
			roleToScreenOrm.setUserroles_create(roleToScreenTo.getUserroles_create());
			roleToScreenOrm.setUserroles_delete(roleToScreenTo.getUserroles_delete());
			roleToScreenOrm.setUserroles_update(roleToScreenTo.getUserroles_update());
			roleToScreenOrm.setUserroles_view(roleToScreenTo.getUserroles_view());
			
			roleToScreenOrm.setWeight_create(roleToScreenTo.getWeight_create());
			roleToScreenOrm.setWeight_delete(roleToScreenTo.getWeight_delete());
			roleToScreenOrm.setWeight_update(roleToScreenTo.getWeight_update());
			roleToScreenOrm.setWeight_view(roleToScreenTo.getWeight_view());
			
			tx = session.beginTransaction();
			session.save(roleToScreenOrm);
			//Commit the Transaction
			tx.commit();
			
			//Get the Updated Object from the DB
			sendRoleToScreenTo = this.searchByid(id);
		} catch (Exception e) {
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx =null;
			roleToScreenTo = null;
		}
		
		// TODO Auto-generated method stub
		return sendRoleToScreenTo;
	}

	
	
}
