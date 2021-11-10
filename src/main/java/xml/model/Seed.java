package xml.model;

import java.time.LocalDate;

public class Seed {
    private long id;
    private String name;
    private  int code;
    private  String hibrid_name;
    private  String patent_number;
    private  LocalDate start_date;
    private  String patent_owner;
    private  LocalDate end_date;
    private  int start_register_date;

    public Seed() {
        this.id = 0;
        this.name = "";
        this.code = 0;
        this.hibrid_name = "";
        this.patent_number = "";
        this.start_date = LocalDate.EPOCH;
        this.patent_owner = "";
        this.end_date = LocalDate.EPOCH;
        this.start_register_date = 0;
    }

    public Seed(long id, String name, int code, String hibrid_name, String patent_number, LocalDate start_date,
                String patent_owner, LocalDate end_date, int start_register_date) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.hibrid_name = hibrid_name;
        this.patent_number = patent_number;
        this.start_date = start_date;
        this.patent_owner = patent_owner;
        this.end_date = end_date;
        this.start_register_date = start_register_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getHibrid_name() {
        return hibrid_name;
    }

    public void setHibrid_name(String hibrid_name) {
        this.hibrid_name = hibrid_name;
    }

    public String getPatent_number() {
        return patent_number;
    }

    public void setPatent_number(String patent_number) {
        this.patent_number = patent_number;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public String getPatent_owner() {
        return patent_owner;
    }

    public void setPatent_owner(String patent_owner) {
        this.patent_owner = patent_owner;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public int getStart_register_date() {
        return start_register_date;
    }

    public void setStart_register_date(int start_register_date) {
        this.start_register_date = start_register_date;
    }
}
