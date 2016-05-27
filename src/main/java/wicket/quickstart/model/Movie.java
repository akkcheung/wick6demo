package wicket.quickstart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name="tb_movie")
public class Movie implements Serializable {
	
    private String title = null;
    private Integer year = null;

		// @Transient    
		@Column(columnDefinition = "BOOLEAN DEFAULT FALSE NOT NULL")
		//@Column(columnDefinition = "BIT", length = 1)
    private Boolean checked;
    
    @Id
		@GeneratedValue
    private Integer id = null;

    public Movie() {
    }

    public Movie(String title) {
        this.setTitle(title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getYear() {
        return this.year;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

		// public boolean isChecked()
		 public Boolean isChecked()
    {
            return checked;
    }

 		// public void setChecked(boolean checked)
 		public void setChecked(Boolean checked)
    {
            this.checked = checked;
    }

}
