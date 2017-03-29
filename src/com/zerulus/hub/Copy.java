package com.zerulus.hub;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Copy {

    public Copy() {

    }

    public static void copyFile(File source, File dest) {
        try {
            if(!dest.isDirectory()) {
                System.out.println("Creating Dir... ");
                dest.mkdirs();
            }

            File f = new File(dest + "\\" + source.getName());

            if(!f.exists()) {
                System.out.println("Creating File... ");
                f.createNewFile();
            }
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: something went wrong with creating new file");
        }

        InputStream in = null;
        OutputStream out = null;

        try{
            in = new FileInputStream(source);
            out = new FileOutputStream(dest + "\\" + source.getName());

            // Transfer bytes from in to out
            byte[] buf = new byte[1024];
            int len;

            while((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }

            if(in != null) {
                in.close();
            }
            if(out != null) {
                out.close();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

}
