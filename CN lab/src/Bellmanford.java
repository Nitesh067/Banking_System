import java.util.Scanner;
public class Bellmanford
{
	int n;
	int [][]a;
	int []d;
	int []p;
	int s;
	public final static int INFTY=999;
	Bellmanford(int n)
	{
		this.n=n;
		a=new int[n][n];
		d=new int[n];
		p=new int[n];
	}
	void Bellmanford()
	{
		for(int i=0;i<n;i++)
		{
			d[i]=a[s][i];
			p[i]=a[s][i]==INFTY?-1:s;
		}
		p[s]=-1;
		for(int i=0;i<n-1;i++)
		{
			for(int u=0;u<n;u++)
			{
				for(int v=0;v<n;v++)
				{
					if(d[v]>d[u]+a[u][v])
					{
						d[v]=d[u]+a[u][v];
						p[v]=u;
					}
				}
			}
		}
	}
	void input(Scanner scanner)
	{
		System.out.println("Enter G");
		
		for(int i=0;i<n;i++)
		{
		 for(int j=0;j<n;j++)
		 {
			 a[i][j]=scanner.nextInt();
			 if(i!=j&&a[i][j]==0) a[i][j]=INFTY;
			 
		 }
		}
		System.out.println("Enter the sourve vertex");
		n=scanner.nextInt();
		scanner.close();
	}
	void path(int v)
	{
		if(v==-1) return;
		path(p[v]);
		System.out.println("."+v);
	}
	void output()
	{
		int i;
		for(i=0;i<n;i++)
		{
			System.out.println("d("+s+","+i+")=" +d[i]+" :p");
			path(i);
			System.out.println();
		}
	}
	public static void main(String[] args)
	{
		int i,n;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter n");
		n=scanner.nextInt();
		Bellmanford bf=new Bellmanford(n);
		bf.input(scanner);
		bf.Bellmanford();
		bf.output();
		}
	}