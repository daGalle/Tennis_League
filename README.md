# Tennis_Match_Commands
## El repositorio contiene un sistema desarrollado en Java. La aplicación sirve para la gestión de partidos y torneos de tenis por parte de los arbitros. El uso se hace a traves de comandos que son los siguientes:
 - Registrar un arbitro
    > createRefree name:<nombre>;password:<contraseña>
 - Permite al árbitro iniciar sesión
    > login name:<nombre>;password:<contraseña>
 - Cierra la sesión activa
    > logout
 - Da de alta un nuevo jugador.
    > createPlayer name:<nombre>
 - Lista los jugadores registrados con su información.
    > readPlayers
 - Crea un partido especificando el número de sets y los IDs de los jugadores.
    >createMatch sets:<número de sets>;ids:<id_jugador1,id_jugador2>
 - Marca una falta de servicio para el jugador con el servicio actual.
    > lackService match id:<id_partido>
 - Asigna un punto al jugador que está sirviendo.
    > pointService match id:<id_partido>
 - Asigna un punto al jugador que está restando.
    > pointRest match id:<id_partido>
 - Muestra información detallada de un jugador, incluyendo su historial de
   partidos.
    > readPlayer:<id_jugador> <-r>
 - Muestra los detalles de un partido, incluidos resultados y puntuación.
    > readMatch:<id_partido> <-csv/-json>
