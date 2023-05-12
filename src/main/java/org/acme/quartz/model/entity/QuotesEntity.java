package org.acme.quartz.model.entity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "quotes")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class QuotesEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "current_price")
    private Double c;

    @Column(name = "change_value")
    private Double d;

    @Column(name = "percent_change")
    private Double dp;

    @Column(name = "high")
    private Double h;

    @Column(name = "low")
    private Double l;

    @Column(name = "open_price")
    private Double o;

    @Column(name = "previous_close_price")
    private Double pc;
}





