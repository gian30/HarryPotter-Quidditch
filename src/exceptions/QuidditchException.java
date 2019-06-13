package exceptions;

import java.util.Arrays;
import java.util.List;

/**
 * Model exceptions
 *
 * @author mfontana
 */
public class QuidditchException extends CodeException {

    // Exception codes
    public static final int EXIST_TEAM = 0;
    public static final int ERROR_TEAM = 1;
    public static final int EXIST_PLAYER = 2;
    public static final int ERROR_PLAYER = 3;
    public static final int ERROR_AGE = 4;
    public static final int EXIST_MATCH = 5;
    public static final int ERROR_MATCH = 6;
    public static final int ERROR_MODIFY_PLAYER = 7;
    public static final int ERROR_DELETE_PLAYER = 8;
    public static final int ERROR_LOAD_PLAYERS = 9;
    public static final int ERROR_LOAD_CLASSIFICATIONS = 10;
    public static final int ERROR_LOAD_TEAMS = 11;
    public static final int ERROR_LOAD_MATCHES = 12;
    public static final int ERROR_NO_MATCHES = 13;
    public static final int FILL_ALL_FIELDS = 14;
    public static final int WRONG_DATA = 15;
    public static final int ERROR_ID = 16;
    // Exception messages
    private final List<String> messages = Arrays.asList("< ERROR 001: Ya existe un equipo con este nombre >",
            "< ERROR 002: Error al añadir el equipo >", "< ERROR 003: Ya existe un jugador con este nombre >",
            "< ERROR 004: Error al añadir el jugador >", "< ERROR 005: Valor de edad incorrecto>",
            "< ERROR 006: Ya existe un partido con este id! >", "< ERROR 007: Error al añadir el partido >",
            "< ERROR 008: No se ha podido modificar los datos del jugador >",
            "< ERROR 009: No se ha podido borrar el jugador >", "< ERROR 010: Error al cargar los jugadores >",
            "< ERROR 011: Error al cargar la clasificación >", "< ERROR 012: Error al cargar los equipos >",
            "< ERROR 013: Error al cargar los partidos >", "< ERROR 014: No se ha encontrado ningun partido >",
            "< ERROR 015: Por favor rellena todos los campos >", "< ERROR 015: Dato incorrecto >",
            "< ERROR 016: Valor de id incorrecto>");

    public QuidditchException(int code) {
        super(code);
    }

    @Override
    public String getMessage() {
        return messages.get(getCode());
    }
}
