package com.Final.Project.DAO;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.Final.Project.POJO.Candidate;
import com.Final.Project.POJO.User_Account;


public class CandidateDAO extends DAO
{
	public void create(Candidate candidate) 
	{
        try
        {
            begin();
            getSession().save(candidate);
            commit();
        }
        catch (HibernateException e) 
        {
            rollback();
            e.printStackTrace();
        }
    }
	
	public Candidate findJobSeekerByUserAccount(User_Account user_Account)	{
		try 
		{
            begin();
            Query q = getSession().createQuery("from Candidate where user_Account = :temp ");
            q.setParameter("temp", user_Account);
            Candidate job_Seeker= (Candidate) q.uniqueResult();
            commit();
            return job_Seeker;
        } 
		
		catch (HibernateException e) 
		{
            rollback();
            e.printStackTrace();
            return null;
        }
	}
}
