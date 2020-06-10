package dev.luanfernandes.view;

import dev.luanfernandes.controller.FileController;
import dev.luanfernandes.controller.IFileController;

import java.io.IOException;

public class FileManager {

  public static void main(String[] args) {
    IFileController arqCont = new FileController();
    String path = "../files/";
    String name = "relatorio";
    try {
      arqCont.readFile(path, name);
      arqCont.txtToCsv(path,name);
//      arqCont.createFile(path, name);
//      arqCont.readDir(path);
//      arqCont.openFile(path, name);
    } catch (IOException e) {

      e.printStackTrace();
    }

  }

}
