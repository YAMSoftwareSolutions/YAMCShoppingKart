package com.shopping.daoimpl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.shopping.dao.ScreenUrlDao;
import com.shopping.hibernate.HibernateUtil;
import com.shopping.orm.ScreensUrlOrm;
import com.shopping.to.ScreensUrlTo;

public class ScreenUrlDaoimpl implements ScreenUrlDao {

	public ArrayList<String> getAll() {
		Session session = null;
		ArrayList<String> lstScreenUrl = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			@SuppressWarnings("unchecked")
			ArrayList<ScreensUrlOrm> lstScreensUrlOrm = (ArrayList<ScreensUrlOrm>) session.createCriteria(ScreensUrlOrm.class).list();
			lstScreenUrl = new ArrayList<String>();
			for (ScreensUrlOrm screensUrlOrm : lstScreensUrlOrm) {
				//Add the Object to the Array List
				lstScreenUrl.add(screensUrlOrm.getScreenUrl());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return lstScreenUrl;
	}

	public ScreensUrlTo insert(ScreensUrlTo screensUrlTo) {
		Session session = null;
		Transaction tx = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			//Set the ORM
			ScreensUrlOrm screensUrlOrm = new ScreensUrlOrm();
			screensUrlOrm.setScreenName(screensUrlTo.getScreenName());
			screensUrlOrm.setScreenUrl(screensUrlTo.getScreenUrl());
			//Begin transaction & save the object
			tx = session.beginTransaction();
			session.save(screensUrlOrm);
			tx.commit();
			//Get the Updated Object from the DB
			screensUrlTo = null;
			screensUrlTo = this.searchByid(screensUrlOrm.getId());

		} catch (Exception e) {
			tx.rollback();
		} finally{
			session.clear();
			session.close();
			tx =null;
		}
		return screensUrlTo;
	}
	public ScreensUrlTo searchByid(int id) {

		Session session = null;
		ScreensUrlTo screensUrlTo = null;
		try {
			//Get Session Factory
			session = HibernateUtil.getSessionFactory().openSession();
			
			//Get the record based on ID From DB
			ScreensUrlOrm screensUrlOrm=(ScreensUrlOrm) session.createCriteria(ScreensUrlOrm.class).add(Restrictions.eq("id", id)).uniqueResult();
			
			//Set the Data to the To Object
			screensUrlTo=new ScreensUrlTo();
			screensUrlTo.setId(screensUrlOrm.getId());
			screensUrlTo.setScreenName(screensUrlOrm.getScreenName());
			screensUrlTo.setScreenUrl(screensUrlOrm.getScreenUrl());
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.clear();
			session.close();
		}
		return screensUrlTo;
	}
}
