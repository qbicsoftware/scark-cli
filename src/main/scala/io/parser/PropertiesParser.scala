package io.parser

import core.DatabaseProperties

import scala.io.Source

object PropertiesParser {

  def readPropertiesFile(propertiesFileName: String): DatabaseProperties = {
    val lines = Source.fromFile(propertiesFileName).getLines.toList
    val split = for (line <- lines) yield line.split(":")

    // TODO Moms' Spaghetti Bolognese
    var host = split.head(1) + ":" + split.head(2) + ":" + split.head(3)
      .filterNot((x: Char) => x.equals('\"'))
    host = host.replaceAll("\\s", "")
    val port = split(1)(1)
      .filterNot((x: Char) => x.equals('\"'))
      .filterNot((x: Char) => x.isWhitespace)
    val name = split(2)(1)
      .filterNot((x: Char) => x.equals('\"'))
      .filterNot((x: Char) => x.isWhitespace)
    val password = split(3)(1)
      .filterNot((x: Char) => x.equals('\"'))
      .filterNot((x: Char) => x.isWhitespace)
    val user = split(4)(1)
      .filterNot((x: Char) => x.equals('\"'))
      .filterNot((x: Char) => x.isWhitespace)

    DatabaseProperties(host, user, password, port, name)
  }

}