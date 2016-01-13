package com.Final.Project.DAO;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.Final.Project.POJO.JobApplications;

public class JobApplicationsDAO extends DAO
{

		public void create(JobApplications jobApplications) 
		{
			try 
		    {
				begin();
		        getSession().save(jobApplications);
		        commit();
		    }
		    catch (HibernateException e) 
		    {
		    	rollback();
		        e.printStackTrace();
		    }
		}

//---------------------------------------------------------------------------------------
	public List<JobApplications> getListByJob()
	{
		try
		{
			begin();
			Query q = getSession().createQuery("from JobApplications where jobID = :temp");
			
			List<JobApplications> applicationList = q.list();
			commit();
			return applicationList;
			
		}
		
		catch (HibernateException e) 
	    {
	    	rollback();
	        e.printStackTrace();
	        return null;
	    }
	}
	
//---------------------------------------------------------------------------------------
	public List<JobApplications> getListByHr()
	{
		try
		{
			begin();
			Query q = getSession().createQuery("from JobApplications where hrID = :temp");
			
			List<JobApplications> applicationList = q.list();
			commit();
			return applicationList;
			
		}
		
		catch (HibernateException e) 
	    {
	    	rollback();
	        e.printStackTrace();
	        return null;
	    }
	}
	
//---------------------------------------------------------------------------------------
	public List<JobApplications> getListByJobID(String jobID)
	{
		try
		{
			begin();
			Query q = getSession().createQuery("from JobApplications where jobID = :temp");
			
			List<JobApplications> applicationList = q.list();
			commit();
			return applicationList;
			
		}
		
		catch (HibernateException e) 
	    {
	    	rollback();
	        e.printStackTrace();
	        return null;
	    }
	}
//---------------------------------------------------------------------------------------	
	public List<JobApplications> getListByHrID(String hrID)
	{
		try
		{
			begin();
			Query q = getSession().createQuery("from JobApplications where HrID = :temp");
			
			List<JobApplications> applicationList = q.list();
			commit();
			return applicationList;
			
		}
		
		catch (HibernateException e) 
	    {
	    	rollback();
	        e.printStackTrace();
	        return null;
	    }
	}
	
	
//---------------------------------------------------------------------------------------
	public List<JobApplications> returnApplicants()
	{
		try
		{
			begin();
			Query q = getSession().createQuery("from JobApplications");	            			
			List<JobApplications> applicantList = q.list();
			
	        commit();
	        return applicantList;	            
		}
		catch (HibernateException e) 
		{
		    rollback();
		    e.printStackTrace();
		    return null;
		}		
	}
}