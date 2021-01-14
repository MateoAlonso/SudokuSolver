import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
/*
i = 1, 4, 7 &&
j = 1, 4, 7 -> j+2, i+2 j+2
j = 2, 5, 8 -> j-+1, i+2 j+-1
j = 3, 6, 9 -> j-2, i+2 j-2

i = 2, 5, 8 &&
j = 1, 4, 7 -> j+2, i+-1 j+2
j = 2, 5, 8 -> j-+1, i+-1 j+-1
j = 3, 6, 9 -> j-2, i+-1 j-2

i = 3, 6, 9 &&
j = 1, 4, 7 -> j+2, i-2 j+2
j = 2, 5, 8 -> j-+1, i-2 j+-1
j = 3, 6, 9 -> j-2, i-2 j-2
*/
public class Matrix {
	private final int ROWCOL=9;
	private ArrayList<Solution> solutions = new ArrayList<Solution>();
	private ArrayList <ArrayList<Num>> matrix = new ArrayList<ArrayList<Num>>();
	
	public Matrix() {
		for (int i = 0; i < ROWCOL; i++) {
			matrix.add(new ArrayList());
			for (int j = 0; j < ROWCOL; j++) {
				matrix.get(i).add(new Num(0,true));
			}
		}
	}
	
	public void showMatrix() {
		for (int i = 0; i < matrix.size(); i++) {
			System.out.print("\n");
			for (int j = 0; j < matrix.get(i).size(); j++) {
				System.out.print(matrix.get(i).get(j).getNum()+ " ");
			}
		}
		System.out.println("salio for showMatrix");
	}

	public void fillMatrix() {
		matrix.get(0).get(0).setNum(9);
		matrix.get(0).get(0).setCanChange(false);
		matrix.get(0).get(2).setNum(8);
		matrix.get(0).get(2).setCanChange(false);
		matrix.get(0).get(5).setNum(4);
		matrix.get(0).get(5).setCanChange(false);
		matrix.get(0).get(7).setNum(6);
		matrix.get(0).get(7).setCanChange(false);
		matrix.get(0).get(8).setNum(2);
		matrix.get(0).get(8).setCanChange(false);
		matrix.get(1).get(0).setNum(3);
		matrix.get(1).get(0).setCanChange(false);
		matrix.get(1).get(1).setNum(1);
		matrix.get(1).get(1).setCanChange(false);
		matrix.get(1).get(2).setNum(2);
		matrix.get(1).get(2).setCanChange(false);
		matrix.get(1).get(3).setNum(6);
		matrix.get(1).get(3).setCanChange(false);
		matrix.get(1).get(6).setNum(4);
		matrix.get(1).get(6).setCanChange(false);
		matrix.get(2).get(0).setNum(6);
		matrix.get(2).get(0).setCanChange(false);
		matrix.get(2).get(1).setNum(7);
		matrix.get(2).get(1).setCanChange(false);
		matrix.get(2).get(2).setNum(4);
		matrix.get(2).get(2).setCanChange(false);
		matrix.get(2).get(4).setNum(1);
		matrix.get(2).get(4).setCanChange(false);
		matrix.get(2).get(7).setNum(3);
		matrix.get(2).get(7).setCanChange(false);
		matrix.get(2).get(8).setNum(8);
		matrix.get(2).get(8).setCanChange(false);
		matrix.get(3).get(0).setNum(7);
		matrix.get(3).get(0).setCanChange(false);
		matrix.get(3).get(2).setNum(1);
		matrix.get(3).get(2).setCanChange(false);
		matrix.get(4).get(3).setNum(8);
		matrix.get(4).get(3).setCanChange(false);
		matrix.get(4).get(4).setNum(5);
		matrix.get(4).get(4).setCanChange(false);
		matrix.get(4).get(6).setNum(7);
		matrix.get(4).get(6).setCanChange(false);
		matrix.get(4).get(8).setNum(6);
		matrix.get(4).get(8).setCanChange(false);
		matrix.get(5).get(1).setNum(2);
		matrix.get(5).get(1).setCanChange(false);
		matrix.get(5).get(4).setNum(7);
		matrix.get(5).get(4).setCanChange(false);
		matrix.get(5).get(5).setNum(3);
		matrix.get(5).get(5).setCanChange(false);
		matrix.get(5).get(6).setNum(8);
		matrix.get(5).get(6).setCanChange(false);
		matrix.get(5).get(7).setNum(9);
		matrix.get(5).get(7).setCanChange(false);
		matrix.get(6).get(0).setNum(8);
		matrix.get(6).get(0).setCanChange(false);
		matrix.get(6).get(1).setNum(6);
		matrix.get(6).get(1).setCanChange(false);
		matrix.get(6).get(2).setNum(3);
		matrix.get(6).get(2).setCanChange(false);
		matrix.get(6).get(4).setNum(9);
		matrix.get(6).get(4).setCanChange(false);
		matrix.get(6).get(5).setNum(7);
		matrix.get(6).get(5).setCanChange(false);
		matrix.get(6).get(7).setNum(5);
		matrix.get(6).get(7).setCanChange(false);
		matrix.get(7).get(1).setNum(9);
		matrix.get(7).get(1).setCanChange(false);
		matrix.get(7).get(2).setNum(5);
		matrix.get(7).get(2).setCanChange(false);
		matrix.get(7).get(4).setNum(4);
		matrix.get(7).get(4).setCanChange(false);
		matrix.get(7).get(5).setNum(2);
		matrix.get(7).get(5).setCanChange(false);
		matrix.get(8).get(6).setNum(9);
		matrix.get(8).get(6).setCanChange(false);
		/*int n;
		int k=0;
		for (ArrayList<Num> arrayList : matrix) {
			for (Num num : arrayList) {
				n = Consola.leerEntero("Num");
				num.setNum(n);
				if (n==0) {
					num.setCanChange(true);
				} else {
				num.setCanChange(false);
				}
			}
		}*/
		System.out.println("salio for fillMatrix");
	}
	
