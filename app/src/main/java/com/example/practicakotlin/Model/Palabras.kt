package com.example.practicakotlin.Model

class Palabras {

    fun palabras(tipoDificultad: String){
        val faciles = listOf(
            "GATO", "MESA", "SOL",
            "CASA", "CIELO", "FLOR",
            "LIBRO", "MANO", "PERRO",
            "MAR", "LUNA", "PAN",
            "ROPA", "LUZ", "AGUA"
        )

        val medianas = listOf(
            "ESPEJO", "CAMPANARIO", "HELADERÍA",
            "PELÍCULA", "AUTOMÓVIL", "ESCALERA",
            "JARDINERÍA", "CONSTRUCCIÓN", "TELEVISIÓN",
            "AEROPUERTO", "CALABAZA", "ESTANTERÍA",
            "HOSPITAL", "ESCRITURA", "BICICLETA"
        )

        val dificiles = listOf(
            "PARALELEPÍPEDO", "OTORRINOLARINGOLOGÍA", "ANTICONSTITUCIONALIDAD",
            "ELECTROENCEFALOGRAMA", "SUPERCALIFRAGILISTICOESPIALIDOSO", "ESTERNOCLEIDOMASTOIDEO",
            "INCONMENSURABILIDAD", "CONTRARREVOLUCIONARIO", "DESOXIRRIBONUCLEICO",
            "CLAVICORDIO", "CIRCUNLOCUCIÓN", "HIPOPOTOMONSTROSESQUIPEDALIOFOBIA",
            "TRASCENDENTALISMO", "CRIPTOGRAFÍA", "DESCONTEXTUALIZACIÓN"
        )
    }
}