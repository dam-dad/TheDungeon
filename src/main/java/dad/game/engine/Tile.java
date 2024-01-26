package dad.game.engine;

import dad.game.textures.*;

import java.util.ArrayList;
import java.util.List;

/**
 *   Clase que contiene los tilemap y contiene el metodo que carga los tiles que se pintan 
 *   del juego segun el numero de cada posicion del tilemap
 */
public class Tile {

	public static int[][] tileMap1 = {
			{ 2, 2, 2, 2, 2, 2, 4, 4, 2, 2, 2, 2, 2, 2, 2 },
			{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 2, 12, 12, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 2, 16, 14, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 2, 0, 6, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 2, 0, 6, 15, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 2, 0, 10, 14, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 2, 0, 0, 6, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
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
	
	public static int[][] tileMap3 = {
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
					case 6:
						entities.add(new Rio1(j * tileWidth, i * tileLength));
						break;
					case 7:
						entities.add(new Rio2(j * tileWidth, i * tileLength));
						break;
					case 8:
						entities.add(new Rio3(j * tileWidth, i * tileLength));
						break;
					case 9:
						entities.add(new Rio4(j * tileWidth, i * tileLength));
						break;
					case 10:
						entities.add(new Rio5(j * tileWidth, i * tileLength));
						break;
					case 11:
						entities.add(new Rio6(j * tileWidth, i * tileLength));
						break;
					case 12:
						entities.add(new Rio7(j * tileWidth, i * tileLength));
						break;
					case 13:
						entities.add(new Rio8(j * tileWidth, i * tileLength));
						break;
					case 14:
						entities.add(new Rio9(j * tileWidth, i * tileLength));
						break;
					case 15:
						entities.add(new Rio10(j * tileWidth, i * tileLength));
						break;
					case 16:
						entities.add(new Rio11(j * tileWidth, i * tileLength));
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
