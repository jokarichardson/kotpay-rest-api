package com.richardson.kotpay.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


class LocalDateTimeConverter {
    companion object {
        fun convertToString(data: LocalDateTime?): String? {
            if (data == null)
                return null

            TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
            val dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss", Locale("pt", "BR"));
            return dtf.format(data)
        }

        fun convertToLocalDateTime(data: String?): LocalDateTime? {
            if (data == null)
                return null

            TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
            val dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss", Locale("pt", "BR"));
            return LocalDateTime.parse(data, dtf);
        }
    }
}