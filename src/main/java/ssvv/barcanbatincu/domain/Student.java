package ssvv.barcanbatincu.domain;

public class Student implements HasId<String>{
    private String id;
    private String name;
    private int group;
    private String email;
    private String professor;

    public Student() {
        this.id = "";
        this.name = "";
        int group = -1;
        this.email = "";
        this.professor = "";
    }

    public Student(String id, String name, int group, String email, String professor) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.email = email;
        this.professor = professor;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", group=" + group +
                ", email='" + email + '\'' +
                ", professor='" + professor + '\'' +
                '}';
    }
}
