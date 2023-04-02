package org.acme.quartz.model.entity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "extensions")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ExtensionsEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String shortName;
    public ExtensionsEntity(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }
}





