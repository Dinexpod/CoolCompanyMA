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
        SkillService skillS = new SkillServiceImpl(new SkillDaoImpl(connection));

//        Create and add company
//        Company company = new Company("EPAM1", Company.Type.INSOURCE);
//        companyS.addCompany(company);

//        Create and add customer
//        Customer customer = new Customer("Din1", 22);
//        customerS.addCustomer(customer);

//        Create and add developer
//        Developer developer = new Developer("Sam1", 22, 2200);
//        developerS.addDeveloper(developer);

//        Create and add project
//        Project project = new Project("Sters1", "Economical", 32000);
//        projectS.addProject(project);

//        Create and add skill
//        Skill skill = new Skill(Skill.Name.JAVA, Skill.Degree.SENIOR);
//        skillS.addSkill(skill);

////        Create javaMiddleSkill
//        Skill javaMiddleSkill = new Skill(Skill.Name.JAVA, Skill.Degree.MIDDLE);
//
////        Create getting project by "id"
//        Project project1 = projectS.getProjectById((long) 2);
//
////        get all salaries from "project1"
//        System.out.println(projectS.getAllSalaryFromProject(project1).toString());
//
////        get all developers from "project1"
//        projectS.getAllDevelopersFromProject(project1);
//
////        get all developers by skill name
//        developerS.getAllDevelopersBySkillName(javaMiddleSkill);
//
////        get all developers by skill degree
//        developerS.getAllDevelopersBySkillDegree(javaMiddleSkill);
//
////        get all project1
//        projectS.showAllProjects().forEach(p ->
//                System.out.println("date: " + p.toStringDate() + ";"
//                        + " name: " + p.getName() + ";"
//                        + " developers: " + projectS.showSomeDevs()));
    }
}