	public void solveMatrix() {
		boolean r = false;
		boolean canChange;
		int k = 1;
		for (int i = 0; i < matrix.size(); i++) {
			for (int j = 0; j < matrix.size(); j++) {
				canChange = checkChange(i,j);
				while (canChange && !r || k<10) {
					r  = solvePos(k, i, j);
					k++;
					if (k == 9 && j>0) {
						j--;
					}
					if (k == 9 && j == 0) {
						i--;
						j = 9;
					}
				}
				System.out.println("salio while solve matrix");
				solutions.add(new Solution(i, j ,k));
			}
			System.out.println("salio for j solve matrix");
		}
	}
	
	private boolean checkChange(int posx, int posy) {
		boolean r;
		r = matrix.get(posx).get(posy).isCanChange();
		System.out.println("salio checkChange");
		return r;
	}

	
	private boolean solvePos(int n,int posx, int posy) {
		boolean r;
		int caseX = posXGetCase(posx);
		int caseY = posYGetCase(posy);
		r = caseResolverX(n, posx, posy, caseX, caseY);
		System.out.println("salio solvePos");
		return r;
	}
	
	private boolean caseResolverY(int n, int posx, int posy, int caseX, int caseY, int i) {
		boolean r = true;
		
		switch (caseY) {
		case 1:
			//Aca esta el error no se que es
				for (int j = 0; j < 3; j++) {
					if (matrix.get(posx+i).get(posy+j).getNum() == n) {
						r = false;
					}
				}
				System.out.println("entro al caso 1");
			break;
		case 2:
				for (int j = -1; j < 2 ; j++) {
					if (matrix.get(posx+i).get(posy+j).getNum() == n) {
						r = false;
					}
				}
			break;
		case 3:
				for (int j = -2; j < 1; j++) {
					if (matrix.get(posx+i).get(posy+j).getNum() == n) {
						r = false;
					}
				}
			break;

		default:
			break;
		}
		System.out.println("salio caseResolverY");
		return r;
		
	}
	
	private boolean checkSolutionExists(int n, int posx, int posy) {
		boolean r = true;
		for (Solution solution : solutions) {
			if (solution.getPosx() == posx && solution.getPosy() == posy && solution.getNum() == n) {
				r = false;
				break;
			}
		}
		System.out.println("salio for checkSolutionExists");
		return r;
	}
	
	private boolean caseResolverX(int n, int posx, int posy, int caseX,int caseY) {
		boolean r = true;
		r = checkSolutionExists(n, posx, posy);
		while (r) {
			switch (caseX) {
			case 1:
				for (int i = 0; i < 3; i++) {
					r = caseResolverY(n, posx, posy, caseX, caseY, i);
				}
				System.out.println("salio for case 1 caseResolverX");
				break;
			case 2:
				for (int i = -1; i < 2; i++) {
					r = caseResolverY(n, posx, posy, caseX, caseY, i);
				}
				System.out.println("salio for case 2 caseResolverX");
				break;
			case 3:
				for (int i = -2; i < 1; i++) {
					r = caseResolverY(n, posx, posy, caseX, caseY, i);
				}
				System.out.println("salio for case 3 caseResolverX");
				break;
	
			default:
				break;
			}
		}
		System.out.println("salio caseResolverX");
		return r;
	}
	
	private int posXGetCase(int posx) {
		int r = 0;
		if (posx == 0 || posx == 3 || posx == 6) {
			r = 1;
		}
		if (posx == 1 || posx == 4 || posx == 7) {
			r = 2;
		}
		if (posx == 2 || posx == 5 || posx == 8) {
			r = 3;
		}
		return r;
	}
	
	private int posYGetCase(int posy) {
		int r = 0;
		if (posy == 0 || posy == 3 || posy == 6) {
			r = 1;
		}
		if (posy == 1 || posy == 4 || posy == 7) {
			r = 2;
		}
		if (posy == 2 || posy == 5 || posy == 8) {
			r = 3;
		}
		return r;
	}
	
}
