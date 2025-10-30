package com.green.backend_shop.util;

import com.green.backend_shop.book.controller.BookController;
import com.green.backend_shop.book.dto.BookImgDTO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//파일 업로드 기능을 제공하는 클래스
public class FileUploadUtil {

  //단일 파일 업로드 기능
  public static BookImgDTO fileUpload(MultipartFile img){
    // 1) 파일 업로드 경로 지정
    String uploadPath = "D:\\01-STUDY\\dev\\workspace\\workspace_spring\\backend_shop\\src\\main\\resources\\static\\upload\\";

    // 2) 파일명 중복방지를 위해 업로드할 파일명을 세팅
    String attachedFileName = UUID.randomUUID().toString();

    //String testName = "abc.jpg";
    //testName.substring(3); //.jpg
    //testName.lastIndexOf("."); //특정 문자의 가장 마지막 index를 파악

    //원본 파일의 확장자 추출
    int index = img.getOriginalFilename().lastIndexOf(".");
    String extension = img.getOriginalFilename().substring(index);

    //완성된 업로드할 파일명
    attachedFileName = attachedFileName + extension;

    // 3) 파일 업로드
    //java.io.File
    //파일이 생성될 경로와 파일명을 세팅
    File f = new File(uploadPath + attachedFileName);

    //세팅된 경로와 파일명을 실제 파일로 변환
    try{
      img.transferTo(f);
    }catch(Exception e){
      System.out.println(e);
    }

    //BOOK_IMG INSERT에 필요한 데이터를 리턴한다.
    BookImgDTO bookImgDTO = new BookImgDTO();
    bookImgDTO.setOriginImgName(img.getOriginalFilename());
    bookImgDTO.setAttachedImgName(attachedFileName);
    bookImgDTO.setIsMain("Y");
    return bookImgDTO;

  }

  //다중 파일 업로드 기능
  //매개변수로 업로드할 파일이 여러개 배열 형태로 전달 됨
  public static List<BookImgDTO> multipleFileUpload(MultipartFile[] imgs){
    //리턴되는 모든 데이터를 저장할 list
    List<BookImgDTO> imgList = new ArrayList<>();

    for(MultipartFile img : imgs){
      BookImgDTO imgDTO = fileUpload(img); //여러번
      imgDTO.setIsMain("N");
      imgList.add(imgDTO);
    }
    return imgList;
  }
}
