import java.util.Arrays;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

/**
 * �����࣬ʵ�־���ļӷ�������˷�������Լ�ת�÷���
 * ���мӷ��͵�˷�����Ҫ������ʵ�ַ�ʽ
 * 1.����һ��MyMatrix�������2������Ĳ���
 * 2.�ӿ���̨��console������һ���������ݣ��ٽ��в���
 * ���е����ݾ�Ϊint��
 * �������ݾ�Ĭ��Ϊ��ȷ���ݣ�����Ҫ���������ݽ���У��
 * @author Ray Liu & Qin Liu
 *
 */
public class MatrixC {

	private int[][] data;
	private int m; //����ĵ�һά����
	private int n; //����ĵڶ�ά����
	
	/**
	 * ���캯��������Ϊ2άint����
	 * a[i][j]�Ǿ����еĵ�i+1�У���j+1������
	 * @param a
	 */
	public MatrixC(int[][] a){
		this.data = a;
		m=a.length;
		n=a[0].length;
	}

	/**
	 * ����2άint����
	 * @return int[][]
	 */
	public int[][] getArray(){
		return data;
	}

	/**
	 * ���ؾ���ĵ�һά����
	 * @return int
	 */
	public int getM(){
		return m;
	}

	/**
	 * ���ؾ���ĵڶ�ά����
	 * @return
	 */
	public int getN(){
		return n;
	}
	
	/**
	 * ʵ�־���ӷ�������һ���µľ���
	 * @param B
	 * @return
	 */
	public MatrixC plus(MatrixC B){
		int[][] b=new int[m][n];
		int[][] result=new int[m][n];
		b=B.getArray();
		if(m==B.getM()&&n==B.getN()){
			for(int i=0;i<m;i++){
				for (int j = 0; j < n; j++) {
					result[i][j]=data[i][j]+b[i][j];
				}
			}
		}
		MatrixC resultMatrix=new MatrixC(result);
		return resultMatrix;
		
	}
	
	/**
	 * ʵ�־���˷�������һ���µľ���
	 * @param B
	 * @return
	 */
	public MatrixC times(MatrixC B){
		int[][] b=new int[B.getM()][B.getN()];
		int[][] result=new int[m][B.getN()];
		if(n==B.getM()){
			b=B.getArray();
			for (int i = 0; i <m ; i++) {
				for (int j = 0; j < B.getN(); j++) {
					for (int a = 0; a < n; a++) {
						result[i][j]=result[i][j]+data[i][a]*b[a][j];
					}
					
				}
				
			}
		}
		MatrixC resultMatrix=new MatrixC(result);
		return resultMatrix;
	}
	
	/**
	 * ʵ�־���ĵ�ˣ�����һ���µľ���
	 * @param b
	 * @return
	 */
	public MatrixC times(int b){
		int[][] result=new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j]=b*data[i][j];
			}
			
		}
		MatrixC resultMatrix=new MatrixC(result);
		return resultMatrix;
	}
	
	/**
	 * ʵ�־����ת�ã�����һ���µľ���
	 * @return
	 */
	public MatrixC transpose(){
		int[][] result=new int[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				result[j][i]=data[i][j];
			}
		}
		MatrixC resultMatrix=new MatrixC(result);
		return resultMatrix;
	}
	
	/**
	 * �ӿ���̨����������ݣ����о���ӷ����������ݸ�ʽ���£�
	 * m n
	 * m * n �����ݷ����Կո����
	 * example:
	 * 4 3
	 * 1 2 3 
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * ����һ���µľ���
	 * @return
	 */
	public MatrixC plusFromConsole(){
		Scanner scanner=new Scanner(System.in);
		int m1=scanner.nextInt();
		int n1=scanner.nextInt();
		int[][] temp=new int[m1][n1];
		int[][] result=new int[m][n];
		if(m==m1&&n==n1){
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					temp[i][j]=scanner.nextInt();
					result[i][j]=temp[i][j]+data[i][j];
				}
			}
		}
		MatrixC resultMatrix=new MatrixC(result);
		return resultMatrix;
	}
	
	/**
	 * �����ʽͬ�Ϸ�����ͬ
	 * ʵ�־���ĳ˷�
	 * ����һ���µľ���
	 * @return
	 */
	public MatrixC timesFromConsole(){
		Scanner scanner=new Scanner(System.in);
		int m1=scanner.nextInt();
		int n1=scanner.nextInt();
		int[][] temp=new int[m1][n1];
		int[][] result=new int[m][n];
		for (int i = 0; i < m1; i++) {
			for (int j = 0; j < n1; j++) {
				temp[i][j]=scanner.nextInt();
				}
			}
		if(n==m1){
			for (int i = 0; i <m ; i++) {
				for (int j = 0; j < n1; j++) {
					for (int a = 0; a < n; a++) {
						result[i][j]=result[i][j]+data[i][a]*temp[a][j];
					}
					
				}
				
			}
		}
		MatrixC resultMatrix=new MatrixC(result);
		return resultMatrix;
	}
	
	/**
	 * ��ӡ���þ��������
	 * ��ʼһ�����У�����һ������
	 * ������ÿһ�����ݳ�һ�У����ݼ��Կո����
	 * example��
	 * 
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 
	 */
	public void print(){
		System.out.println("");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n-1; j++) {
				System.out.print(data[i][j]+" ");
			}
			System.out.println(data[i][n-1]);
		}
		System.out.println("");
		
	}
	
	/**
	 * �ж��Ƿ���ȵķ�����������Ҫ�޸ģ���
	 */
	public boolean equals(Object obj){
		
		if(obj instanceof MatrixC){
			MatrixC matrix = (MatrixC) obj;
			
			if(this.data.length != matrix.data.length){
				return false;
			}
			
			for(int i=0 ; i<this.data.length ; ++i){
				if(!Arrays.equals(this.data[i], matrix.data[i])){
					return false;
				}
			}
			
			return true;
			
		}else{
			return false;
		}
	}
	
}
