//package com.personal.spring_prac.design_pattern.Facade;
//
//public class FacadeTest {
//
//    public static void main(String[] args) {
//
//        /*
//        Facade 패턴 사용하지 않을 경우 예
//
//        Ftp ftpClient = new Ftp("www.Roy.com", 22, "/home/etc");
//        ftpClient.connect();
//        ftpClient.moveDirectory();
//
//        Writer writer = new Writer("test.txt");
//        writer.fileConnect();
//        writer.fileWrite();
//
//        Reader reader = new Reader("test.txt");
//        reader.fileConnect();
//        reader.fileRead();
//
//        reader.fileDisconnect();
//        writer.fileDisconnect();
//        ftpClient.disConnect();
//         */
//
//        // Facade 패턴 사용 시 SftpClient 클래스에 의존성을 넣어줌으로 각각의 객체를 의존하지 않게 하고 캡슐화 도 되며 코드도 간략해지게 한다.
//
//        SftpClient sftpClient = new SftpClient("www.Roy.com", 22, "/home/etc", "text.txt");
//        sftpClient.connect();
//
//        sftpClient.write();
//
//        sftpClient.read();
//
//        sftpClient.disConnect();
//    }
//}
