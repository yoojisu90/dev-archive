public class MyStudent implements StudentUtil{
  @Override
  public int getTotalScore(Student student) {
    return student.getKorScore()+student.getEngScore()+student.getMathScore();
  }

  @Override
  public Student getHighScoreStudent(Student stu1, Student stu2) {
    return getTotalScore(stu1)>getTotalScore(stu2)? stu1:stu2;
  }

  @Override
  public String getGradeByStudentName(Student[] students, String name) {
    double avg = 0.0; //찾은 학생의 평균을 저장할 변수
    String grade = "학생 없음"; //학생의 등급을 저장할 변수
    for(Student e : students){
      if(e.getName().equals(name)){
        avg = getTotalScore(e) / 3.0;
        grade = getGradeByAvg(avg);
      }
    }
    return grade;
  }

  //평균으로 등급을 결정 후 리턴하는 메서드
  public String getGradeByAvg(double avg){
    String grade = "";
    if(avg>=90){
      grade = "A";
    }
    else if(avg>=80){
      grade = "B";
    }
    else if(avg>=70){
      grade = "C";
    }
    else{
      grade = "D";
    }
    return grade;
  }
}
