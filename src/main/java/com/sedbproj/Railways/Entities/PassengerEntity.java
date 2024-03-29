package com.sedbproj.Railways.Entities;

import org.apache.catalina.User;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Passenger", schema = "RailwaysV3", catalog = "")
public class PassengerEntity {
    @Id
    @Column(name = "SSN", nullable = false)
    private long ssn;
    private String fname;
    private String lname;
    private String phoneNum;
    private String email;
    private Date birthday;
    public PassengerEntity(){

    }

    public PassengerEntity(long ssn, String fname, String lname, String phoneNum, String email) {
        this.ssn = ssn;
        this.fname = fname;
        this.lname = lname;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    @OneToOne(mappedBy = "passenger", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private UserEntity usr;


    public long getSsn() {
        return ssn;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
    }

    @Basic
    @Column(name = "Fname", nullable = false, length = 45)
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Basic
    @Column(name = "Lname", nullable = false, length = 45)
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Basic
    @Column(name = "PhoneNum", nullable = true)
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Basic
    @Column(name = "Email", nullable = true, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Birthday", nullable = true)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerEntity that = (PassengerEntity) o;
        return ssn == that.ssn &&
                Objects.equals(fname, that.fname) &&
                Objects.equals(lname, that.lname) &&
                Objects.equals(phoneNum, that.phoneNum) &&
                Objects.equals(email, that.email) &&
                Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssn, fname, lname, phoneNum, email, birthday);
    }
}
