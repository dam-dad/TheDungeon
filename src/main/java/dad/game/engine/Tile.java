package dad.game.engine;

import dad.game.textures.*;
import dad.game.transiciones.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene los tilemap y contiene el metodo que carga los tiles que se pintan
 * del juego segun el numero de cada posicion del tilemap
 */
public class Tile {

    public static int[][] tileMap1 = {
            {20, 17, 17, 17, 17, 41, 4, 4, 40, 17, 17, 41, 6, 8, 40},
            {24, 26, 36, 26, 26, 26, 26, 26, 26, 26, 26, 26, 6, 15, 12},
            {41, 26, 26, 26, 26, 26, 36, 26, 26, 26, 26, 36, 10, 16, 16},
            {12, 12, 12, 7, 26, 26, 26, 26, 26, 26, 26, 26, 26, 36, 39},
            {16, 16, 14, 8, 26, 26, 26, 26, 26, 30, 31, 31, 32, 26, 18},
            {38, 26, 6, 8, 36, 26, 26, 26, 26, 29, 27, 27, 33, 26, 18},
            {41, 36, 6, 15, 7, 26, 26, 26, 26, 29, 27, 27, 33, 26, 18},
            {25, 26, 10, 14, 8, 26, 36, 26, 26, 28, 35, 35, 34, 26, 18},
            {25, 26, 26, 6, 8, 26, 26, 26, 26, 26, 26, 26, 26, 26, 18},
            {19, 19, 38, 6, 8, 39, 19, 19, 19, 19, 19, 19, 19, 19, 22},
    };

    public static int[][] tileMap2 = {
            {17, 17, 17, 17, 17, 17, 17, 44, 46, 89, 89, 47, 44, 17, 21},
            {12, 12, 12, 12, 12, 12, 12, 12, 12, 43, 43, 12, 12, 7, 18},
            {16, 16, 16, 16, 16, 16, 16, 16, 16, 43, 43, 16, 14, 8, 18},
            {45, 26, 26, 39, 19, 38, 26, 36, 26, 26, 26, 26, 6, 8, 18},
            {82, 26, 26, 18, 42, 24, 26, 26, 26, 26, 26, 26, 6, 8, 18},
            {82, 26, 26, 40, 17, 41, 26, 26, 39, 19, 38, 26, 6, 8, 18},
            {38, 26, 36, 26, 26, 26, 26, 26, 18, 37, 24, 26, 6, 8, 18},
            {24, 26, 26, 26, 26, 26, 26, 26, 40, 17, 41, 26, 6, 8, 18},
            {24, 26, 26, 26, 26, 26, 26, 26, 26, 26, 36, 26, 6, 8, 18},
            {23, 19, 19, 19, 19, 38, 5, 5, 39, 19, 19, 38, 6, 8, 18},
    };

    public static int[][] tileMap3 = {
            {20, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 21},
            {24, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 18},
            {24, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 18},
            {24, 49, 49, 49, 49, 9, 12, 12, 12, 7, 35, 35, 35, 35, 40},
            {24, 49, 49, 49, 49, 6, 48, 48, 48, 8, 27, 27, 27, 27, 83},
            {24, 49, 49, 49, 49, 6, 48, 48, 48, 8, 27, 27, 27, 27, 83},
            {24, 49, 49, 49, 49, 10, 16, 16, 16, 11, 31, 31, 31, 31, 39},
            {24, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 18},
            {24, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 18},
            {23, 19, 19, 19, 19, 38, 84, 84, 39, 19, 19, 19, 19, 19, 22},
    };

    public static int[][] tileMap4 = {
            {20, 17, 17, 17, 17, 41, 85, 85, 40, 17, 17, 17, 17, 17, 21},
            {24, 26, 26, 26, 26, 26, 36, 26, 26, 26, 26, 26, 26, 26, 18},
            {24, 26, 36, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 40},
            {24, 9, 12, 12, 12, 12, 7, 26, 26, 36, 9, 12, 12, 12, 12},
            {24, 6, 50, 16, 16, 14, 8, 26, 26, 26, 6, 50, 16, 16, 16},
            {24, 6, 8, 39, 38, 6, 8, 36, 26, 26, 43, 43, 26, 26, 39},
            {24, 6, 8, 40, 41, 6, 8, 26, 26, 26, 43, 43, 26, 26, 40},
            {24, 6, 15, 12, 12, 51, 15, 12, 12, 12, 51, 8, 26, 26, 25},
            {24, 10, 16, 16, 16, 16, 16, 16, 16, 16, 16, 11, 26, 26, 25},
            {23, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19},
    };

