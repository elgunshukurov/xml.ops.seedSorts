package xml.model;

public class SeedHeader {
    private long id;
    private String name;
    private  String code;
    private  String hibrid_name;
    private  String patent_number;
    private  String start_date;
    private  String patent_owner;
    private  String end_date;
    private  String start_register_date;

    public SeedHeader() {

    }

    public SeedHeader(long id, String name, String code, String hibrid_name, String patent_number, String start_date, String patent_owner, String end_date, String start_register_date) {
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

    @Override
    public String toString() {
        return "SeedHeader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", hibrid_name='" + hibrid_name + '\'' +
                ", patent_number='" + patent_number + '\'' +
                ", start_date='" + start_date + '\'' +
                ", patent_owner='" + patent_owner + '\'' +
                ", end_date='" + end_date + '\'' +
                ", start_register_date='" + start_register_date + '\'' +
                '}';
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getPatent_owner() {
        return patent_owner;
    }

    public void setPatent_owner(String patent_owner) {
        this.patent_owner = patent_owner;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getStart_register_date() {
        return start_register_date;
    }

    public void setStart_register_date(String start_register_date) {
        this.start_register_date = start_register_date;
    }
}
