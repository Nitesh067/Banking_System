//CRC//
import java.util.Scanner;
public class CRC
{
	int W;
	String p;
	String messege;
	String checksum;
	CRC()
	{
		W=16;
		p="10001000000100001";
	}
	void crc()
	{
		String msg=messege+"0000000000000000";
		char[] rem=new char[p.length()];
		for(int i=0;i<msg.length();i++)
		{
			rem[W]=msg.charAt(i);
			boolean xor=rem[0]=='1';
			for(int j=1;j<=W;j++)
			{
				if (xor) rem[j] = (rem[j]==p.charAt(j)) ? '0':'1';

				rem[j-1]=rem[j];
			}
		}
		checksum=String.valueOf(rem).substring(0,W);
	}
	void input()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Messege");
		messege=scanner.next();
		scanner.close();
	}
	void output()
	{
		System.out.println("checksum:"+checksum);
	}
	public static void main(String[] args)
	{
		CRC crc=new CRC();
		crc.input();
		crc.crc();
		crc.output();
	}
}