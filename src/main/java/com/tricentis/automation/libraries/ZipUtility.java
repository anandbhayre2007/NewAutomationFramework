package com.tricentis.automation.libraries;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtility {

    private List <String> fileList;
    private static final String OUTPUT_ZIP_FILE = System.getProperty("user.dir")+"//Report.zip";
    private static final String SOURCE_FOLDER = System.getProperty("user.dir")+"//test-output";

    public ZipUtility() {
        fileList = new ArrayList < String > ();
    }

    public static void zipReport() {
        ZipUtility appZip = new ZipUtility();
        appZip.generateFileList(new File(SOURCE_FOLDER));
        appZip.zipIt(OUTPUT_ZIP_FILE);
    }

    public void zipIt(String zipFile) {
        byte[] buffer = new byte[1024];
        String source = new File(SOURCE_FOLDER).getName();
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        try {
            fos = new FileOutputStream(zipFile);
            zos = new ZipOutputStream(fos);

            System.out.println("Output to Zip : " + zipFile);
            FileInputStream in = null;

            for (String file: this.fileList) {
                System.out.println("File Added : " + file);
                ZipEntry ze = new ZipEntry(source + File.separator + file);
                zos.putNextEntry(ze);
                try {
                    in = new FileInputStream(SOURCE_FOLDER + File.separator + file);
                    int len;
                    while ((len = in .read(buffer)) > 0) {
                        zos.write(buffer, 0, len);
                    }
                } finally {
                    in.close();
                }
            }

            zos.closeEntry();
            System.out.println("Folder successfully compressed");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                zos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void generateFileList(File node) {
        // add file only
        if (node.isFile()) {
        	String[] ignore= {".ade", ".adp",".bat",".chm",".cmd",".com",".cpl",".dll",".dmg",".exe",
        			".hta",".ins",".isp",".jar",".js",".jse",".lib",".lnk",".mde",".msc",
        			".msi",".msp",".mst",".nsh",".pif",".scr",".sct",".shb",".sys",".vb",
        			".vbe",".vbs",".vxd",".wsc",".wsf",".wsh"};
        	boolean flag=true;
        	for(String s:ignore)
        	{
        		if(node.toString().contains(s))
        		{
        			 flag=false;
        			 break;
        		}
        	}
        	if(flag)
        		fileList.add(generateZipEntry(node.toString()));
           
        }

        if (node.isDirectory()) {
            String[] subNote = node.list();
            for (String filename: subNote) {
                generateFileList(new File(node, filename));
            }
        }
    }

    private String generateZipEntry(String file) {
        return file.substring(SOURCE_FOLDER.length(), file.length());
    }
}