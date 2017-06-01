package Controller;

import java.util.ArrayList;

import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class LCSalgorithms {
	private ObservableList<StringProperty> X;
	private ObservableList<StringProperty> Y;
	private int LCSlength;
	private int [][] table;
	public ArrayList<Integer> X_Index = new ArrayList<Integer>();
	public ArrayList<Integer> Y_Index = new ArrayList<Integer>();
	
	/*
	 *  solution -> 1 : diagoanl;
	 *  			2 : top;
	 *  			3 : left;
	 * */
	private int [][] solution;

	LCSalgorithms(ObservableList<StringProperty> X, ObservableList<StringProperty> Y){
		this.X = X;
		this.Y = Y;
	
		initTable();
		findIndex();
	}
	
	public int getLCSlength(){
		return LCSlength;
	};
	
	/*
	 * LCM Algorithms
	 * init Table : arr[i][0] = 0 & arr[0][j] = 0;
	 * */
	
	private void initTable(){
		int i,j=0;
		table = new int[X.size()+1][Y.size()+1];
		solution = new int[X.size()+1][Y.size()+1];
		
		for(i = 1 ; i < X.size() + 1;  i++) {
			for(j = 1; j < Y.size() + 1; j++) {
				if(X.get(i-1).getValue().equals(Y.get(j-1).getValue())){
					table[i][j] = table[i-1][j-1] + 1;
					solution[i][j] =  1;
				}
				else{
					table[i][j] = max(table[i-1][j], table[i][j-1]);
					if(table[i][j] == table[i-1][j]) 
						solution[i][j] = 2;
					else 
						solution[i][j] = 3;
				}
			}
		}
		
		LCSlength = table[i-1][j-1];
		
	}
	
	private void findIndex(){
		int i = X.size();
		int j = Y.size();
		
		while(solution[i][j] != 0){
				if(solution[i][j] == 1){
					X_Index.add(i-1);
					Y_Index.add(j-1);
					i--;
					j--;
				}
				else if(solution[i][j] == 2){//top
					i--;
				}
				else{
					j--;
				}
		}
	}
	
	public void print(){
		for(int i = 0 ; i < X.size()+1; i++){
			for(int j = 0; j < Y.size()+1; j++)
			{
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();System.out.println();
		for(int i = 0 ; i < X.size()+1; i++){
			for(int j = 0; j < Y.size()+1; j++)
			{
				System.out.print(solution[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(X_Index.toString());
		System.out.println(Y_Index.toString());
	}
	private int max(int a, int b){
		return (a>b) ? a : b;
	}
}
