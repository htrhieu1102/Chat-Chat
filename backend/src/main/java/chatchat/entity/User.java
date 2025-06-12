package chatchat.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;


}
