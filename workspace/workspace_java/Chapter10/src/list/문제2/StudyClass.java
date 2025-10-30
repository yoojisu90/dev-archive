package list.문제2;

import java.util.ArrayList;
import java.util.List;

public class StudyClass {
  private List<Student> student;
  private String className;
  private String teacher;

  public StudyClass(String className, String teacher){
    this.student = new ArrayList<>();
    this.className = className;
    this.teacher = teacher;
  }

  public void setStudent(List<Student> student) {
    this.student = student;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public void setTeacher(String teacher) {
    this.teacher = teacher;
  }

  public List<Student> getStudent() {
    return student;
  }
  public String getClassName() {
    return className;
  }
  public String getTeacher() {
    return teacher;
  }

  @Override
  public String toString() {
    return "StudyClass{" +
            "student=" + student +
            ", className='" + className + '\'' +
            ", teacher='" + teacher + '\'' +
            '}';
  }

  public void printInfoAll(){
    System.out.println(student.toString());
  }


  public double avgScore(){
    int sum =0;
    int cnt =0;
    for (int i=0; i< student.size(); i++){
      cnt++;
      sum = sum + student.get(i).getScore();
      System.out.println(student.get(i).getScore());
    }
    System.out.println("평균 점수 : " + sum/(double)cnt);
    return sum/(double)cnt;
  }

  public void topStudent(){
    Student topStudent = student.get(0);
    for (int i=0; i< student.size(); i++){
      if(student.get(i).getScore() > student.get(0).getScore()){
        topStudent = student.get(i);
        System.out.println("최고 학생 : " + student.get(i).getName());
        return;
      }
    }
  }


}
