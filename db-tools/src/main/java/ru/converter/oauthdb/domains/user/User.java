package ru.converter.oauthdb.domains.user;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import ru.converter.oauthdb.domains.BaseEntity;

import javax.persistence.*;
import java.util.UUID;



@Data
@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User  {

    @Id
    @GenericGenerator(name = "id", strategy = "uuid2")
    private UUID id;


    @Column(name = "login")
    private String login;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_code")
    private Role role;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;
}
