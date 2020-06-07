import java.io.*;
import java.util.*;
public class SparseVector {

	private HashMap<Integer, Double> v;
	
	public SparseVector() {
		v = new HashMap<Integer,Double>();
	}
	
	public void put(int i, double x) {
		v.put(i,x);
	}
	
	public double get(int i) {
		if(!v.containsKey(i)) return 0.0;
		else return v.get(i);
	}
	
	public Iterable<Integer> indices(){
		return v.keySet();
	}
	
	public double dot(double[] that) {
		double sum = 0.0;
		for(int i:indices()) {
			sum += that[i]*this.get(i);
		}
		return sum;
	}
	}
