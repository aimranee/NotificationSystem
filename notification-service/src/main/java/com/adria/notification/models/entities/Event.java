package com.adria.notification.models.entities;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event extends AbstractEntity {

    @Column(unique = true)
    private String eventName;
    private boolean editable;
    private String notificationType;
    private String subject;
    private String description;
    private String message;
    private String variables;
    private String language;
    @Lob
    @Type (type = "org.hibernate.type.TextType")
    private String emailMarkup;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String emailRenderedHtml;
    @ManyToOne
    private EmailProvider emailProvider;

}
