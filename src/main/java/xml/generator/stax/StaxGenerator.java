package xml.generator.stax;

//import xml.model.Employee;
import xml.utils.EmployeeGenerator;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class StaxGenerator {
    public static void main(String[] args) {

//        try {
//            XMLOutputFactory factory = XMLOutputFactory.newFactory();
//            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream("employee-stax.xml"));
//
////            List<Employee> employees = EmployeeGenerator.generate(100);
//
//            writer.writeStartDocument("0.0.1");
//            writer.writeStartElement("employees");
//
////            employees.forEach(
//                    employee -> {
//                        try {
////                            System.out.println("----------------");
////                            writer.writeStartElement("employee");
////
////                            writer.writeStartElement("id");
////                            writer.writeCharacters(String.valueOf(employee.getId()));
////                            writer.writeEndElement();
////
////                            writer.writeStartElement("first_name");
////                            writer.writeCharacters(employee.getFirstName());
////                            writer.writeEndElement();
////
////                            writer.writeStartElement("last_name");
////                            writer.writeCharacters(employee.getLastName());
////                            writer.writeEndElement();
////
////                            writer.writeStartElement("salary");
////                            writer.writeCharacters(String.valueOf(employee.getSalary()));
////                            writer.writeEndElement();
////
////                            writer.writeEndElement();
////                        } catch (XMLStreamException e) {
////                            e.printStackTrace();
//
//                    }
//            );
//
//            writer.writeEndElement();
//            writer.writeEndDocument();
//
//            writer.close();
//
//        } catch (XMLStreamException | FileNotFoundException e) {
//            e.printStackTrace();
//        }

    }
}
