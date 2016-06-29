package httpdownloader;

import java.io.IOException;

public class HttpDownloader {

public static void main(String[] args) {
    String fileURL = "http://media.ldscdn.org/pdf/magazines/liahona-june-2016/2016-06-03-our-father-our-mentor-eng.pdf";
    String saveDir = "C:\\Users\\Public\\Downloads";
    try {
            HttpDownloadUtility.downloadFile(fileURL, saveDir);
        }   
    catch (IOException ex) {
            ex.printStackTrace();
        }
     }
}
