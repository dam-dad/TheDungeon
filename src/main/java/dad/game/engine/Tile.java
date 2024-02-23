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
			{ 20, 17, 17, 17, 17, 41, 4, 4, 40, 17, 17, 41, 6, 8, 40 },
			{ 24, 26, 36, 26, 26, 26, 26, 26, 26, 26, 26, 26, 6, 15, 12 },
			{ 41, 26, 26, 26, 26, 26, 36, 26, 26, 26, 26, 36, 10, 16, 16 },
			{ 12, 12, 12, 7, 26, 26, 26, 26, 26, 26, 26, 26, 26, 36, 39 },
			{ 16, 16, 14, 8, 26, 26, 26, 26, 26, 30, 31, 31, 32, 26, 18 },
			{ 38, 26, 6, 8, 36, 26, 26, 26, 26, 29, 27, 27, 33, 26, 18 },
			{ 24, 36, 6, 15, 7, 26, 26, 26, 26, 29, 27, 27, 33, 26, 18 },
			{ 24, 26, 10, 14, 8, 26, 36, 26, 26, 28, 35, 35, 34, 26, 18 },
			{ 24, 26, 26, 6, 8, 26, 26, 26, 26, 26, 26, 26, 26, 26, 18 },
			{ 23, 19, 38, 6, 8, 39, 19, 19, 19, 19, 19, 19, 19, 19, 22 },
	};

	public static int[][] tileMap2 = {
			{ 17, 17, 17, 17, 17, 17, 17, 44, 46, 43, 43, 47, 44, 17, 21 },
			{ 12, 12, 12, 12, 12, 12, 12, 12, 12, 43, 43, 12, 12, 7, 18 },
			{ 16, 16, 16, 16, 16, 16, 16, 16, 16, 43, 43, 16, 14, 8, 18 },
			{ 45, 26, 26, 26, 39, 19, 38, 36, 26, 26, 26, 26, 6, 8, 18 },
			{ 25, 26, 26, 26, 18, 42, 24, 26, 39, 19, 38, 26, 6, 8, 18 },
			{ 25, 26, 26, 26, 40, 17, 41, 26, 18, 37, 24, 26, 6, 8, 18 },
			{ 38, 26, 36, 26, 26, 26, 26, 26, 40, 17, 41, 26, 6, 8, 18 },
			{ 24, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 6, 8, 18 },
			{ 24, 26, 26, 26, 26, 26, 26, 26, 26, 26, 36, 26, 6, 8, 18 },
			{ 23, 19, 19, 19, 19, 38, 5, 5, 39, 19, 19, 38, 6, 8, 18 },
	};

	public static int[][] tileMap3 = {
			{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
			{ 2, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 38, 0, 0, 0, 0, 2 },
			{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 24, 0, 0, 0, 0, 2 },
			{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
			{ 23, 2, 2, 2, 2, 2, 5, 5, 2, 2, 2, 2, 2, 2, 2 },
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
					case 17:
						entities.add(new Muro2(j * tileWidth, i * tileLength));
						break;
					case 18:
						entities.add(new Muro3(j * tileWidth, i * tileLength));
						break;
					case 19:
						entities.add(new Muro4(j * tileWidth, i * tileLength));
						break;
					case 20:
						entities.add(new EsquinaMuro1(j * tileWidth, i * tileLength));
						break;
					case 21:
						entities.add(new EsquinaMuro2(j * tileWidth, i * tileLength));
						break;
					case 22:
						entities.add(new EsquinaMuro3(j * tileWidth, i * tileLength));
						break;
					case 23:
						entities.add(new EsquinaMuro4(j * tileWidth, i * tileLength));
						break;
					case 24:
						entities.add(new Muro1(j * tileWidth, i * tileLength));
						break;
					case 25:
						entities.add(new CespedDesga(j * tileWidth, i * tileLength));
						break;
					case 26:
						entities.add(new Cesped2(j * tileWidth, i * tileLength));
						break;
					case 27:
						entities.add(new CespedClaro(j * tileWidth, i * tileLength));
						break;
					case 28:
						entities.add(new EsquinaCesped1(j * tileWidth, i * tileLength));
						break;
					case 29:
						entities.add(new LadoCesped1(j * tileWidth, i * tileLength));
						break;
					case 30:
						entities.add(new EsquinaCesped2(j * tileWidth, i * tileLength));
						break;
					case 31:
						entities.add(new LadoCesped2(j * tileWidth, i * tileLength));
						break;
					case 32:
						entities.add(new EsquinaCesped3(j * tileWidth, i * tileLength));
						break;
					case 33:
						entities.add(new LadoCesped3(j * tileWidth, i * tileLength));
						break;
					case 34:
						entities.add(new EsquinaCesped4(j * tileWidth, i * tileLength));
						break;
					case 35:
						entities.add(new LadoCesped4(j * tileWidth, i * tileLength));
						break;
					case 36:
						entities.add(new Flor(j * tileWidth, i * tileLength));
						break;
					case 37:
						entities.add(new cespedMuro(j * tileWidth, i * tileLength));
						break;
					case 38:
						entities.add(new cespedMuro2(j * tileWidth, i * tileLength));
						break;
					case 39:
						entities.add(new cespedMuro3(j * tileWidth, i * tileLength));
						break;
					case 40:
						entities.add(new cespedMuro4(j * tileWidth, i * tileLength));
						break;
					case 41:
						entities.add(new cespedMuro5(j * tileWidth, i * tileLength));
						break;
					case 42:
						entities.add(new florMuro(j * tileWidth, i * tileLength));
						break;
					case 43:
						entities.add(new Puente(j * tileWidth, i * tileLength));
						break;
					case 44:
						entities.add(new ParedLadrillo(j * tileWidth, i * tileLength));
						break;
					case 45:
						entities.add(new CespedMuro6(j * tileWidth, i * tileLength));
						break;
					case 46:
						entities.add(new ParedLadrillo2(j * tileWidth, i * tileLength));
						break;
					case 47:
						entities.add(new ParedLadrillo3(j * tileWidth, i * tileLength));
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