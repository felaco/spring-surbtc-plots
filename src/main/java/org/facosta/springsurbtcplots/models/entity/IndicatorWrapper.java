package org.facosta.springsurbtcplots.models.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.facosta.springsurbtcplots.utils.indicatorUtilities.Source;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(exclude = {"user"})
@ToString(exclude = "user")
@Entity
public class IndicatorWrapper
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserModel user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "indicator_id")
    private Indicator indicator;

    @OneToMany(mappedBy = "indicatorWrapper",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<IndicatorParam> params = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @NotNull
    Source source = Source.CLOSE;

    public IndicatorWrapper()
    {
    }
}
