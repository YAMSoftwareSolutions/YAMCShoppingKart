package com.shopping.daoimpl;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.shopping.dao.RoleToScreenDao;
import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.BrandOrm;
import com.shopping.orm.RoleToScreenOrm;
import com.shopping.to.BrandTo;
import com.shopping.to.RoleToScreenTo;

public class RoleToScreenDaoimpl implements RoleToScreenDao {

	public RoleToScreenTo insertRolesToScreen(RoleToScreenTo roleToScreenTo) {
		
		Session session = null;
		Transaction tx = null;
		try {
			System.out.println("----------------------------");
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println("/////////////////////////////");
			RoleToScreenOrm roleToScreenOrm = new RoleToScreenOrm();
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
			RoleToScreenOrm roleToScreenOrm=(RoleToScreenOrm) session.createCriteria(RoleToScreenOrm.class).add(Restrictions.eq("id", id)).uniqueResult();
			
			//Set the Data to the To Object
			roleToScreenTo=new RoleToScreenTo();
			roleToScreenTo.setId(roleToScreenOrm.getId());
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

	
	
}
