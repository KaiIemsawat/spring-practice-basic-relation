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


    /* ----- Connection / Relation -----*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id")
    private University university;
//    'private ThisModel thisName' <-- thisName need to match with the one with @OneToMany


    /* ----- CREATE and UPDATE timestamps -----*/
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateAt;

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
    public Hall(String name, Integer floors, Boolean hasResidential, Boolean hasLectureRoom, University university) {
        this.name = name;
        this.floors = floors;
        this.hasResidential = hasResidential;
        this.hasLectureRoom = hasLectureRoom;
        this.university = university;
    }

    /* ----- GETTERS and SETTERS -----*/

    public Long getHallId() {
        return hallId;
    }
    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getFloors() {
        return floors;
    }
    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    public Boolean getHasResidential() {
        return hasResidential;
    }
    public void setHasResidential(Boolean hasResidential) {
        this.hasResidential = hasResidential;
    }

    public Boolean getHasLectureRoom() {
        return hasLectureRoom;
    }
    public void setHasLectureRoom(Boolean hasLectureRoom) {
        this.hasLectureRoom = hasLectureRoom;
    }

    public University getUniversity() {
        return university;
    }
    public void setUniversity(University university) {
        this.university = university;
    }

    public Date getCreateAt() {
        return createAt;
    }
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
