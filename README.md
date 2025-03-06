## Scenari comunicazione TCP - Client
1- Richiesta di comunicazione del client ad un server non in ascolto. (nessun bind() del server): ConnectException </br>
2- IP o nome host non risolvibili: UnknownHostException </br>
3- Errore nello stabilimento della connessione a causa del raggiungimento del limite di client: IOException </br>
4- Errore nella chiusura della connessione: IOException </br>
