package com.mygdx.DidactiGame;

import com.badlogic.gdx.Game;
import com.mygdx.DidactiGame.Auxiliares.Jugadores;
import com.mygdx.DidactiGame.Pantallas.Menus.*;

public class DidactiGame extends Game {

	public static Menu_Inicial menu_inicial;
	public static Menu_Juegos menu_juegos;
	public static Menu_Jugadores menu_jugadores;
	public static Menu_Puntuaciones menu_puntuaciones;
	public static Menu_Datos menu_datos;
	public static Menu_Ranking menu_ranking;

	public static Jugadores jugadores;

	public void create() {
        jugadores = new Jugadores();
		menu_inicial = new Menu_Inicial(this);
        menu_juegos = new Menu_Juegos(this);
        menu_jugadores = new Menu_Jugadores(this);
		menu_puntuaciones = new Menu_Puntuaciones(this);
		menu_datos = new Menu_Datos(this);
		menu_ranking = new Menu_Ranking(this);

		setScreen(menu_inicial);
	}
}
