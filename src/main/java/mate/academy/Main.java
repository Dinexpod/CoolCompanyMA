package mate.academy;

import mate.academy.dao.CompanyDaoImpl;
import mate.academy.dao.CustomerDaoImpl;
import mate.academy.dao.DeveloperDaoImpl;
import mate.academy.dao.ProjectDaoImpl;
import mate.academy.dao.RoleDaoImpl;
import mate.academy.dao.SkillDaoImpl;
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

        CompanyService companyS = new CompanyServiceImpl(new CompanyDaoImpl(connection));
        CustomerService customerS = new CustomerServiceImpl(new CustomerDaoImpl(connection));
        DeveloperService developerS = new DeveloperServiceImpl(new DeveloperDaoImpl(connection));
        ProjectService projectS = new ProjectServiceImpl(new ProjectDaoImpl(connection));
        SkillService skillS = new SkillServiceImpl(new SkillDaoImpl(connection));
        RoleService roleS = new RoleServiceImpl(new RoleDaoImpl(connection));

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
