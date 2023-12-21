package com.company.MeTimesheet.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "workers")
public class Workers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "number")
    private int number;

    @Column(name = "email")
    private String email;

    @Column(name = "marine_days_on")
    private int marineDaysOn;

    @Column(name = "training_days")
    private int trainingDays;

    @Column(name = "sick_days")
    private int sickDays;

    @Column(name = "vacation_days")
    private int vacationDays;

    @Column(name = "unpaid_working_days")
    private int unpaidWorkingDays;

    @Column(name = "educational_vacation")
    private int educationalVacation;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public Workers() {

    }

    public Workers(Long id) {
        this.id = id;
    }

    public Workers(Long id, String firstName, String lastname, int number, String email, int marineDaysOn, int trainingDays, int sickDays, int vacationDays, int unpaidWorkingDays, int educationalVacation, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.number = number;
        this.email = email;
        this.marineDaysOn = marineDaysOn;
        this.trainingDays = trainingDays;
        this.sickDays = sickDays;
        this.vacationDays = vacationDays;
        this.unpaidWorkingDays = unpaidWorkingDays;
        this.educationalVacation = educationalVacation;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMarineDaysOn() {
        return marineDaysOn;
    }

    public void setMarineDaysOn(int marineDaysOn) {
        this.marineDaysOn = marineDaysOn;
    }

    public int getTrainingDays() {
        return trainingDays;
    }

    public void setTrainingDays(int trainingDays) {
        this.trainingDays = trainingDays;
    }

    public int getSickDays() {
        return sickDays;
    }

    public void setSickDays(int sickDays) {
        this.sickDays = sickDays;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    public int getUnpaidWorkingDays() {
        return unpaidWorkingDays;
    }

    public void setUnpaidWorkingDays(int unpaidWorkingDays) {
        this.unpaidWorkingDays = unpaidWorkingDays;
    }

    public int getEducationalVacation() {
        return educationalVacation;
    }

    public void setEducationalVacation(int educationalVacation) {
        this.educationalVacation = educationalVacation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Workers workers)) return false;
        return getNumber() == workers.getNumber() && getMarineDaysOn() == workers.getMarineDaysOn() && getTrainingDays() == workers.getTrainingDays() && getSickDays() == workers.getSickDays() && getVacationDays() == workers.getVacationDays() && getUnpaidWorkingDays() == workers.getUnpaidWorkingDays() && getEducationalVacation() == workers.getEducationalVacation() && Objects.equals(getId(), workers.getId()) && Objects.equals(getFirstName(), workers.getFirstName()) && Objects.equals(getLastname(), workers.getLastname()) && Objects.equals(getEmail(), workers.getEmail()) && Objects.equals(getUsername(), workers.getUsername()) && Objects.equals(getPassword(), workers.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastname(), getNumber(), getEmail(), getMarineDaysOn(), getTrainingDays(), getSickDays(), getVacationDays(), getUnpaidWorkingDays(), getEducationalVacation(), getUsername(), getPassword());
    }

    @Override
    public String toString() {
        return "Workers{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", number=" + number +
                ", email='" + email + '\'' +
                ", marineDaysOn=" + marineDaysOn +
                ", trainingDays=" + trainingDays +
                ", sickDays=" + sickDays +
                ", vacationDays=" + vacationDays +
                ", unpaidWorkingDays=" + unpaidWorkingDays +
                ", educationalVacation=" + educationalVacation +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


