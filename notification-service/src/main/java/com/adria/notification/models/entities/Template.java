package com.adria.notification.models.entities;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Template extends AbstractEntity {

    private String subject;
    private String body;
    private String type;
    private String description;
    private String message;
    private String language;
    @Lob
    @Type (type = "org.hibernate.type.TextType")
    private String emailMarkup;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String emailRenderedHtml;
    @ManyToOne
    private Event event;
    @ManyToOne
    private EmailProvider emailProvider;

}