    public static int[][] tileMap5 = {
            {56, 56, 56, 56, 56, 80, 44, 44, 46, 91, 91, 47, 44, 44, 79},
            {56, 56, 56, 56, 56, 61, 55, 55, 43, 54, 55, 43, 43, 43, 57},
            {56, 56, 56, 56, 56, 76, 55, 43, 52, 43, 53, 55, 52, 43, 57},
            {56, 56, 56, 56, 56, 61, 52, 43, 54, 55, 43, 43, 43, 54, 77},
            {56, 56, 56, 56, 56, 61, 43, 43, 43, 53, 43, 54, 55, 43, 57},
            {56, 56, 56, 56, 56, 81, 59, 59, 60, 43, 43, 58, 59, 59, 78},
            {56, 56, 56, 56, 56, 56, 56, 56, 61, 55, 55, 77, 56, 56, 56},
            {56, 56, 56, 56, 56, 56, 56, 56, 76, 55, 43, 57, 56, 56, 56},
            {56, 56, 56, 56, 56, 56, 56, 56, 61, 55, 43, 57, 56, 56, 56},
            {56, 56, 56, 56, 56, 56, 56, 56, 61, 90, 90, 57, 56, 56, 56},
    };
    public static int[][] tileMap6 = {
            { 80, 44, 44, 46, 43, 43, 47, 44, 44, 44, 44, 44, 44, 44, 79 },
            { 61, 63, 64, 65, 43, 43, 63, 64, 64, 64, 64, 64, 64, 65, 57 },
            { 61, 70, 72, 67, 43, 43, 69, 68, 68, 68, 68, 68, 73, 66, 77 },
            { 61, 70, 66, 54, 43, 43, 43, 43, 43, 43, 52, 43, 70, 66, 57 },
            { 76, 70, 66, 43, 54, 43, 43, 54, 43, 43, 43, 53, 70, 66, 57 },
            { 61, 70, 66, 52, 43, 43, 53, 43, 43, 43, 43, 43, 70, 66, 57 },
            { 61, 70, 66, 43, 43, 43, 43, 53, 53, 43, 43, 43, 70, 66, 77 },
            { 76, 70, 75, 64, 64, 64, 64, 64, 65, 43, 43, 63, 74, 66, 57 },
            { 61, 69, 68, 68, 68, 68, 68, 68, 67, 43, 43, 69, 68, 67, 57 },
            { 81, 59, 59, 59, 59, 59, 59, 59, 60, 43, 43, 58, 59, 59, 78 },
    };

    public static int[][] tileMap7 = {
            { 80, 44, 44, 46, 43, 43, 47, 44, 44, 44, 44, 44, 44, 44, 79 },
            { 61, 63, 64, 65, 43, 43, 63, 64, 64, 64, 64, 64, 64, 65, 57 },
            { 61, 70, 71, 66, 43, 54, 70, 71, 71, 72, 68, 68, 68, 88, 77 },
            { 61, 70, 71, 66, 52, 43, 69, 68, 68, 67, 53, 43, 43, 86, 57 },
            { 76, 70, 71, 66, 43, 43, 53, 43, 43, 52, 43, 43, 52, 86, 57 },
            { 61, 70, 71, 66, 43, 43, 43, 43, 54, 43, 43, 43, 43, 86, 57 },
            { 61, 70, 71, 66, 43, 52, 63, 64, 64, 65, 54, 43, 43, 86, 77 },
            { 76, 70, 71, 66, 43, 43, 70, 71, 71, 75, 64, 64, 64, 87, 57 },
            { 61, 69, 68, 67, 43, 43, 69, 68, 68, 68, 68, 68, 68, 67, 57 },
            { 81, 59, 59, 60, 43, 43, 58, 59, 59, 59, 59, 59, 59, 59, 78 },
    };

    public static int[][] tileMap8 = {
            { 27, 27, 27, 27, 27, 36, 27, 27, 49, 27,  6, 48, 48, 48, 48 },
            { 27, 36, 27, 27, 27, 27, 27, 27, 27, 27,  6, 48, 48, 48, 48 },
            { 27, 27, 27, 27, 27, 27, 27, 27, 49, 27,  6, 48, 48, 48, 48 },
            { 27, 27, 27, 27, 27, 27, 36, 27, 27, 27,  6, 48, 48, 48, 48 },
            { 27, 27, 27, 27, 27, 27, 27, 27, 27, 27,  6, 48, 48, 48, 48 },
            { 31, 31, 31, 31, 31, 31, 27, 27, 27, 27, 10, 16, 16, 16, 16 },
            { 35, 35, 35, 35, 29, 33, 26, 26, 26, 49, 26, 26, 26, 49, 26 },
            { 26, 36, 26, 26, 29, 33, 26, 26, 26, 36, 26, 26, 26, 26, 26 },
            { 49, 26, 26, 26, 29, 33, 26, 26, 26, 26, 26, 26, 36, 26, 26 },
            { 26, 26, 39, 38, 25, 25, 39, 19, 19, 38, 26, 26, 26, 26, 26 },
    };


    private static double tileLength = 48;
    private static double tileWidth = 48;


