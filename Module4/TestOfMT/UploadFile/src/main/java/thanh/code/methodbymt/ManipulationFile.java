package thanh.code.methodbymt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

public class ManipulationFile {

    public static void uploadFile(HttpServletRequest request) throws IOException, ServletException {
        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            // refines the fileName in case it is an absolute path
            fileName = new File(fileName).getName();
            part.write(getFolderUpload().getAbsolutePath() + File.separator + fileName);
        }
    }

    private static String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    private static File getFolderUpload() {
        String fileLocation = new File("src\\main\\resources\\static").getAbsolutePath() + "\\" + "Uploads";
        File folderUpload = new File(fileLocation);
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }

    public static String getExtensionFile(String fileName) {
        try {
            String extension = null;
            if (!fileName.isEmpty()) {
                int indexDotOfExtension = fileName.lastIndexOf(".");
                extension = fileName.substring(indexDotOfExtension + 1);
            }
            return extension;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getNameFile(String fileName){
        try {
            String nameFile = null;
            if (!fileName.isEmpty()){
                int indexDotOfExtension = fileName.lastIndexOf(".");
                nameFile = fileName.substring(0, indexDotOfExtension);
            }
            return nameFile;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static String getFullFilename(HttpServletRequest request) throws IOException, ServletException {
        String fileName = null;
        for (Part part : request.getParts()) {
            fileName = extractFileName(part);
        }
        return fileName;
    }
}
