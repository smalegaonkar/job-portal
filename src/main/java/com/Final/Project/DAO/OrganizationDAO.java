package com.Final.Project.DAO;
import org.hibernate.HibernateException;

import com.Final.Project.POJO.Organization;

public class OrganizationDAO extends DAO
{

	public void create(Organization organization) 
	{
        try 
        {
            begin();
            getSession().save(organization);
            commit();
        }
        catch (HibernateException e) 
        {
            rollback();
            e.printStackTrace();
        }
    }
}