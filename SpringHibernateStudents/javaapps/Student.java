package javaapps;

public class Student {
    private Integer id;
    private String name;
    private Integer start_year;

    public Student(){}
    public Student(Integer s_id, String name, Integer start_year){
        this.id = s_id;
        this.name = name;
        this.start_year = start_year;
    }

    public void setId(int s_id){
        this.id = s_id;
    }

    public int getId() {
        return id;
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
