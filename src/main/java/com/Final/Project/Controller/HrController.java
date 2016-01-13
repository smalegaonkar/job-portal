package com.Final.Project.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Final.Project.DAO.DAO;
import com.Final.Project.DAO.HrDAO;
import com.Final.Project.DAO.JobApplicationsDAO;
import com.Final.Project.DAO.JobDAO;
import com.Final.Project.POJO.HR;
import com.Final.Project.POJO.Job;
import com.Final.Project.POJO.JobApplications;
import com.Final.Project.POJO.Candidate;
import com.Final.Project.POJO.User_Account;

@Controller
public class HrController 
{
	
	@Autowired
	private HrDAO hrDAO;
	
	@Autowired
	private JobDAO jobDAO;
	
	@Autowired
	private JobApplicationsDAO jobApplicationsDAO;
	
//----------------------------------------------------------------------------------------------------
	
	@RequestMapping(value = "/HomePage", method = RequestMethod.POST)
	public String hrHome(Model model) 
	{
		return "HR_Home";
	}
		
//---------------------------------------------------------------------------------------------------
	
	@RequestMapping(value="/CreateOpening", method = RequestMethod.POST)
	public String createNewJobPostion(Locale locale, Model model, HttpServletRequest request)
	{
		Job job = new Job();
		model.addAttribute("job", job);
		return "Post_New_Job_Form";
	}	
//---------------------------------------------------------------------------------------------------
	
	@RequestMapping(value="/JobPosting", method = RequestMethod.POST)
	public String postJobsToPortal(@ModelAttribute("job") Job job, Model model, HttpServletRequest request,
			BindingResult result) 
	{		
		
		HttpSession session = request.getSession();
		
		User_Account userAccount = (User_Account)session.getAttribute("hr");
		HR hr = hrDAO.findHrByUserAccount(userAccount);
			
		List<Job> jobList = new ArrayList<Job>();					
		jobList.add(job);	
		hr.setJobList(jobList);
		job.setHr(hr);
			
		try
		{
			jobDAO.create(job);
			DAO.close();
		}
			
		catch (HibernateException e)
		{
			System.out.println("Exception: " + e.getMessage());
			return "Post_New_Job_Form";
		}	
		
		model.addAttribute("job", job);
			
		return "Success_Job_Posting";
	}
	
//---------------------------------------------------------------------------------------------------
	// View Job Applicants
		@RequestMapping(value="/ViewApplicants", method=RequestMethod.POST)
		public String viewApplicants(HttpServletRequest request, Model model)
		{
			HttpSession session = request.getSession();
			
			List<Candidate> job_SeekerList = new ArrayList<Candidate>();
			
			User_Account user_Account = (User_Account) session.getAttribute("hr");
			HR hr = hrDAO.findHrByUserAccount(user_Account);
			
			List<JobApplications> applicants = jobApplicationsDAO.returnApplicants();
			
			for(JobApplications jobapplicants : applicants)
			{
				if(jobapplicants.getJob().getHr().equals(hr))
				{
					job_SeekerList.add(jobapplicants.getJob_Seeker());
				}
			}
				
			model.addAttribute("job_SeekerList", job_SeekerList);
			return "Job_Applicants";
				
		}
}