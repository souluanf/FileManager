package dev.luanfernandes.controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FileController implements IFileController {

  public FileController() {
    super();
  }

  @Override
  public void readDir(String path) throws IOException {
    File dir = new File(path);
    if (dir.exists() && dir.isDirectory()) {
      File[] files = dir.listFiles();
      for (File f : files) {
        if (f.isFile()) {
          System.out.println("      \t" + f.getName());
        } else {
          System.out.println("<DIR> \t" + f.getName());
        }
      }
    } else {
      throw new IOException("Invalid directory!");
    }
  }


  @Override
  public void createFile(String path, String name) throws IOException {
    File dir = new File(path);
    File file = new File(path, name+".txt");
    if (dir.exists() && dir.isDirectory()) {
      boolean exist = false;
      if (file.exists()) {
        exist = true;
      }
      String content = generateText();
      FileWriter fileWriter = new FileWriter(file, exist);
      PrintWriter print = new PrintWriter(fileWriter);
      print.write(content);
      print.flush();
      print.close();
      fileWriter.close();
    } else {
      throw new IOException("Invalid directory!");
    }
  }

  private String generateText() {
    StringBuffer buffer = new StringBuffer();
    String line = "";
    while (!line.equalsIgnoreCase("end")) {
      line = JOptionPane.showInputDialog(null, "Enter a phrase",
              "Input textInput", JOptionPane.INFORMATION_MESSAGE);
      if (!line.equalsIgnoreCase("end")) {
        buffer.append(line).append("\r\n");
      }
    }
    return buffer.toString();
  }

  @Override
  public void readFile(String path, String name) throws IOException {
    File file = new File(path, name+".txt");
    if (file.exists() && file.isFile()) {
      FileInputStream flow = new FileInputStream(file);
      InputStreamReader reader = new InputStreamReader(flow);
      BufferedReader buffer = new BufferedReader(reader);
      String line = buffer.readLine();
      while (line != null) {
        System.out.println(line);
        line = buffer.readLine();
      }
      buffer.close();
      reader.close();
      flow.close();
    } else {
      throw new IOException("Invalid file!");
    }
  }

  @Override
  public void txtToCsv(String path, String name) throws IOException {
    ArrayList<String> dataText = new ArrayList<>();
    File txtFile = new File(path, name+".txt");
    if (txtFile.exists() && txtFile.isFile()) {
      FileInputStream flow = new FileInputStream(txtFile);
      InputStreamReader reader = new InputStreamReader(flow);
      BufferedReader buffer = new BufferedReader(reader);
      String line = buffer.readLine();
      while (line != null) {
        dataText.add(line);
        line = buffer.readLine();
      }
      FileWriter fileWriter = new FileWriter(new File(path, name+".csv"));
      PrintWriter print = new PrintWriter(fileWriter);
      for (String text:dataText){
        print.write(text+"\r\n");
      }
      print.flush();
      print.close();
      fileWriter.close();
      buffer.close();
      reader.close();
      flow.close();
    } else {
      throw new IOException("Invalid file!");
    }
  }

  @Override
  public void openFile(String path, String name) throws IOException {
    File file = new File(path, name);
    if (file.exists() && file.isFile()) {
      Desktop desk = Desktop.getDesktop();
      desk.open(file);
    } else {
      throw new IOException("Invalid file!");
    }
  }


}
