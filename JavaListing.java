package acadgild.session3.task1;


import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class JavaListing {
	public static void main(String[] args)
	{
		if(args.length != 1)
		{
			System.out.println("Pass required arguments");
			System.exit(1);
		}
		Path path = new Path(args[0]);
		Configuration conf = new Configuration();
		try {
			FileSystem fs = FileSystem.get(path.toUri(), conf);
			FileStatus[] fStatuses = fs.listStatus(path);
			for(FileStatus fStatus : fStatuses)
			{
				if(fStatus.isDirectory())
				{
					System.out.println("The directory path is :" + fStatus.getPath());
				}
				else if(fStatus.isFile())
				{
					System.out.println("The file path is :" + fStatus.getPath());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
