package list.문제2;

import java.util.ArrayList;
import java.util.List;

public class SchoolTest {
  public static void main(String[] args) {
    List<Student> stuList1 = new ArrayList<>();
    stuList1.add(new Student("aa", 20, 80));
    stuList1.add(new Student("bb", 25, 70));
    stuList1.add(new Student("cc", 30, 90));

    StudyClass studyClass1 = new StudyClass("자바반", "김자바");
    studyClass1.setStudent(stuList1);

    List<Student> stuList2 = new ArrayList<>();
    stuList2.add(new Student("dd", 25, 80));
    stuList2.add(new Student("ee", 40, 60));
    stuList2.add(new Student("ff", 30, 70));

    StudyClass studyClass2 = new StudyClass("파이썬반", "김파이썬");
    studyClass2.setStudent(stuList2);

    List<Student> stuList3 = new ArrayList<>();
    stuList3.add(new Student("gg", 20, 90));
    stuList3.add(new Student("hh", 30, 85));
    stuList3.add(new Student("ii", 40, 85));

    StudyClass studyClass3 = new StudyClass("C언어반", "이언어");
    studyClass3.setStudent(stuList3);

    List<StudyClass> teaList = new ArrayList<>();
    teaList.add(studyClass1);
    teaList.add(studyClass2);
    teaList.add(studyClass3);

    School school = new School();
    school.setStudyClass(teaList);

    school.printInfoTeacher("김자바");
    System.out.println();

    school.printInfoScore();
    System.out.println();

    school.infoTopStudent();
  }
}
