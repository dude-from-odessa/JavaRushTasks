package com.javarush.task.task19.task1917;

import java.io.*;


/* 
Свой FileWriter
*/

public class FileConsoleWriter {

    private FileWriter fileWriter;
    private PrintStream printStream = new PrintStream(System.out);

    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        this.fileWriter = new FileWriter(fd);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        char[] buffer = new char[len];
        int index = 0;
        for (int i = off; i < len + off; i++) {
            buffer[index++] = cbuf[i];
        }
        fileWriter.write(cbuf, off, len);
        printStream.print(buffer);
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        printStream.print((char) c);
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        printStream.print(str);
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        printStream.print(str.substring(off, off + len));
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        printStream.print(cbuf);
    }

    public void close() throws IOException {
        fileWriter.close();
        printStream.close();
    }

    public static void main(String[] args) {

    }
}