    /**
     * Recorremos el tilemap pasado y cargamos un tile según el número que detecta dentro del tilemap
     *
     * @param tileMap pasamos por parametro el tilemap y lo recorremos
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
                    case 48:
                        entities.add(new Rio12(j * tileWidth, i * tileLength));
                        break;
                    case 49:
                        entities.add(new Cespedflor(j * tileWidth, i * tileLength));
                        break;
                    case 50:
                        entities.add(new Rio13(j * tileWidth, i * tileLength));
                        break;
                    case 51:
                        entities.add(new Rio14(j * tileWidth, i * tileLength));
                        break;
                    case 52:
                        entities.add(new Suelo(j * tileWidth, i * tileLength));
                        break;
                    case 53:
                        entities.add(new Suelo2(j * tileWidth, i * tileLength));
                        break;
                    case 54:
                        entities.add(new Suelo3(j * tileWidth, i * tileLength));
                        break;
                    case 55:
                        entities.add(new Suelo4(j * tileWidth, i * tileLength));
                        break;
                    case 56:
                        entities.add(new Negro(j * tileWidth, i * tileLength));
                        break;
                    case 57:
                        entities.add(new ParedLadrillo4(j * tileWidth, i * tileLength));
                        break;
                    case 58:
                        entities.add(new ParedLadrillo5(j * tileWidth, i * tileLength));
                        break;
                    case 59:
                        entities.add(new ParedLadrillo6(j * tileWidth, i * tileLength));
                        break;
                    case 60:
                        entities.add(new ParedLadrillo7(j * tileWidth, i * tileLength));
                        break;
                    case 61:
                        entities.add(new ParedLadrillo8(j * tileWidth, i * tileLength));
                        break;
                    case 63:
                        entities.add(new Agua(j * tileWidth, i * tileLength));
                        break;
                    case 64:
                        entities.add(new Agua2(j * tileWidth, i * tileLength));
                        break;
                    case 65:
                        entities.add(new Agua3(j * tileWidth, i * tileLength));
                        break;
                    case 66:
                        entities.add(new Agua4(j * tileWidth, i * tileLength));
                        break;
                    case 67:
                        entities.add(new Agua5(j * tileWidth, i * tileLength));
                        break;
                    case 68:
                        entities.add(new Agua6(j * tileWidth, i * tileLength));
                        break;
                    case 69:
                        entities.add(new Agua7(j * tileWidth, i * tileLength));
                        break;
                    case 70:
                        entities.add(new Agua8(j * tileWidth, i * tileLength));
                        break;
                    case 71:
                        entities.add(new Agua9(j * tileWidth, i * tileLength));
                        break;
                    case 72:
                        entities.add(new Agua10(j * tileWidth, i * tileLength));
                        break;
                    case 73:
                        entities.add(new Agua11(j * tileWidth, i * tileLength));
                        break;
                    case 74:
                        entities.add(new Agua12(j * tileWidth, i * tileLength));
                        break;
                    case 75:
                        entities.add(new Agua13(j * tileWidth, i * tileLength));
                        break;
                    case 76:
                        entities.add(new ParedLadrillo10(j * tileWidth, i * tileLength));
                        break;
                    case 77:
                        entities.add(new ParedLadrillo11(j * tileWidth, i * tileLength));
                        break;
                    case 78:
                        entities.add(new ParedLadrillo12(j * tileWidth, i * tileLength));
                        break;
                    case 79:
                        entities.add(new ParedLadrillo13(j * tileWidth, i * tileLength));
                        break;
                    case 80:
                        entities.add(new ParedLadrillo14(j * tileWidth, i * tileLength));
                        break;
                    case 81:
                        entities.add(new ParedLadrillo15(j * tileWidth, i * tileLength));
                        break;
                    case 82:
                        entities.add(new Map3Transition(j * tileWidth, i * tileLength));
                        break;
                    case 83:
                        entities.add(new Map3TransitionBack(j * tileWidth, i * tileLength));
                        break;
                    case 84:
                        entities.add(new Map4Transition(j * tileWidth, i * tileLength));
                        break;
                    case 85:
                        entities.add(new Map4TransitionBack(j * tileWidth, i * tileLength));
                        break;
                    case 86:
                        entities.add(new Agua14(j * tileWidth, i * tileLength));
                        break;
                    case 87:
                        entities.add(new Agua15(j * tileWidth, i * tileLength));
                        break;
                    case 88:
                        entities.add(new Agua16(j * tileWidth, i * tileLength));
                        break;
                    case 89:
                        entities.add(new Map5Transition(j * tileWidth, i * tileLength));
                        break;
                    case 90:
                        entities.add(new Map5TransitionBack(j * tileWidth, i * tileLength));
                        break;
                    case 91:
                        entities.add(new Map6Transition(j * tileWidth, i * tileLength));
                        break;
                    case 92:
                        entities.add(new Map6TransitionBack(j * tileWidth, i * tileLength));
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