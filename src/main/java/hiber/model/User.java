package hiber.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   @OneToOne(cascade = CascadeType.ALL)
   private Car car;

   public User(String firstName, String lastName, String email,Car car) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.car=car;
   }

   public String fioUser(){
      return lastName + " " + firstName;
   }
}
