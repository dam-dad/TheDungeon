package dad.game.engine;

import dad.game.ui.Enemy;

import java.util.ArrayList;
import java.util.List;

/**
 *   Clase que contiene los tilemap y contiene el metodo que carga los tiles que se pintan 
 *   del juego segun el numero de cada posicion del tilemap
 */
public class Tile {

	public static int[][] tileMap1 = {
			{ 2, 2, 2, 2, 2, 2, 4, 4, 2, 2, 2, 2, 2, 2, 2 },
			{ 2, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2 },
			{ 2, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 2 },
			{ 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 2 },
			{ 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 2, 1, 1, 1, 0, 0, 3, 0, 0, 3, 0, 0, 0, 0, 2 },
			{ 2, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 1, 1, 1, 2 },
			{ 2, 0, 0, 3, 0, 0, 0, 0, 2, 0, 0, 1, 1, 1, 2 },
			{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 2 },
			{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
	};

	public static int[][] tileMap2 = {
			{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
			{ 2, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 2, 2, 2, 2, 2, 2, 5, 5, 2, 2, 2, 2, 2, 2, 2 },
	};

	private static double tileLength = 48;
	private static double tileWidth = 48;

	
	/**
	 * Recorremos el tilemap pasado y cargamos un tile según el número que detecta dentro del tilemap
	 * @param Le pasamos por parametro el tilemap y lo recorremos
	 * @return
	 */

	public static List<Entity> loadTile(int[][] tileMap) {

		List<Entity> entities = new ArrayList<>();

		int mapLength = tileMap.length;
		int mapWidth = tileMap[0].length;



		for (int i = 0; i < mapLength; i++) {
			for (int j = 0; j < mapWidth; j++) {

				switch (tileMap[i][j]) {
					case 0:
						entities.add(new FloorGrass(j * tileWidth, i * tileLength));
						break;
					case 1:
						entities.add(new LongGrass(j * tileWidth, i * tileLength));
						break;
					case 2:
						entities.add(new Tree(j * tileWidth, i * tileLength));
						break;
					case 3:
						entities.add(new Flower(j * tileWidth, i * tileLength));
						break;
					case 4:
						entities.add(new Map1Transition(j * tileWidth, i * tileLength));
						break;
					case 5:
						entities.add(new Map2Transition(j * tileWidth, i * tileLength));
						break;

				}


			}
		}
		return entities;
	}

	public static double getTileLength() {
		return tileLength;
	}

	public static double getTileWidth() {
		return tileWidth;
	}		
}
