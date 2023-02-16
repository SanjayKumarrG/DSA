package algorithms;

public class WeightQU {
private int[] id;
private int[] sz;
private int count;
public WeightQU(int N)
{
	count = N;
	id = new int[N];
	 sz = new int[N];
	 for (int i = 0; i < N; i++) {
		 id[i] = i;
		 sz[i] = 1;
	 }
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
public int count() { return count;}
public void union(int p, int q)
{
	int i = root(p);
	int j = root(q);
	if(i==j) return;
	if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
    else { id[j] = i; sz[i] += sz[j]; }
	count--;

}
public static void main(String[] args) {
	WeightQU N = new WeightQU(10);
	N.union(4,3);
	N.union(3,8);
	N.union(6,5);
	N.union(9,4);
	N.union(2,1);
	N.union(5,0);
	N.union(7,2);
	N.union(6,1);
	N.union(7,3);
	for(int i=0;i<10;i++) {
		System.out.println(N.id[i]);}
	for(int i=0;i<10;i++) {	
		System.out.println(" " +N.sz[i]);
	}
	System.out.println(N.count() + " components");
}
}