package algorithms;
public class Quickfind
{
 private int[] id;
 public Quickfind(int N)
 {
 id = new int[N];
 for (int i = 0; i < N; i++)
 id[i] = i;
 }
 public boolean connected(int p, int q)
 { return id[p] == id[q]; }
 public void union(int p, int q)
 {
 int pid = id[p];
 int qid = id[q];
 for (int i = 0; i < id.length; i++)
 if (id[i] == pid) id[i] = qid;
 }
 public static void main(String[] args) {
	 	Quickfind N = new Quickfind(10);
		N.union(4,3);
		N.union(3,8);
		N.union(6,5);
		N.union(9,4);
		N.union(2,1);
		System.out.println(N.connected(8,9));
		System.out.println(N.connected(5,0));
		N.union(5,0);
		N.union(7,2);
		N.union(6,1);
	//	N.union(7,3);
		for(int i=0;i<10;i++) {
			System.out.println(N.id[i]);
		}
	}
}