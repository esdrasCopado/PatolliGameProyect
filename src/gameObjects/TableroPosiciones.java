package gameObjects;
import java.util.ArrayList;

public class TableroPosiciones {
	
	private ArrayList<FichaPosicion> listaPosiciones=new ArrayList<>();
	private FichaPosicion FichaPosicion;
	private int X,Y;
	
	public TableroPosiciones() {
		listaPosiciones.add(new FichaPosicion(250, 15,1));
		listaPosiciones.add(new FichaPosicion(299, 61,2));
		listaPosiciones.add(new FichaPosicion(340, 100,3));
		listaPosiciones.add(new FichaPosicion(375, 123,4));
		listaPosiciones.add(new FichaPosicion(403, 154,5));
		listaPosiciones.add(new FichaPosicion(443, 194,6));
		listaPosiciones.add(new FichaPosicion(487, 235,7));
		listaPosiciones.add(new FichaPosicion(537, 289,8));
		listaPosiciones.add(new FichaPosicion(581, 329,9));
		listaPosiciones.add(new FichaPosicion(628, 284,10));
		
		listaPosiciones.add(new FichaPosicion(674, 240,11));
		listaPosiciones.add(new FichaPosicion(721, 190,12));
		listaPosiciones.add(new FichaPosicion(581, 329,13));
		listaPosiciones.add(new FichaPosicion(628, 284,14));
		listaPosiciones.add(new FichaPosicion(674, 240,15));
		listaPosiciones.add(new FichaPosicion(721, 190,16));
		listaPosiciones.add(new FichaPosicion(766, 144,17));
		listaPosiciones.add(new FichaPosicion(800, 108,18));
		listaPosiciones.add(new FichaPosicion(830, 75,19));
		listaPosiciones.add(new FichaPosicion(860, 43,20));
		
		listaPosiciones.add(new FichaPosicion(904, 22,21));
		listaPosiciones.add(new FichaPosicion(950, 58,22));
		listaPosiciones.add(new FichaPosicion(908, 95,23));
		listaPosiciones.add(new FichaPosicion(889, 132,24));
		listaPosiciones.add(new FichaPosicion(854, 159,25));
		listaPosiciones.add(new FichaPosicion(810, 198,26));
		listaPosiciones.add(new FichaPosicion(769, 240,27));
		listaPosiciones.add(new FichaPosicion(721, 287,28));
		listaPosiciones.add(new FichaPosicion(671, 329,29));
		listaPosiciones.add(new FichaPosicion(622, 377,30));
		
		listaPosiciones.add(new FichaPosicion(671, 424,31));
		listaPosiciones.add(new FichaPosicion(714, 471,32));
		listaPosiciones.add(new FichaPosicion(764, 517,33));
		listaPosiciones.add(new FichaPosicion(808, 559,34));
		listaPosiciones.add(new FichaPosicion(842, 578,35));
		listaPosiciones.add(new FichaPosicion(865, 615,36));
		listaPosiciones.add(new FichaPosicion(903, 654,37));
		listaPosiciones.add(new FichaPosicion(950, 700,38));
		listaPosiciones.add(new FichaPosicion(903, 747,39));
		listaPosiciones.add(new FichaPosicion(855, 704,40));
		
		listaPosiciones.add(new FichaPosicion(820, 668,41));
		listaPosiciones.add(new FichaPosicion(785, 641,42));
		listaPosiciones.add(new FichaPosicion(764, 609,43));
		listaPosiciones.add(new FichaPosicion(717, 563,44));
		listaPosiciones.add(new FichaPosicion(672, 514,45));
		listaPosiciones.add(new FichaPosicion(625, 470,46));
		listaPosiciones.add(new FichaPosicion(578, 423,47));
		listaPosiciones.add(new FichaPosicion(532, 467,48));
		listaPosiciones.add(new FichaPosicion(485, 515,49));
		listaPosiciones.add(new FichaPosicion(436, 564,50));
		
		listaPosiciones.add(new FichaPosicion(393, 607,51));
		listaPosiciones.add(new FichaPosicion(349, 651,52));
		listaPosiciones.add(new FichaPosicion(331, 694,53));
		listaPosiciones.add(new FichaPosicion(295, 705,54));
		listaPosiciones.add(new FichaPosicion(252, 743,55));
		listaPosiciones.add(new FichaPosicion(217, 705,56));
		listaPosiciones.add(new FichaPosicion(250, 663,57));
		listaPosiciones.add(new FichaPosicion(278, 633,58));
		listaPosiciones.add(new FichaPosicion(312, 601,59));
		listaPosiciones.add(new FichaPosicion(350, 561,60));
		
		listaPosiciones.add(new FichaPosicion(395, 515,61));
		listaPosiciones.add(new FichaPosicion(442, 470,62));
		listaPosiciones.add(new FichaPosicion(486, 423,63));
		listaPosiciones.add(new FichaPosicion(533, 374,64));
		listaPosiciones.add(new FichaPosicion(489, 331,65));
		listaPosiciones.add(new FichaPosicion(441, 282,66));
		listaPosiciones.add(new FichaPosicion(391, 238,67));
		listaPosiciones.add(new FichaPosicion(354, 206,68));
		listaPosiciones.add(new FichaPosicion(315, 180,69));
		listaPosiciones.add(new FichaPosicion(295, 148,70));
		
		listaPosiciones.add(new FichaPosicion(247, 102,71));
		listaPosiciones.add(new FichaPosicion(210, 66,72));
		
		
	}
	
	public FichaPosicion BuscarPosicion(int id) {
		
		if(id>72) {
			id=id-72;
		}
		
		for(FichaPosicion ficha:listaPosiciones) {
			
			int pos=ficha.getPosicion();
			if(pos==id) {
				return ficha;
			}
		}
		return null;
	}
	


	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}
	
}
