package com.example.todoapp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Data  //gettery, settery, toString, hashCode, equals
@Table(name = "todo")
public class Models {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title" ,unique = true, nullable = false) //unikalne+nie może być nullem
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date date;

    //ustawiać automatycznie jako false (niewykonano) przy dodawaniu nowego zadania
    @Column(name = "status")
    private boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String status(){
        return status? "Done": "To do!";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Models models = (Models) o;
        return status == models.status &&
                Objects.equals(id, models.id) &&
                Objects.equals(title, models.title) &&
                Objects.equals(description, models.description) &&
                Objects.equals(date, models.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, date, status);
    }

    @Override
    public String toString() {
        return "Models: " +
                " Id: " + id +
                " Title: " + title + '\'' +
                " Description: " + description + '\'' +
                " Date: " + date +
                " Status: " + status;
    }

    public void addAttribute(String models, List<Models> modelsList) {

    }
}
