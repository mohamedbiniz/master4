package com.master4.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min=3, message = "minimum 3 lettre")
    @Column(name = "title" )
    private String title;

    @Column(name = "body" )
    @Type(type="text")
    private String body;

    @Column(name="published",columnDefinition = "int default 0")
    private Boolean published;

    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified ;

    @ManyToOne
    private User user;

    @Size(min=1,message = "selectionner au moins une tag")
    @ManyToMany
    @JoinTable(name="articles_tags", joinColumns={@JoinColumn(referencedColumnName="id")}
            , inverseJoinColumns={@JoinColumn(referencedColumnName="id")})
    List<Tag> tagList;



}
