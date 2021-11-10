package xml.parser.stax;

import jdbc.connection.JDBCConnection;
import jdbc.write.DatabaseAdder;
import xml.model.Seed;
import xml.model.SeedBody;
import xml.model.SeedHeader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class SeedStaxParserMain {
    public static void main(String[] args) {

        Properties properties = new Properties();
        Connection connection = null;
        try {
            properties.load(new FileInputStream("configg.properties"));

            String driver = properties.getProperty("jdbc.driver");
            String url = properties.getProperty("jdbc.url");
            String username = properties.getProperty("jdbc.username");
            String password = properties.getProperty("jdbc.password");

            Class.forName(driver);  // Driver class ini yukleyir

            connection = DriverManager.getConnection(url, username, password); // Driver e connection yaradir

            System.out.println("Database ile elaqe yarandi");


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver yuklene bilmedi!");
            e.printStackTrace();
        } catch (SQLException throwables) {
            System.out.println("Driver e connection yarana bilmedi");
            throwables.printStackTrace();
        }




        try {

            String xml = "seeds.xml";
            XMLInputFactory inputFactory = XMLInputFactory.newFactory();
            XMLStreamReader reader = inputFactory.createXMLStreamReader(new FileInputStream(xml));

            SeedHeader seedHeader = null;
            List<Seed> seeds = SeedBody.getSeeds();
            Seed seed = null;

            Map<String, Boolean> keys = new HashMap<>();
            keys.put("header", false);
            keys.put("body", false);
            keys.put("SEED", false);
            keys.put("ID", false);
            keys.put("NAME", false);
            keys.put("CODE", false);
            keys.put("HIBRID_NAME", false);
            keys.put("PATENT_NUMBER", false);
            keys.put("START_DATE", false);
            keys.put("PATENT_OWNER", false);
            keys.put("END_DATE", false);
            keys.put("START_REGISTER_DATE", false);

            while (reader.hasNext()) {
                int eventType = reader.getEventType();

                if (eventType == XMLStreamConstants.START_DOCUMENT) {
                    System.out.println("Senedi oxumaga basladiq");

                } else if (eventType == XMLStreamConstants.START_ELEMENT) {
                    String lName = reader.getLocalName();
//                    System.out.println(lName + " Elementi oxumaga basladiq");
                    keys.put(lName, true);

                    if (keys.get("header" ) && seedHeader == null) {
                        seedHeader = new SeedHeader();
                    }
                    if (keys.get("SEED") && seed == null) {
                        seed = new Seed();
                    }

                } else if (eventType == XMLStreamConstants.CHARACTERS) {
                    if (keys.get("header")) {
                        String data = reader.getText();

                        // header in elementlerini oxu
                        if (keys.get("ID")) {
                            seedHeader.setId(Long.parseLong(data));
                        } else if (keys.get("NAME")) {
                            seedHeader.setName(data);
                        } else if (keys.get("CODE")) {
                            seedHeader.setCode(data);
                        } else if (keys.get("HIBRID_NAME")) {
                            seedHeader.setHibrid_name(data);
                        } else if (keys.get("PATENT_NUMBER")) {
                            seedHeader.setPatent_number(data);
                        } else if (keys.get("START_DATE")) {
                            seedHeader.setStart_date(data);
                        } else if (keys.get("PATENT_OWNER")) {
                            seedHeader.setPatent_owner(data);
                        } else if (keys.get("END_DATE")) {
                            seedHeader.setEnd_date(data);
                        } else if (keys.get("START_REGISTER_DATE")) {
                            seedHeader.setStart_register_date(data);
                        }
                    }

                    // body elementlerini oxu
                    if (keys.get("SEED")) {
                        String data = reader.getText();

                        if (keys.get("ID")) {
                            seed.setId(Long.parseLong(data));
                        } else if (keys.get("NAME")) {
                            seed.setName(data);
                        } else if (keys.get("CODE")) {
                            seed.setCode(Integer.parseInt(data));
                        } else if (keys.get("HIBRID_NAME")) {
                            seed.setHibrid_name(data);
                        } else if (keys.get("PATENT_NUMBER")) {
                            seed.setPatent_number(data);
                        } else if (keys.get("START_DATE")) {
                            seed.setStart_date(LocalDate.parse(data));
                        } else if (keys.get("PATENT_OWNER")) {
                            seed.setPatent_owner(data);
                        } else if (keys.get("END_DATE")) {
                            seed.setEnd_date(LocalDate.parse(data));
                        } else if (keys.get("START_REGISTER_DATE")) {
                            seed.setStart_register_date(Integer.parseInt(data));
                        }
                    }

                } else if (eventType == XMLStreamConstants.END_ELEMENT) {
                    String lName = reader.getLocalName();
                    keys.put(lName, false);
                    if (lName.equals("SEED")) {
                        SeedBody.setSeeds(seed);
                        seed = null;
                    }


                } else if (eventType == XMLStreamConstants.END_DOCUMENT) {
                    System.out.println("Senedi oxumagi bitirdik");
                }
                reader.next();
            }

            Connection finalConnection = connection;
            seeds.forEach(bod -> JDBCConnection.connect(finalConnection, bod.getId(), bod.getName(), bod.getCode() ,
                    bod.getHibrid_name(), bod.getPatent_number(), bod.getStart_date(), bod.getPatent_owner(),
                    bod.getEnd_date(), bod.getStart_register_date()));

            System.out.println("---------------------");

            System.out.println(seedHeader);
            System.out.println("---------------------");
            seeds.forEach(bod -> System.out.printf(("%s %s %s %s %s %s %s %s %s\n"), bod.getId(), bod.getName(), bod.getCode() ,
                    bod.getHibrid_name(), bod.getPatent_number(), bod.getStart_date(), bod.getPatent_owner(),
                    bod.getEnd_date(), bod.getStart_register_date() ));
            System.out.println("---------------------");

        } catch (XMLStreamException | FileNotFoundException | NullPointerException e) {
            e.printStackTrace();
        }

    }
}
