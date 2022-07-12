
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.swing.JProgressBar;

public class ZipUtils implements Runnable
{

    private String SOURCE_FOLDER, OUTPUT_ZIP_FILE, filePath;
    private int mode;// 1 zip some files, 2 zip a folder, 3 unzip an archive
    private List<String> fileList;
    
    private JProgressBar pBar;

    private int buffer_size = 4096;

    public ZipUtils(String SOURCE_FOLDER, String OUTPUT_FILE, int mode, JProgressBar pBar)
    {
        this.fileList = new ArrayList<>();

    	this.SOURCE_FOLDER = SOURCE_FOLDER;

        this.OUTPUT_ZIP_FILE = OUTPUT_FILE;

        this.mode = mode;
        
        this.pBar = pBar;
    }

    private String getSourceFolder(String file)
    {
		return file.substring(0, file.lastIndexOf("\\") + 1);
    }
    
	@Override
	public void run() {
		executeZipping();
	}
	
	private Void executeZipping()
    {
        long iteration_update = folderSize(new File(SOURCE_FOLDER)) / buffer_size, count_iteration_update = 1, increment = 0;

        if(iteration_update <= 100)
        {
            increment = 25;
            iteration_update = iteration_update / 4;
        }
        else if(iteration_update > 100 && iteration_update <= 1000)
        {
            increment = 10;
            iteration_update = iteration_update / 10;
        }
        else if(iteration_update > 1000)
        {
            increment = 2;
            iteration_update = iteration_update / 50;
        }

        long start = System.currentTimeMillis();
        if(mode == 1)//zip some files
        {
            //List<String> srcFiles = files/*Arrays.asList(files)*/;
            //generateFileList(new File(SOURCE_FOLDER));
        	fileList.add(SOURCE_FOLDER);
            //System.out.println("Ci sono\n Filelist: "+fileList.get(0).toString());
            
            new File(OUTPUT_ZIP_FILE);
            double cnt = 0;
            double size = new File(SOURCE_FOLDER).length();
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(OUTPUT_ZIP_FILE);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ZipOutputStream zipOut = new ZipOutputStream(fos);

            zipOut.setMethod(ZipOutputStream.DEFLATED);
            zipOut.setLevel(0);

            //double start = System.currentTimeMillis();
            for (String srcFile : fileList)
            {
                File fileToZip = new File(SOURCE_FOLDER);
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(fileToZip);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                try {
                    zipOut.putNextEntry(zipEntry);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                byte[] bytes = new byte[buffer_size];
                int length = 0;
                while(true) {
                    try {
                        if (!((length = fis.read(bytes)) >= 0)) break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        cnt += length;
                        count_iteration_update++;
                        if(count_iteration_update == iteration_update){
                            count_iteration_update = 0;
                            int value = (int) (cnt/(size/100));
                            publishProgress(value);
                            //System.out.println("cnt: "+cnt+"   size: " +size);
                        }
                        /*int val = (int) (cnt/(size/100));
                        publishProgress(val);*/
                        zipOut.write(bytes, 0, length);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    fis.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //double end = System.currentTimeMillis();
            //System.out.println("Compression time: "+(end - start));
            publishProgress(100);
            try {
                zipOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(mode == 2)//zip a folder
        {
            generateFileList(new File(SOURCE_FOLDER));
            double size = folderSize(new File(SOURCE_FOLDER));
            byte[] buffer = new byte[buffer_size];
            String source = new File(SOURCE_FOLDER).getName();
            FileOutputStream fos = null;
            ZipOutputStream zos = null;
            //double start = System.currentTimeMillis();
            try {
                fos = new FileOutputStream(OUTPUT_ZIP_FILE);
                zos = new ZipOutputStream(fos);

                zos.setMethod(ZipOutputStream.DEFLATED);
                zos.setLevel(0);

                System.out.println("Output to Zip : " + OUTPUT_ZIP_FILE);
                FileInputStream in = null;

                double cnt = 0;
                int len;
                //for (String file: this.fileList)
                for(int i = 0; i < fileList.size(); i++)
                {
                    String file = fileList.get(i);
                    //System.out.println("File Added : " + file);
                    ZipEntry ze = new ZipEntry(source + File.separator + file);
                    zos.putNextEntry(ze);
                    try {
                        in = new FileInputStream(SOURCE_FOLDER + File.separator + file);

                        while ((len = in .read(buffer)) > 0)
                        {
                            cnt += len;
                            count_iteration_update++;
                            if(count_iteration_update == iteration_update){
                                count_iteration_update = 0;
                                publishProgress((int) (cnt/(size/100)));
                                //System.out.println("Progress: " + (cnt/(size/100)));
                            }
                            zos.write(buffer, 0, len);
                        }
                    } finally {
                        if(in != null)
                            in.close();
                    }
                }
                //double end = System.currentTimeMillis();
                //System.out.println("Compression time: "+(end - start));
                publishProgress(100);
                zos.closeEntry();
                zos.close();
            	fos.close();
            	
                System.out.println("Folder successfully compressed");
            } catch (IOException ex) {
                ex.printStackTrace();
            } 
        }
        else// unzip
        {
            File zipFile = new File(SOURCE_FOLDER);
            long size = zipFile.length();
            String OUTPUT_FILE = OUTPUT_ZIP_FILE;
            File dir = new File(OUTPUT_FILE);
            // create output directory if it doesn't exist
            if(!dir.exists()) dir.mkdirs();
            FileInputStream fis;
            //buffer for read and write data to file
            byte[] buffer = new byte[buffer_size];
            try {
                fis = new FileInputStream(SOURCE_FOLDER);
                FileChannel channel = fis.getChannel();

                ZipInputStream zis = new ZipInputStream(fis);
                ZipEntry ze = zis.getNextEntry();
                while(ze != null)
                {
                    String fileName = ze.getName();
                    File newFile = new File(OUTPUT_FILE + File.separator + fileName);
                    //System.out.println("Unzipping to "+newFile.getAbsolutePath());
                    //create directories for sub directories in zip
                    new File(newFile.getParent()).mkdirs();
                    FileOutputStream fos = new FileOutputStream(newFile);
                    int len;
                    while ((len = zis.read(buffer)) > 0)
                    {
                        count_iteration_update++;
                        if(count_iteration_update == iteration_update){
                            count_iteration_update = 0;
                            publishProgress((int) (channel.position()/(size/100)));
                        }
                        int val = (int) (channel.position()/(size/100));
                        publishProgress(val);
                        fos.write(buffer, 0, len);
                    }
                    publishProgress(100);
                    fos.close();
                    zis.closeEntry();
                    ze = zis.getNextEntry();
                }
                channel.close();
                zis.closeEntry();
                zis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        long size = folderSize(new File(SOURCE_FOLDER))/1000;
        System.out.println("Folder size: "+size);
        double speed = size / ( end - start);
        
		if(mode == 1 || mode == 2)
	        System.out.println("Compression speed: "+speed);
		else
			System.out.println("Decompression speed: "+speed);
        
        callBack();
        return null;
    }

	private void callBack()
	{
		if(mode == 1 || mode == 2)
			EncryptMain.Instance.EncryptDriver();
		else
			DecryptMain.Instance.DecryptDriver();
	}
	
    private void publishProgress(int value)
    {
        pBar.setValue(value);
    }

    public long folderSize(File directory) {
        long length = 0;
        //System.out.println("File: "+directory);
        if(directory.isFile()) return directory.length();
        else {
            for (File file : directory.listFiles()) {
                if (file.isFile())
                    length += file.length();
                else
                    length += folderSize(file);
            }
            return length;
        }
    }

    private int listSize()
    {
        int size = 0, listSize = fileList.size();
        for(int i = 0; i < listSize; i++)
        {
            size += new File(SOURCE_FOLDER+"/"+fileList.get(i)).length();
            //System.out.println("Size: "+size);
        }
        return size;
    }

    public void generateFileList(File node) {
        // add file only
        if (node.isFile()) {
            //System.out.println("Node: "+node.toString());
            fileList.add(generateZipEntry(node.toString()));
        }

        if (node.isDirectory()) {
            String[] subNote = node.list();
            for (String filename: subNote) {
                generateFileList(new File(node.toString()+"/"+filename));
            }
        }
    }

    private String generateZipEntry(String file)
    {
        return file.substring(new File(SOURCE_FOLDER).toString().length() + 1, new File(file).toString().length());
    }
    
    /*public static void main(String[] args)
    {
    	String SOURCE_FOLDER = "C:\\Users\\marco\\Pictures\\Screenshots";
    	String OUTPUT_FILE = "C:\\Users\\marco\\Desktop\\s.zip";
    	short mode = 2;
    	
    	ZipUtils zip = new ZipUtils(SOURCE_FOLDER, OUTPUT_FILE, mode);
    	zip.executeZipping();
    }*/
}
