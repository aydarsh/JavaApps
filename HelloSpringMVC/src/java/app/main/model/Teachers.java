package app.main.model;
// Generated Mar 15, 2017 3:38:13 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Teachers generated by hbm2java
 */
@Entity
@Table(name="teachers"
    ,schema="public"
)
public class Teachers  implements java.io.Serializable {


     private int id;
     private String name;

    public Teachers() {
    }

	
    public Teachers(int id) {
        this.id = id;
    }
    public Teachers(int id, String name) {
       this.id = id;
       this.name = name;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="name")
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }




}


