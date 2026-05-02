package com.example.streetviewgame.data

import com.google.android.gms.maps.model.LatLng

data class Location(
    val coordinates: LatLng,
    val country: String,
    val name: String
)

object Locations {
    val gameLocations = listOf(
        Location(LatLng(48.8584, 2.2945), "França", "Torre Eiffel"),
        Location(LatLng(41.8902, 12.4922), "Itália", "Coliseu"),
        Location(LatLng(40.6892, -74.0445), "Estados Unidos", "Estátua da Liberdade"),
        Location(LatLng(35.6586, 139.7454), "Japão", "Torre de Tóquio"),
        Location(LatLng(-22.9519, -43.2105), "Brasil", "Cristo Redentor"),
        Location(LatLng(51.5007, -0.1246), "Reino Unido", "Big Ben"),
        Location(LatLng(29.9792, 31.1342), "Egito", "Pirâmides de Gizé"),
        Location(LatLng(-33.8568, 151.2153), "Austrália", "Ópera de Sydney"),
        Location(LatLng(43.8790, -103.4591), "Estados Unidos", "Monte Rushmore"),
        Location(LatLng(27.1751, 78.0421), "Índia", "Taj Mahal"),
        Location(LatLng(55.7539, 37.6208), "Rússia", "Praça Vermelha"),
        Location(LatLng(40.4319, 116.5704), "China", "Muralha da China"),
        Location(LatLng(48.6360, -1.5115), "França", "Mont Saint-Michel"),
        Location(LatLng(43.7230, 10.3966), "Itália", "Torre de Pisa"),
        Location(LatLng(52.5163, 13.3777), "Alemanha", "Portão de Brandemburgo")
    )
    
    val allCountries = gameLocations.map { it.country }.distinct()
}
