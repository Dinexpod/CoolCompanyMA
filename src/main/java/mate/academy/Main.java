package mate.academy;

import mate.academy.dao.CompanyDaoImpl;
import mate.academy.dao.CustomerDaoImpl;
import mate.academy.dao.DeveloperDaoImpl;
import mate.academy.dao.ProjectDaoImpl;
import mate.academy.dao.RoleDaoImpl;
import mate.academy.dao.SkillDaoImpl;
import mate.academy.models.Company;
import mate.academy.models.Customer;
import mate.academy.models.Developer;
import mate.academy.models.Project;
import mate.academy.models.Skill;
import mate.academy.services.CompanyService;
import mate.academy.services.CompanyServiceImpl;
import mate.academy.services.CustomerService;
import mate.academy.services.CustomerServiceImpl;
import mate.academy.services.DeveloperService;
import mate.academy.services.DeveloperServiceImpl;
import mate.academy.services.ProjectService;
import mate.academy.services.ProjectServiceImpl;
import mate.academy.services.RoleService;
import mate.academy.services.RoleServiceImpl;
import mate.academy.services.SkillService;
import mate.academy.services.SkillServiceImpl;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = ConnectionUtil.getConnection();

        CompanyService companyService = new CompanyServiceImpl(new CompanyDaoImpl(connection));
        CustomerService customerService = new CustomerServiceImpl(new CustomerDaoImpl(connection));
        DeveloperService developerService = new DeveloperServiceImpl(new DeveloperDaoImpl(connection));
        ProjectService projectService = new ProjectServiceImpl(new ProjectDaoImpl(connection));
        SkillService skillService = new SkillServiceImpl(new SkillDaoImpl(connection));
        RoleService roleService = new RoleServiceImpl(new RoleDaoImpl(connection));

////        Create and add company
//        Company company = new Company("EPAM1", Company.Type.INSOURCE);
//        companyService.addCompany(company);
//
////        Create and add customer
//        Customer customer = new Customer("Din1", 22);
//        customerService.addCustomer(customer);
//
////        Create and add developer
//        Developer developer = new Developer("Sam1", 22, 2200);
//        developerService.addDeveloper(developer);
//
////        Create and add project
//        Project project = new Project("Sters1", "Economical", 32000);
//        projectService.addProject(project);
//
////        Create and add skill
//        Skill skill = new Skill(Skill.Name.JAVA, Skill.Degree.SENIOR);
//        skillService.addSkill(skill);
//
////        Create javaMiddleSkill
//        Skill javaMiddleSkill = new Skill(Skill.Name.JAVA, Skill.Degree.MIDDLE);
//
////        Create getting project by "id"
//        Project project1 = projectService.getProjectById((long) 2);
//
////        get all salaries from "project1"
//        System.out.println(projectService.getAllSalaryFromProject(project1).toString());
//
////        get all developers from "project1"
//        projectService.getAllDevelopersFromProject(project1);
//
////        get all developers by skill name
//        developerService.getAllDevelopersBySkillName(javaMiddleSkill);
//
////        get all developers by skill degree
//        developerService.getAllDevelopersBySkillDegree(javaMiddleSkill);
//
////        get all project1
//        projectService.showAllProjects().forEach(p ->
//                System.out.println("date: " + p.toStringDate() + ";"
//                        + " name: " + p.getName() + ";"
//                        + " developers: " + projectService.showSomeDevs()));
    }
}
