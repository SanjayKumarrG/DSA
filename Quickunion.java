package algorithms;

public class Quickunion {
private int[] id;
public Quickunion(int N)
{
	 id = new int[N];
	 for (int i = 0; i < N; i++) id[i] = i;
}
private int root(int i)
{
	while (i != id[i]) i = id[i];
	return i;
}
public boolean connected(int p, int q)
{
	return root(p) == root(q);
}
public void union(int p, int q)
{
	int i = root(p);
	int j = root(q);
	id[i] = j;

}
public static void main(String[] args) {
	Quickunion N = new Quickunion(10);
	N.union(4,3);
	N.union(3,8);
	N.union(6,5);
	N.union(9,4);
	N.union(2,1);
	System.out.println(N.connected(8,9));
	System.out.println(N.connected(5,4));
	N.union(5,0);
	N.union(7,2);
	N.union(6,1);
	//N.union(7,3);
	System.out.println(N.connected(2,6));
	for(int i=0;i<10;i++) {
		System.out.println(N.id[i]);
	}
}
}