package ru.converter.oauthdb.domains.user;


import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Immutable
public class Authority {

    @Id
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "roles_authorities", joinColumns = {
            @JoinColumn(name = "authority_name",
                    foreignKey = @ForeignKey(name = "roles_authorities_authority_name_fkey"), nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "role_code",
                    foreignKey = @ForeignKey(name = "roles_authorities_role_code_fkey"), nullable = false, updatable = false) })
    private List<Role> roles;

}
