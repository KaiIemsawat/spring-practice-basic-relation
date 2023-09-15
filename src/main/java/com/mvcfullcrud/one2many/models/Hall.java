package com.mvcfullcrud.one2many.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="halls")
public class Hall {

    /* ----- MODELS -----*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hallId;

    @NotBlank(message = "Hall name can't be blank")
    @Size(min=2, max=255, message="Hall name must be 2-255 characters")
    private String name;

    @NotNull(message = "Cannot be empty")
    @Min(value = 1, message = "Cannot be less than 1 floor")
    private Integer floors;

    @NotNull(message = "Must select whether this hall has housing")
    private Boolean hasResidential;

    @NotNull(message = "Must select whether this hall has lecture room")
    private Boolean hasLectureRoom;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateAt;

    /* ----- CREATE and UPDATE timestamps -----*/
    @PrePersist
    protected void onCreate() {
        this.createAt = new Date();
        this.updateAt = new Date();
    }

    @PreUpdate void onUpdate() {
        this.updateAt = new Date();
    }

    /* ----- CONSTRUCTORS -----*/
    public Hall() {}


}
