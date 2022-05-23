package dk.via.sep4.models;

import com.sun.istack.NotNull;
import dk.via.sep4.models.Sensor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Ravneet
 */
@Entity
@Table
public class Temperature {
  @Id
  @GeneratedValue(generator = "sequence-generator")
  @GenericGenerator(
          name = "sequence-generator",
          strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
          parameters = {
                  @org.hibernate.annotations.Parameter(name = "sequence_name", value = "temperature_sequence"),
                  @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                  @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
          }
  )
  private Long id;
  @Column
  @NotNull
  private double value;

  @OneToOne(mappedBy = "temperature")
  private Sensor sensor;

  public Temperature() {
  }

  public Temperature(double value) {
    this.value = value;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }
}