package com.Final.Project.DAO;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.Final.Project.POJO.Job;


public class JobDAO extends DAO
{

	public void create(Job job)  {
		try 
	    {
			begin();
	        getSession().save(job);
	        commit();
	    }
	    catch (HibernateException e) 
	    {
	    	rollback();
	        e.printStackTrace();
	    }
	}
	
	public List<Job> fetchJobs()	{
		try
		{
			begin();
			Query q = getSession().createQuery("from Job");
			List<Job> jobList = q.list();
            commit();
            return jobList;
		}
		
		catch (HibernateException e) 
	    {
	    	rollback();
	        e.printStackTrace();
	        return null;
	    }
	}
	
	public Job getJobByJobID (int jobID)	{
		//getUserAccountByEmailID(String emailID)
		try 
		{
            begin();
            Query q = getSession().createQuery("from Job where jobID = :temp");
            q.setParameter("temp", jobID);
            Job job = (Job) q.uniqueResult();
            commit();
            return job;
        } 
		
		catch (HibernateException e) 
		{
            rollback();
            e.printStackTrace();
            return null;
        }
	}
}