package io.cli

import picocli.CommandLine.{Command, Option}

@Command(name = "Benchmark", version = Array("1.0"),
  description = Array("@|bold Benchmark Tool|@ for evaluating the performance of a @|Spark Cluster|@. Run custom SQL Queries inside Spark!"))
class CommandLineOptions {

  @Option(names = Array("-s", "--spark"),
    description = Array("Spark support"))
  var sparkSupport: Boolean = false

  @Option(names = Array("-l", "--local"),
    description = Array("Spark in local mode"))
  var localMode: Boolean = false

  @Option(names = Array("-c", "--config"),
    description = Array("Database config file path."),
    required = true)
  var configFilePath: String = ""

  @Option(names = Array("-t", "--table"),
    description = Array("Table to run query on. Required if using Spark."))
  var table: String = ""

  @Option(names = Array("-q", "--query"),
    description = Array("SQL query to execute."),
    arity = "0..1",
    interactive = true,
    required = true)
  var sqlQuery: String = ""

  @Option(names = Array("-h", "--help"),
    description = Array("Display a help message."),
    usageHelp = true)
  var helpRequested = false
}