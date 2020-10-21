package retalservice;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Collect_table")
public class Collect {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long rentalId;
    private String status;

    @PostPersist
    public void onPostPersist(){
        Collected collected = new Collected();
        BeanUtils.copyProperties(this, collected);
        collected.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getRentalId() {
        return rentalId;
    }

    public void setRentalId(Long rentalId) {
        this.rentalId = rentalId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
