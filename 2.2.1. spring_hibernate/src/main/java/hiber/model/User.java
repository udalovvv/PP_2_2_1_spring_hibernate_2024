package hiber.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = "car")
@ToString(exclude = "car")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @NonNull
   @Column(name = "name")
   private String firstName;

   @NonNull
   @Column(name = "last_name")
   private String lastName;

   @NonNull
   @Column(name = "email")
   private String email;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "id", referencedColumnName = "id")
   private Car car;

   public User(String firstName, String lastName, String email, Car car) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.car = car;
   }
}
