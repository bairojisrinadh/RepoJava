package org.sri.JAXB.Driver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.sri.JAXB.model.Address;
import org.sri.JAXB.model.Company;
import org.sri.JAXB.model.Employee;

public class JAXBMarshalling {

	public static void main(String[] args) {
		Company company = init();
		File file = new File("C:\\Users\\bsrinadh\\workspace\\Learnings\\src\\employee.xml");
		marshallerJavaToXML(company,file);
		Company companyDetails = unmarshallerXMLToJava(file);
		System.out.println(companyDetails.toString());
	}

	public static Company init() {
		Address address1 = new Address();
		address1.setAddress("Boudhanagar");
		Address address2 = new Address();
		address2.setAddress("Warasiguda");
		List<Address> list1 = new ArrayList<>();
		list1.add(address1);
		list1.add(address2);

		List<Employee> list = new ArrayList<>();
		
		
		Employee emp1 = new Employee();
		emp1.setEmpName("Srinadh");
		emp1.setSalary(23849.93);
		emp1.setAge(24);
		emp1.setDept("Zurich-CH");
		emp1.setAddress(list1);

		list.add(emp1);
		
		Address address3 = new Address();
		address3.setAddress("Sitaphalmandi");
		Address address4 = new Address();
		address4.setAddress("Secunderabad");
		List<Address> list2 = new ArrayList<>();
		list2.add(address3);
		list2.add(address4);
		
		Employee emp2 = new Employee();
		emp2.setEmpName("Chethana");
		emp2.setSalary(28949.93);
		emp2.setAge(25);
		emp2.setDept("Mainframe");
		emp2.setAddress(list2);

		list.add(emp2);

		Company company = new Company();
		company.setCompanyName("CSC");
		company.setCompanyAddress("Mindspace");
		company.setEmpList(list);

		return company;
	}

	public static Company unmarshallerXMLToJava(File file) {
		Company companyDetails = null;
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(Company.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			companyDetails = (Company) unmarshaller.unmarshal(file);
		}catch(Exception ex){
			System.out.printf("Exception occured: %s", ex);
		}
		return companyDetails;
	}

	public static void marshallerJavaToXML(Company company, File file) {
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(Company.class);
			Marshaller marshaller = jaxbContext.createMarshaller();

			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(company, file);
			marshaller.marshal(company, System.out);
		}catch(Exception ex){
			System.out.printf("Exception occured: %s", ex);
		}

	}

}
