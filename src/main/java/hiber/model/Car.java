package hiber.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name ="car")
public class Car {

    @Id
    @Column(name="car_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="model")
    private String model;

    @Column(name="series")
    private int series;


    @OneToOne(mappedBy = "car")
    private User owner;

    public Car (String model, int series){
        this.model = model;
        this.series = series;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series;
    }
}
