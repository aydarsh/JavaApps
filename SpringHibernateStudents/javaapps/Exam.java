package javaapps;

public class Exam {
    private Integer id;
    private String c_no;
    private Integer score;

    public Exam(){}
    public Exam(Integer id, String c_no, Integer score){
        this.id = id;
        this.c_no = c_no;
        this.score = score;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setC_no(String name) {
        this.c_no = c_no;
    }

    public String getC_no() {
        return c_no;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

}
