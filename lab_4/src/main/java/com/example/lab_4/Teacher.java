package com.example.lab_4;

public class Teacher {
    private String name;

    private Integer experience;
    private String workTime;
    private String subjects;
    private String classes;

    public Teacher() {

    }

    public Teacher(String name, Integer experience, String workTime, String subjects, String classes) {
        this.name = name;
        this.experience = experience;
        this.workTime = workTime;
        this.subjects = subjects;
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return name + ',' + experience + ',' + workTime +
                ',' + subjects + ',' + classes;
    }
}
