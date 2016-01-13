package com.Final.Project.Controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.Final.Project.DAO.AddressDAO;
import com.Final.Project.DAO.OrganizationDAO;
import com.Final.Project.DAO.DAO;
import com.Final.Project.DAO.HrDAO;
import com.Final.Project.DAO.JobDAO;
import com.Final.Project.DAO.CandidateDAO;
import com.Final.Project.DAO.UserAccountDAO;
import com.Final.Project.POJO.Address;
import com.Final.Project.POJO.Organization;
import com.Final.Project.POJO.HR;
import com.Final.Project.POJO.Job;
import com.Final.Project.POJO.Candidate;
import com.Final.Project.POJO.User_Account;


@Controller
public class LoginController {
	
	@Autowired
	private AddressDAO addressDAO;
	
	@Autowired
	private OrganizationDAO organizationDAO;
	
	@Autowired
	private HrDAO hrDAO;
	
	@Autowired 
	private CandidateDAO candidateDAO;
	
	@Autowired
	private UserAccountDAO userAccountDAO;
	
	@Autowired
	private JobDAO jobDAO;
	
//---------------------------------------------------------------------------------------------------	
	
	
	@RequestMapping(value="/" , method = RequestMethod.GET)
	public ModelAndView JobPortalApplication(Locale locale, Model model,HttpServletRequest request)
	{
		User_Account user_Account = new User_Account();

		return new ModelAndView("Login_Page", "user_Account", user_Account);
	}
//---------------------------------------------------------------------------------------------------	
	@RequestMapping(value="home" , method = RequestMethod.POST)
	public ModelAndView home(Locale locale, Model model,HttpServletRequest request)
	{
		User_Account user_Account = new User_Account();

		return new ModelAndView("Login_Page", "user_Account", user_Account);
	}

//---------------------------------------------------------------------------------------------------	
	@RequestMapping(value="candidateRegistration" , method = RequestMethod.POST)
	public String registration(Locale locale, Model model,HttpServletRequest request)
	{
		Candidate job_Seeker = new Candidate();
		Address address = new Address();
		User_Account user_Account = new User_Account();
		
		
		job_Seeker.setAddress(address);
		job_Seeker.setUser_Account(user_Account);
		
		model.addAttribute("job_Seeker",job_Seeker);
		
		return "Candidate_Registration_Form";
	}

//---------------------------------------------------------------------------------------------------	
	
	
	@RequestMapping(value="/RegisterUser", method = RequestMethod.POST)
	public String Job_Seeker_Registration(@ModelAttribute("job_Seeker") Candidate job_Seeker, Model model, BindingResult result) 
	{		
		if(result.hasErrors())
		{
			
			return "Candidate_Registration_Form";
		}
		else {
			User_Account job_Seeker_user_Account = job_Seeker.getUser_Account();						
			job_Seeker_user_Account.setRole("jobSeeker");
			
			if(!(userAccountDAO.checkUniqueUserAccount(job_Seeker_user_Account.getEmailID()))) {			
				System.out.println("Username already exists");
				return "Candidate_Registration_Form";			
			}	
			
			Address job_SeekerAddress = job_Seeker.getAddress();
			try { 
				addressDAO.create(job_SeekerAddress); 
				DAO.close();
					
				userAccountDAO.create(job_Seeker_user_Account);
				DAO.close();
				
				System.out.println(job_Seeker.getFirst_name());
				candidateDAO.create(job_Seeker);
				DAO.close();				
			} catch (HibernateException e) {
				System.out.println("Exception: " + e.getMessage());
				return "Candidate_Registration_Form";
			}						
			
			model.addAttribute("job_Seeker", job_Seeker);
			return "Success_Registration";
		}
	}
//--------------------------------------------------------------------------------------------------
	
	@RequestMapping(value="HrRegistration" , method = RequestMethod.POST)
	public String HrRegistration(Locale locale, Model model,HttpServletRequest request)
	{
		HR hr = new HR();
		Address address = new Address();
		User_Account user_Account = new User_Account();
		Organization company = new Organization();
		
		
		hr.setAddress(address);
		hr.setUser_Account(user_Account);
		hr.setCompany(company);
		
		model.addAttribute("hr",hr);
		return "HR_Registration_Form";
	}
	
//---------------------------------------------------------------------------------------------------
	
	@RequestMapping(value="/RegisterHr", method = RequestMethod.POST)
	public String Hr_Registration(@ModelAttribute("hr") HR hr, Model model, BindingResult result) 
	{		

		if(result.hasErrors())
		{
			return "HR_Registration_Form";
		}
		else
		{	
		
			User_Account hr_userAccount = hr.getUser_Account();
			hr_userAccount.setRole("hr");

			if(!(userAccountDAO.checkUniqueUserAccount(hr_userAccount.getEmailID())))
			{			
				System.out.println("Username already exists");
				return "HR_Registration_Form";			
			}

			
			Address hr_Address = hr.getAddress();
			Organization hr_Company = hr.getCompany();
		
		try
		{
			addressDAO.create(hr_Address); 
			DAO.close();
				
			userAccountDAO.create(hr_userAccount);
			DAO.close();
			
			organizationDAO.create(hr_Company);
			DAO.close();
			
			hrDAO.create(hr);
			DAO.close();			
		}		
		catch (HibernateException e)
		{
			System.out.println("Exception: " + e.getMessage());
			return "HR_Registration_Form";
		}		
		
			model.addAttribute("hr", hr);
			return "Success_Registration";
		}
	}
	
//---------------------------------------------------------------------------------------------------	
	
	@RequestMapping(value = "/LoginSuccess", method = RequestMethod.POST)
	public String logintoSystem(@ModelAttribute("user_Account") User_Account user_Account,
									BindingResult result, HttpServletRequest request) {
		HttpSession session;		
		if (result.hasErrors()) {
			System.out.println("Result errors");
			return "Login_Page";
		} else {			
			System.out.println(user_Account.getEmailID());
			User_Account ua = userAccountDAO.selectUserAccount(user_Account);			
			if(ua == null) {				
				System.out.println("ua has null record");
				System.out.println("Username does not exists in database");
				return "Login_Page";
			} else {		
				if(ua.getPassword().equals(user_Account.getPassword())) {				
					System.out.println("password matching");
					if(ua.getRole().equalsIgnoreCase("jobSeeker")){
						System.out.println("Candidate Credentials Matched");
						session = request.getSession(true);
						session.setAttribute("job_Seeker", ua);
						List<Job> jobList = jobDAO.fetchJobs();
						request.setAttribute("jobList", jobList);
						return "Candidate_Home";
					} else  
						if(ua.getRole().equalsIgnoreCase("hr")) {
						System.out.println("HR Credentials Matched");
						session = request.getSession(true);
						session.setAttribute("hr", ua);
						return "HR_Home";	
					}
				}
				System.out.println("Invalid Username or password. Try Again !");
				return "Login_Page";
			}
		}
	}	
	
//----------------------------------------------------------------------------------------------------	
	
	@RequestMapping(value = "/Logout", method = RequestMethod.GET)
	public String logout(Model model,HttpServletRequest request) 
	{	
		HttpSession session = request.getSession(false);
		
		if(session.getAttribute("job_Seeker")==null && session.getAttribute("hr")==null)
		{
			return "Failure_Logout";
		}
		
		User_Account user_Account = new User_Account();
		model.addAttribute(user_Account);
				
		session.invalidate();		
		return "Login_Page";
	}	
}