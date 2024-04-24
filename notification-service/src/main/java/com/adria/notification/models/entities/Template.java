package com.adria.notification.models.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Template extends AbstractEntity{

    private String subject;
    private String body;
    private String type;
    private String description;
    private String message;
    private String language;
    private String emailMarkup;
    private String emailRenderedHtml;
    @OneToOne
    private Event event;

}
