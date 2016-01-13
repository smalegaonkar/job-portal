package com.Final.Project.DAO;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.Final.Project.POJO.User_Account;

public class UserAccountDAO extends DAO
{

	public void create(User_Account user_Account) 
	{
        try 
        {
            begin();
            getSession().save(user_Account);
            commit();
        }
        catch (HibernateException e) 
        {
            rollback();
            e.printStackTrace();
        }
    }
	
//-------------------------------------------------------------------------------------------
	public User_Account selectUserAccountByEmailID(String emailID)
	{
		try 
		{
            begin();
            Query q = getSession().createQuery("from User_Account where emailID = :temp");
            q.setParameter("temp", emailID);
            User_Account user_Account = (User_Account) q.uniqueResult();
            commit();
            return user_Account;
        } 
		
		catch (HibernateException e) 
		{
            rollback();
            e.printStackTrace();
            return null;
        }
	}
	
//-------------------------------------------------------------------------------------------
	public User_Account selectUserAccount(User_Account user_Account)
	{
		try 
		{
            begin();
            Query q = getSession().createQuery("from User_Account where emailID = :temp");
            q.setParameter("temp", user_Account.getEmailID());
            User_Account ua = (User_Account) q.uniqueResult();
            commit();
            return ua;
        } 
		
		catch (HibernateException e) 
		{
            rollback();
            e.printStackTrace();
            return null;
        }
	}
	
//-------------------------------------------------------------------------------------------
	public Boolean checkUniqueUserAccount(String emailID)
	{
		begin();
		Query q = getSession().createQuery("from User_Account where emailID = :temp");
		q.setParameter("temp", emailID);			
		User_Account user_Account = (User_Account)q.uniqueResult();	
		commit();
		
		if(user_Account==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}