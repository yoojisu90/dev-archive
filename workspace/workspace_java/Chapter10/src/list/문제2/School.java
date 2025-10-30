package list.문제2;

import java.util.ArrayList;
import java.util.List;

public class School {
  private List<StudyClass> studyClass;

  public School(){
    this.studyClass = new ArrayList<>();
  }

  public void setStudyClass(List<StudyClass> studyClass){
    this.studyClass = studyClass;
  }

  public void printInfoTeacher(String teacher){
    for(int i=0; i<studyClass.size(); i++){
      if(studyClass.get(i).getTeacher().equals(teacher)) {
        System.out.println(studyClass.get(i));
      }
    }
  }

  public void printInfoScore(){
    int sum = 0;
    int cnt = 0;
    for(int i=0; i<studyClass.size(); i++){
      sum = (int) (sum + studyClass.get(i).avgScore());
      cnt++;
//      System.out.println(studyClass.get(i).avgScore());
    }
    System.out.println("전체 학급 평균 점수 : " + sum/(double)cnt);
  }

  public void infoTopStudent(){
    StudyClass topStu = studyClass.get(0);
    for (int i=0; i<studyClass.size(); i++){
      Student topSt = studyClass.get(i).getStudent().get(0);
      for(int j = 0; j < studyClass.get(0).getStudent().size() ; i++){
        studyClass.get(0).getStudent().get(j).getScore();
        if(studyClass.get(0).getStudent().get(j).getScore() > studyClass.get(0).getStudent().get(0).getScore()) {
          System.out.println("반에서 최고 성적 가진 학생 : " + studyClass.get(0).getStudent().get(j).getName());
        }
      }
      for(int j = 0; j < studyClass.get(i).getStudent().size() ; i++){
        studyClass.get(1).getStudent().get(j).getScore();
        if(studyClass.get(1).getStudent().get(j).getScore() > studyClass.get(1).getStudent().get(0).getScore()) {
          System.out.println("반에서 최고 성적 가진 학생 : " + studyClass.get(1).getStudent().get(j).getName());
        }
      }
      for(int j = 0; j < studyClass.get(i).getStudent().size() ; i++){
        studyClass.get(2).getStudent().get(j).getScore();
        if(studyClass.get(2).getStudent().get(j).getScore() > studyClass.get(2).getStudent().get(0).getScore()) {
          System.out.println("반에서 최고 성적 가진 학생 : " + studyClass.get(2).getStudent().get(j).getName());
        }
      }

    }
  }




}
