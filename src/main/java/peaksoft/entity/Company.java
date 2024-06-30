package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "companies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ok_gen")
    @SequenceGenerator(name ="ok_gen",sequenceName = "ok_seq",allocationSize = 1,initialValue = 1)
    private Long id;
    @NotNull
    private String name;
    @Column(length = 20000)
    private String imageLink;
    @NotNull
    private String address;
    @NotNull
    private String country;
    @NotNull
    private String phoneNumber;

    @ManyToMany(mappedBy = "companies" ,cascade = {DETACH,REFRESH,MERGE})
    private List<Instructor> instructors = new ArrayList<>();
    @OneToMany(mappedBy = "company" ,cascade = {REMOVE,MERGE,REFRESH})
    private List<Course> courses = new ArrayList<>();


}
