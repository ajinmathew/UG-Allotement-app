package com.mgc.allotmentug;

public class Student {
    public String name;
    public String age;
    public String registerno;
    public String gender;
    public String department;
    public String obtainedmark;
    public String totalmark;
    public String stream;
    public String disaster;
    public String accounting;
    public String web;
    public String maths;
    public String email;
    public String password;
    public String verify;
    public String opencourse;
    public String indexmark;

    public Student() {
    }

    public Student(String verify) {
        this.verify = verify;
    }

    public Student(String name, String age, String registerno, String gender, String department, String obtainedmark, String totalmark, String stream, String disaster, String accounting, String web, String maths, String email, String password, String verify, String opencourse, String indexmark) {
        this.name = name;
        this.age = age;
        this.registerno = registerno;
        this.gender = gender;
        this.department = department;
        this.obtainedmark = obtainedmark;
        this.totalmark = totalmark;
        this.stream = stream;
        this.disaster = disaster;
        this.accounting = accounting;
        this.web = web;
        this.maths = maths;
        this.email = email;
        this.password = password;

        this.indexmark=indexmark;
        this.verify = verify;
        this.opencourse = opencourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRegisterno() {
        return registerno;
    }

    public void setRegisterno(String registerno) {
        this.registerno = registerno;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getObtainedmark() {
        return obtainedmark;
    }

    public void setObtainedmark(String obtainedmark) {
        this.obtainedmark = obtainedmark;
    }

    public String getTotalmark() {
        return totalmark;
    }

    public void setTotalmark(String totalmark) {
        this.totalmark = totalmark;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getDisaster() {
        return disaster;
    }

    public void setDisaster(String disaster) {
        this.disaster = disaster;
    }

    public String getAccounting() {
        return accounting;
    }

    public void setAccounting(String accounting) {
        this.accounting = accounting;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getMaths() {
        return maths;
    }

    public void setMaths(String maths) {
        this.maths = maths;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getOpencourse() {
        return opencourse;
    }

    public void setOpencourse(String opencourse) {
        this.opencourse = opencourse;
    }

    public String getIndexmark() {
        return indexmark;
    }

    public void setIndexmark(String indermark) {
        this.indexmark = indermark;
    }
}
