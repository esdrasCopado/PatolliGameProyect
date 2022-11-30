package states;

import java.awt.Graphics;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexionDB.ConexionDB;
import gameObjects.Configuration;
import graphics.Assets;
import input.KeyBoardInput;
import ui.Action;
import ui.Button;
import ui.TextArea;

public class BuscarPartidaState extends State{
	private Button button,button2,button3;
	private TextArea text;
	private Connection con;
	private String numeroId;
	private int id;
	private int numeroJugadores=0;
	public BuscarPartidaState() {
		
		button=new Button(Assets.textOutput, Assets.blueBtn, 300, 300, "Numero de partida", new Action() {
			
			@Override
			public void doAction() {
				// TODO Auto-generated method stub
				
			}
		});
		text=new TextArea(Assets.textAreaImage, Assets.textAreaImage, 600,300 , new Action() {
			
			@Override
			public void doAction() {
				numeroId=KeyBoardInput.palabra;
				String aux=numeroId.substring(0,numeroId.length()-1);
				id=Integer.parseInt(aux);
				KeyBoardInput.palabra="";
				KeyBoardInput.pressedEnter=false;
				
			}
		});
		button2=new Button(Assets.greyBtn, Assets.blueBtn, 300, 400, "Cancelar", new Action() {
			
			@Override
			public void doAction() {
				State.changeState(new MenuState());
				
			}
		});
		button3=new Button(Assets.greyBtn, Assets.blueBtn, 600, 400, "Buscar Partida", new Action() {
			
			@Override
			public void doAction() {
				if(id!=0) {
					buscarDB();
					Configuration conf=new Configuration(null);
					conf.setNumeroJugadoresConvertido(numeroJugadores);
					State.changeState(new GameState(conf));
				}
				
			}
		});
	}
	public void buscarDB() {
		
		String sql = "SELECT numeroJugadores FROM configuracion WHERE id=";
		ConexionDB conexion = new ConexionDB();
		con = conexion.getConection();
		try {
			
			Statement stam = con.createStatement();

			ResultSet rs = stam.executeQuery(sql+id);
			
			while(rs.next()) {
				numeroJugadores=rs.getInt("numeroJugadores");
			}
			rs.close();
			stam.close();
			
			
			System.out.println(numeroJugadores);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	@Override
	public void update() {
		text.update();
		button.update();
		button2.update();
		button3.update();
		
	}

	@Override
	public void draw(Graphics g) {
		text.draw(g);
		button.draw(g);
		button2.draw(g);
		button3.draw(g);
		
	}

}
