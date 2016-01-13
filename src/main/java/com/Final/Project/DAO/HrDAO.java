package com.Final.Project.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.Final.Project.POJO.HR;
import com.Final.Project.POJO.User_Account;

public class HrDAO extends DAO
{

	public void create(HR hr)
	{
        try 
        {
            begin();
            getSession().save(hr);
            commit();
        }
        catch (HibernateException e) 
        {
            rollback();
            e.printStackTrace();
        }
    }
	
	
	public HR findHrByUserAccount(User_Account user_Account)
		{
			try 
			{
	            begin();
	            Query q = getSession().createQuery("from HR where user_Account = :temp ");
	            q.setParameter("temp", user_Account);
	            HR hr = (HR) q.uniqueResult();
	            commit();
	            return hr;
	        } 
			
			catch (HibernateException e) 
			{
	            rollback();
	            e.printStackTrace();
	            return null;
	        }
		}
}
