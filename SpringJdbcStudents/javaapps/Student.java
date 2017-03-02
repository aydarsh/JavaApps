package javaapps;

public class Student {
    private Integer s_id;
    private String name;
    private Integer start_year;

    public void setS_id(Integer s_id){
        this.s_id = s_id;
    }

    public Integer getS_id(){
        return s_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStart_year(Integer start_year) {
        this.start_year = start_year;
    }

    public Integer getStart_year() {
        return start_year;
    }

}
