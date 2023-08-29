package com.userapi2.userappbackendrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="data")
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DataClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="key_val")
    @NotBlank(message = "Key cannot be empty")
    private String keyVal;
    @Column(name="val")
    @NotBlank(message = "Value cannot be blank")
    private String val;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name="person_id", referencedColumnName = "id")
    @JsonIgnore
    private Person person;

}
