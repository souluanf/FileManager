package dev.luanfernandes.controller;

import java.io.IOException;
import java.util.ArrayList;

public interface IFileController {
	
	public void readDir(String path) throws IOException;
	public void createFile(String path, String name) throws IOException;
	public void readFile(String path, String name) throws IOException;
	public void openFile(String path, String name) throws IOException;
	public void txtToCsv(String path, String name) throws IOException;

}
