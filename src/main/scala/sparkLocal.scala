import org.apache.spark.sql.SparkSession

class sparkLocal {
  val spkSession: SparkSession = SparkSession
    .builder()
    .appName("Word Count")
    .master("local[*]")
    .config("spark.driver.allowMultipleContexts" , "true")
    .enableHiveSupport()
    .getOrCreate()

  println("~~ Created Spark Session ~~")
}
