import dao.CompanyDao;
import dao.CompanyDaoImpl;
import dao.CustomerDaoImpl;
import dao.DeveloperDaoImpl;
import dao.ProjectDaoImpl;
import dao.SkillDaoImpl;
import models.Company;
import models.Customer;
import models.Developer;
import models.Project;
import models.Skill;
import services.CompanyService;
import services.CompanyServiceImpl;
import services.CustomerService;
import services.CustomerServiceImpl;
import services.DeveloperService;
import services.DeveloperServiceImpl;
import services.ProjectService;
import services.ProjectServiceImpl;
import services.SkillService;
import services.SkillServiceImpl;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = ConnectionUtil.getConnection();

        CompanyService companyS = new CompanyServiceImpl(new CompanyDaoImpl(connection));
        CustomerService customerS = new CustomerServiceImpl(new CustomerDaoImpl(connection));
        DeveloperService developerS = new DeveloperServiceImpl(new DeveloperDaoImpl(connection));
        ProjectService projectS = new ProjectServiceImpl(new ProjectDaoImpl(connection));
        SkillService skillS = new  SkillServiceImpl(new SkillDaoImpl(connection));

//        Company company = new Company("EPAM1", Company.Type.INSOURCE);
//        companyS.addCompany(company);
//
//        Customer customer = new Customer("Din1", 22);
//        customerS.addCustomer(customer);
//
//        Developer developer = new Developer("Sam1", 22, 2200);
//        developerS.addDeveloper(developer);
//
//        Project project = new Project("Sters1", "Economical", 32000);
//        projectS.addProject(project);
//
//        Skill skill = new Skill(Skill.Name.JAVA, Skill.Degree.SENIOR);
//        skillS.addSkill(skill);
Skill skill = new Skill(Skill.Name.JAVA, null);
        Project project = projectS.getProjectById((long) 2);
        System.out.printf(projectS.getAllSalaryFromProject(project).toString());
        projectS.getAllDevelopersFromProject(project);
        developerS.getAllDevelopersBySkillName(skill);

    }
}
