package ru.converter.oauthdb.domains.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;



@Data
@Entity
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    public Role(String code) {
        this.code = code;
    }

    @Id
    private String code;
    private String description;

    @Fetch(FetchMode.JOIN)
    @ElementCollection(targetClass = AuthoritiesEnum.class, fetch = FetchType.EAGER)
    @CollectionTable(name="roles_authorities",
            joinColumns = { @JoinColumn(name = "role_code") })
    @Column(name="authority_name")
    @Enumerated(EnumType.STRING)
    private Set<AuthoritiesEnum> authorities;

}
