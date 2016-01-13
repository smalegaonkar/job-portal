package com.Final.Project.Controller;

import java.util.ArrayList;
import java.util.List;
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
import com.Final.Project.DAO.JobApplicationsDAO;
import com.Final.Project.DAO.JobDAO;
import com.Final.Project.DAO.CandidateDAO;
import com.Final.Project.POJO.Job;
import com.Final.Project.POJO.JobApplications;
import com.Final.Project.POJO.Candidate;
import com.Final.Project.POJO.User_Account;

@Controller
public class CandidateController 
{
	@Autowired
	private CandidateDAO candidateDAO;
	
	@Autowired
	private JobDAO jobDAO;
	
	@Autowired
	private JobApplicationsDAO jobApplicationsDAO;
	
//---------------------------------------------------------------------------------------------------
	
		
		@RequestMapping(value = "/SeekerHomePage", method = RequestMethod.POST)
		public String jobSeekerHome(Model model, HttpServletRequest request) 
		{
			List<Job> jobList = jobDAO.fetchJobs();
			request.setAttribute("jobList", jobList);
			return "Candidate_Home";
		}
		
//---------------------------------------------------------------------------------------------------
		
		@RequestMapping(value = "/viewJobDetails", method = RequestMethod.POST)
		public String viewDetails(Model model, HttpServletRequest request) 
		{
			
			int jobID = Integer.parseInt(request.getParameter("jobID"));
			String jobTitle = request.getParameter("jobTitle");
			String jobDescription = request.getParameter("jobDescription");
			String jobRequirements = request.getParameter("jobRequirements");
			
			model.addAttribute("jobID", jobID);
			model.addAttribute("jobTitle", jobTitle);
			model.addAttribute("jobDescription", jobDescription);
			model.addAttribute("jobRequirements", jobRequirements);
			//model.addAttribute("job", job);
			//System.out.println(job.getJobRequirements());
			return "viewJobDetails";
		}
			
//---------------------------------------------------------------------------------------------------
		
		
		@RequestMapping(value="/apply", method=RequestMethod.POST)
		public String applyJobs(@ModelAttribute("jobApplications") JobApplications jobApplications, Model model, 
												BindingResult result, HttpServletRequest request)
		{
			
			HttpSession session = request.getSession();
			
			User_Account user_Account = (User_Account) session.getAttribute("job_Seeker");
			
			Candidate job_Seeker = candidateDAO.findJobSeekerByUserAccount(user_Account);
			
			int jobID = Integer.parseInt(request.getParameter("apply"));
			System.out.println("Job Applied is" +jobID);
			JobDAO jobDAO = new JobDAO();
			Job job = jobDAO.getJobByJobID(jobID);
			
			jobApplications.setJob(job);
			jobApplications.setJob_Seeker(job_Seeker);
			
			try
			{
				JobApplicationsDAO jobApplicationsDAO = new JobApplicationsDAO(); 
				jobApplicationsDAO.create(jobApplications);
				DAO.close();
			}
				
			catch (HibernateException e)
			{
				System.out.println("Exception: " + e.getMessage());
				return "Failure_Job_Posting";
			}	
			
			model.addAttribute("jobApplications", jobApplications);
			
			return "Success_Job_Applied";
		}
		
		
//---------------------------------------------------------------------------------------------------

		// View My Applied Jobs
			@RequestMapping(value="myJobs", method=RequestMethod.POST)
			public String myJobs(HttpServletRequest request, Model model)
			{
				HttpSession session = request.getSession();
				
				//List<Job_Seeker> job_SeekerList = new ArrayList<Job_Seeker>();
				List<JobApplications> myJobApplicationsList = new ArrayList<JobApplications>();
				
				User_Account user_Account = (User_Account) session.getAttribute("job_Seeker");
				Candidate job_Seeker = candidateDAO.findJobSeekerByUserAccount(user_Account);
				
				List<JobApplications> applicants = jobApplicationsDAO.returnApplicants();
				
				
				for(JobApplications jobapplicant : applicants)
				{
					if(jobapplicant.getJob_Seeker() != null) {
						if(jobapplicant.getJob_Seeker().equals(job_Seeker))
						{
							//job_SeekerList.add(jobapplicants.getJob_Seeker());
							myJobApplicationsList.add(jobapplicant);
						}
					}
				}
				
				model.addAttribute("myJobApplicationsList", myJobApplicationsList);
				return "myJobs";		
			}
}