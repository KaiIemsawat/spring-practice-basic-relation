package com.mvcfullcrud.one2many.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="universities")
public class University {

    /* ----- MODELS -----*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_id")
    private Long universityId;

    @NotBlank(message = "City can not be empty")
    @Size(min=2, max=255, message = "City name need to be in between 2 - 255 characters")
    private String city;

    @NotBlank(message = "University can not be empty")
    @Size(min=3, max=255, message = "University name need to be in between 3 - 255 characters")
    private String name;

    @NotNull(message = "The enrollment can't be empty")
    @Min(value = 1, message = "Must have at least a student")
    private Integer enrollment;

    @NotNull(message = "Must select if online classes are provided")
    private boolean hasOnline;
//    Be careful when naming boolean variable.
//    If name 'isOnline' the autogenerate setter method may not change name to 'isIsOnline()'
//    And that would cause issues

    @NotNull(message = "Must select if in person classes are provided")
    private boolean hasInPerson;

    @NotNull(message = "Year of established can't be empty")
    @Min(value = 1000, message = "Our record is not allow any university older that the established year of 1000")
    private Integer yearFounded;


    /* ----- Connection / Relation -----*/
    @OneToMany(mappedBy = "university", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    Name from 'mappedBy = "thisName' need to match with the name of
//    'private ThisModel thisName' in another model class. (Hall class in this case)
    private List<Hall> halls;


    /* ----- CREATE and UPDATE timestamps -----*/
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    /* ----- CONSTRUCTORS -----*/
    public University(){} // empty constructor is also needed
    public University(String city, String name, Integer enrollment, boolean hasOnline, boolean hasInPerson, Integer yearFounded, List<Hall> halls) {
        this.city = city;
        this.name = name;
        this.enrollment = enrollment;
        this.hasOnline = hasOnline;
        this.hasInPerson = hasInPerson;
        this.yearFounded = yearFounded;
        this.halls = halls;
    }

    /* ----- GETTERS and SETTERS -----*/
    public Long getUniversityId() {
        return universityId;
    }
    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getEnrollment() {
        return enrollment;
    }
    public void setEnrollment(Integer enrollment) {
        this.enrollment = enrollment;
    }

    public boolean isHasOnline() {
        return hasOnline;
    }

    public void setHasOnline(boolean hasOnline) {
        this.hasOnline = hasOnline;
    }

    public boolean isHasInPerson() {
        return hasInPerson;
    }

    public void setHasInPerson(boolean hasInPerson) {
        this.hasInPerson = hasInPerson;
    }

    public Integer getYearFounded() {
        return yearFounded;
    }
    public void setYearFounded(Integer yearFounded) {
        this.yearFounded = yearFounded;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Hall> getHalls() {
        return halls;
    }
    public void setHalls(List<Hall> halls) {
        this.halls = halls;
    }
}
