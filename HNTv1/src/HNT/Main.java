package HNT;
public class Main {
	static final int high = 5;
	static Circle towr[][] = new Circle[3][high];
	static int moveCount = 0;
	public static void main(String args[]) {
		int temX=0;
		int temY=0;//([x],[y])
		boolean haveMore = true;
		for(int m = 0 ; m<high ; m++) {
			towr[0][m] = new Circle(high-m); 
		}
		
		System.out.println("Origin");
		for(int m=high-1;m>=0;m--) {
			for(int n=0;n<3;n++) {
				if(towr[n][m]==null) {
					System.out.print("0\t");
					continue;
				}
				System.out.print(towr[n][m].size + "\t");
			}
			System.out.println();
		}
		
		moveTo(0,high-1,1); //
		System.out.println("Moved" + moveCount + "times");
		for(int m=high-1;m>=0;m--) {
			for(int n=0;n<3;n++) {
				if(towr[n][m]==null) {
					System.out.print("0\t");
					continue;
				}
				System.out.print(towr[n][m].size + "\t");
			}
			System.out.println();
		}
		
		while(towr[1][high-1] == null && towr[2][high-1] == null) {
			haveMore = true;
			X:for(int m=0;m<3;m++) {
				for(int n=high-1;n>=0;n--) {
					if(towr[m][n]!=null){
						if(moveable(m,n)) {
							if(haveMore) {
								temX = m;
								temY = n;
								haveMore = false;
								break;
							}
							else {
								if(towr[m][n].size > towr[temX][temY].size) {
									moveTo(m,n,aim(m,n));
									haveMore = true;
									break X;
								}
								else {
									moveTo(temX,temY,aim(temX,temY));
									haveMore = true;
									break X;
								}
							}
						}
						else break;
					}
				}
			}
			if(haveMore==false) {
				moveTo(temX,temY,aim(temX,temY));
			}
			System.out.println("Moved" + moveCount + "times");
			for(int m=high-1;m>=0;m--) {
				for(int n=0;n<3;n++) {
					if(towr[n][m]==null) {
						System.out.print("0\t");
						continue;
					}
					System.out.print(towr[n][m].size + "\t");
				}
				System.out.println();
			}
		}
	} 
	
	
	public static void moveTo(int nowX ,int nowY, int newPlace) {
		Circle temCircle = towr[nowX][nowY];
		int y = 0;
		for( y=high-1;y>=0;y--) {
			if(towr[newPlace][y]!=null) {
				y++;
				break;
			}
		}
		if (y==-1) {
			y++;
		}
		towr[nowX][nowY] = towr[newPlace][y];
		towr[newPlace][y] = temCircle;
		towr[newPlace][y].pastPlace = nowX;
		moveCount++;
	}
	
	public static boolean moveable(int X, int Y) {
		int m = 0;
		if(X != 0 && towr[X][Y].pastPlace!=0) {
			for( m = high-1;m>=0;m--) {
				if(towr[0][m]!=null) {
					if(towr[0][m].size >towr[X][Y].size) {
						return true;
					}
					else {
						break;
					}
				}
			}
			if(m==-1) {
				return true;
			}
		}
		if(X != 1 && towr[X][Y].pastPlace!=1) {
			for( m = high-1;m>=0;m--) {
				if(towr[1][m]!=null) {
					if(towr[1][m].size >towr[X][Y].size) {
						return true;
					}
					else {
						break;
					}
				}
			}
			if(m==-1) {
				return true;
			}
		}
		if(X != 2 && towr[X][Y].pastPlace!=2) {
			for( m = high-1;m>=0;m--) {
				if(towr[2][m]!=null) {
					if(towr[2][m].size >towr[X][Y].size) {
						return true;
					}
					else {
						break;
					}
				}
			}
			if(m==-1) {
				return true;
			}
		}
		return false;
	}
	
	public static int aim(int X, int Y) { 
		int m = 0;
		if(X != 0 && towr[X][Y].pastPlace!=0) {
			for( m = high-1;m>=0;m--) {
				if(towr[0][m]!=null) {
					if(towr[0][m].size >towr[X][Y].size) {
						return 0;
					}
					else {
						break;
					}
				}
			}
			if(m==-1) {
				return 0;
			}
		}
		if(X != 1 && towr[X][Y].pastPlace!=1) {
			for( m = high-1;m>=0;m--) {
				if(towr[1][m]!=null) {
					if(towr[1][m].size >towr[X][Y].size) {
						return 1;
					}
					else {
						break;
					}
				}
			}
			if(m==-1) {
				return 1;
			}
		}
		return 2;
	}
}
