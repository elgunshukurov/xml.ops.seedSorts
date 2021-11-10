package xml.utils;

//import jwdc.xml.model.Employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeGenerator {

    private static final List<String> names = new ArrayList<>();
    private static final List<String> surnames = new ArrayList<>();

    static {
        names.add("Behruz");
        names.add("Tofiq");
        names.add("Niyaz");
        names.add("Memmed");
        names.add("Rahile");
        names.add("Asif");
        names.add("Dilare");
        names.add("Selale");
        names.add("Minare");
        names.add("Rauf");


        surnames.add("Eliyev");
        surnames.add("Sahbazov");
        surnames.add("Namazova");
        surnames.add("Nadirov");
        surnames.add("Veliyev");
        surnames.add("Resulov");
        surnames.add("Piriyev");
        surnames.add("Cunayev");
        surnames.add("Seferova");
        surnames.add("Babayev");
    }

//    public static List<Employee> generate(int count) {
//        List<Employee> employees = new ArrayList<>();
//        Random random = new Random();
//
//        for (int i = 0; i < count; i++) {
//            Employee employee = new Employee();
//            employee.setId(i + 1);
//            employee.setFirstName(names.get(random.nextInt(names.size())));
//            employee.setLastName(surnames.get(random.nextInt(surnames.size())));
//            employee.setSalary(BigDecimal.valueOf(2000 + random.nextDouble()* 1000));
//            employees.add(employee);
//        }
//
//        return employees;
//    }

}
