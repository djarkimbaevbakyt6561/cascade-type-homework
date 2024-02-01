package bakyt;

import bakyt.entities.Address;
import bakyt.entities.Company;
import bakyt.entities.Programmer;
import bakyt.entities.Project;
import bakyt.services.impls.AddressServiceImpl;
import bakyt.services.impls.CompanyServiceImpl;
import bakyt.services.impls.ProgrammerServiceImpl;
import bakyt.services.impls.ProjectServiceImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ProjectServiceImpl projectService = new ProjectServiceImpl();
        CompanyServiceImpl companyService = new CompanyServiceImpl();
        ProgrammerServiceImpl programmerService = new ProgrammerServiceImpl();
        AddressServiceImpl addressService = new AddressServiceImpl();
//        companyService.save(new Company("Adidas"));
//        Project project = new Project("Hello");
//        project.setCompany(companyService.getCompanyById(4L).orElseThrow(RuntimeException::new));
//        projectService.save(project);
//        Address address = new Address("Germany");
//        addressService.save(address);
//        Programmer programmer = new Programmer("Hello Bkytov", "email@gmail.com");
//        programmer.setAddress(addressService.getAddressById(11L).orElseThrow(RuntimeException::new));
//        programmerService.save(programmer);
//        companyService.delete(1L);
    }
}
