package acadgild.session3.task3;


import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class FileListingRecursivelyForDiffPaths {
	public static void main(String[] args)
	{
		if(args.length == 0)
		{
			System.out.println("Pass required arguments");
			System.exit(1);
		}
		for(String arg : args)
		{
			Path path = new Path(arg);
			Configuration conf = new Configuration();
			try 
			{
				displayRecusivelsy(path, conf);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private static void displayRecusivelsy(Path path, Configuration conf) throws IOException 
	{
		FileSystem fs = FileSystem.get(path.toUri(), conf);
		FileStatus[] fStatuses = fs.listStatus(path);
		for(FileStatus fStatus : fStatuses)
		{
			if(fStatus.isDirectory())
			{
				System.out.println("The directory path is :" + fStatus.getPath());
				System.out.println("So going for recursive call to list directory/files in this path");
				displayRecusivelsy(fStatus.getPath(), conf);
			}
			else if(fStatus.isFile())
			{
				System.out.println("The file path is :" + fStatus.getPath());
			}
		}
	}
}
